package com.example.knowyourstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = findViewById(R.id.length);
        Button bt2 = findViewById(R.id.trim);
        Button bt3 = findViewById(R.id.lowtoup);
        Button bt4 = findViewById(R.id.uptolow);
        EditText et1 = findViewById(R.id.edt);
        TextView tv = findViewById(R.id.res);

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str = et1.getText().toString();
                int len = str.length();
                tv.setText(len + " ");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et1.getText().toString();
                String trimmedStr = str.trim();
                tv.setText(trimmedStr+" ");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et1.getText().toString();
                String upper = str.toUpperCase();
                tv.setText(upper+" ");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et1.getText().toString();
                String lower = str.toLowerCase();
                tv.setText(lower+" ");
            }
        });
    }
}