package com.example.camerawebviewimagealertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static int CAMERA_REQUEST = 1188; //Camera request number
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cambutton = findViewById(R.id.cambutton);
        Button submit = findViewById(R.id.submit);
        cambutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Camera
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        //Checkboxes
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb1 = findViewById(R.id.check1);
                CheckBox cb2 = findViewById(R.id.check2);
                CheckBox cb3 = findViewById(R.id.check3);
                EditText et1 = findViewById(R.id.et1);

                //For storing the CheckBox outcome to a file
                try {
                    FileOutputStream fos = openFileOutput("check.txt", MODE_PRIVATE);
                    if (cb1.isChecked()) {
                        fos.write((cb1.getText().toString() + " ").getBytes());
                    }
                    if (cb2.isChecked()) {
                        fos.write((cb2.getText().toString() + " ").getBytes());
                    }
                    if (cb3.isChecked()) {
                        fos.write((cb3.getText().toString() + " ").getBytes());
                    }
                    fos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    FileInputStream fis = openFileInput("check.txt");
                    int size = fis.available();
                    byte[] buffer = new byte[size];
                    fis.read(buffer);
                    String text = new String(buffer);
                    et1.setText(text);
                    fis.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
        //Radio
        public void checked (View view){
        //Radio button toast
            RadioGroup rg = findViewById(R.id.radiogrp);
            RadioButton rb;
            int rbid = rg.getCheckedRadioButtonId();
            rb = findViewById(rbid);
            Toast.makeText(MainActivity.this, "Radio Button Selected: " + rb.getText(), Toast.LENGTH_SHORT).show();
        }
        public void newAct (View view){
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        }
    }
