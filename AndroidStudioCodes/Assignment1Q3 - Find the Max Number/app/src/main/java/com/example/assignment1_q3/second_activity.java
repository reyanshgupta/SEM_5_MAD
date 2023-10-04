package com.example.assignment1_q3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import org.w3c.dom.Text;

public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EditText res = findViewById(R.id.res);
        Intent i = getIntent();
        int max = i.getIntExtra(MainActivity.ex, 0);
        res.setText("Max number is: "+max);

    }
}