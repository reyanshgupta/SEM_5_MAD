package com.example.backtobasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText output1 = findViewById(R.id.data1et);
        EditText output2 = findViewById(R.id.data2et);

        //Getting Intent
        Intent i2 = getIntent();
        String data1str = i2.getStringExtra(MainActivity.data1);
        int data2int = i2.getIntExtra(MainActivity.data2,0);
        String data2inttostr = String.valueOf(data2int);
        //Setting value on EditText widget
        output1.setText(data1str);
        output2.setText(data2inttostr);
    }
}