package com.example.a7oct_practise_question_m2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText noOfDays = findViewById(R.id.noofdays);
        EditText noOfGuests = findViewById(R.id.noofguests);
        Button photographer = findViewById(R.id.photograph);
        Button bridalSalon = findViewById(R.id.bridalSalon);
        Button beautyArtist = findViewById(R.id.beautyArtist);
        Button florist = findViewById(R.id.florist);
        Button DJ = findViewById(R.id.dj);
        Button catering = findViewById(R.id.catering);

        photographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PhotographerFragment());
            }
        });
        bridalSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new BridalSalonFragment());
            }
        });
        beautyArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new BeautyArtistFragment());
            }
        });
        florist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FloristFragment());
            }
        });
        DJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DJFragment());
            }
        });
        catering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new CateringFragment());
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null); // Add the transaction to the back stack
        fragmentTransaction.commit();
    }
}