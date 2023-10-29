package com.example.assignment2_quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LandingPage extends AppCompatActivity {
    TextView usernameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        usernameTV = findViewById(R.id.usernameDisplay);
        try {
            FileInputStream fis = openFileInput("currentloggedinuser.txt");
            int size = fis.available();
            byte buffer[] = new byte[size];
            fis.read(buffer);
            String username = new String(buffer);
            usernameTV.setText("Welcome "+username);
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}