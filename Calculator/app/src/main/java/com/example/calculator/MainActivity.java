package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.plus);
        Button sub = findViewById(R.id.minus);
        Button mul = findViewById(R.id.mult);
        Button div = findViewById(R.id.divide);
        EditText num1 = findViewById(R.id.et1);
        EditText num2 = findViewById(R.id.et2);
        TextView res = findViewById(R.id.res);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = num1.getText().toString();
                double n1 = Double.parseDouble(a);
                String b = num2.getText().toString();
                double n2 = Double.parseDouble(b);
                double result = n1 + n2;
                res.setText("" + result);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = num1.getText().toString();
                double n1 = Double.parseDouble(a);
                String b = num2.getText().toString();
                double n2 = Double.parseDouble(b);
                double result = n1 - n2;
                res.setText("" + result);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = num1.getText().toString();
                double n1 = Double.parseDouble(a);
                String b = num2.getText().toString();
                double n2 = Double.parseDouble(b);
                double result = n1 * n2;
                res.setText("" + result);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = num1.getText().toString();
                double n1 = Double.parseDouble(a);
                String b = num2.getText().toString();
                double n2 = Double.parseDouble(b);
                double result = n1 / n2;
                res.setText("" + result);
            }
        });
    }
}