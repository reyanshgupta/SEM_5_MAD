package com.example.assignment2_quizzler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MADQ3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MADQ3Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String score;

    public MADQ3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MADQ3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MADQ3Fragment newInstance(String param1, String param2) {
        MADQ3Fragment fragment = new MADQ3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_m_a_d_q3, container, false);

        RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        Button submitButton = rootView.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentscoreint = 0;
                try {
                    FileInputStream fis = requireActivity().openFileInput("currentscore.txt");
                    int size = fis.available();
                    byte buffer[] = new byte[size];
                    fis.read(buffer);
                    String currentscore = new String(buffer);
                    currentscoreint = Integer.parseInt(currentscore);
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.answer_choice_2) {
                    currentscoreint += 200;
                    Toast.makeText(getContext(), "Correct Answer!", Toast.LENGTH_SHORT).show();
                }
                else{
                    currentscoreint -= 100;
                    Toast.makeText(getContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
                }
                try {
                    FileOutputStream fos = requireActivity().openFileOutput("currentscore.txt", Context.MODE_PRIVATE);
                    String newScore = String.valueOf(currentscoreint);
                    fos.write(newScore.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ((MADActivity) requireActivity()).saveFinalScore();
                Handler handler = new Handler();
                int delayMilliseconds = 3000;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getContext(), LandingPage.class);
                        startActivity(intent);
                    }
                }, delayMilliseconds);
                ((MADActivity) requireActivity()).loadNextQuestion();
            }
        });
        return rootView;
    }
}