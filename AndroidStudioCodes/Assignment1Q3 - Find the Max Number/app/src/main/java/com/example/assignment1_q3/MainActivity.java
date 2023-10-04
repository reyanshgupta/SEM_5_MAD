package com.example.assignment1_q3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String ex = "ex";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Calculate(View view){
        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        EditText et3 = findViewById(R.id.et3);
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int num3 = Integer.parseInt(et3.getText().toString());
        int max = num1;
        if (num1>num2 && num1>num3){
            max = num1;
        } else if (num2>num1 && num2 > num3) {
            max = num2;
        }
        else{
            max=num3;
        }
        Intent i = new Intent(MainActivity.this, second_activity.class);
        i.putExtra("ex",max);
        startActivity(i);
    }
}