package com.example.experiment7_dateandtimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final String namet = "namet";
    public static final String deptt = "deptt";
    public static final String datet = "datet";

    private EditText et1;
    private EditText et2;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.bt1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        datePicker = findViewById(R.id.dp);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et1.getText().toString();
                String dept = et2.getText().toString();

                if (name.length() == 0) {
                    et1.requestFocus();
                    et1.setError("Please enter your name");
                } else if (dept.length() == 0) {
                    et2.requestFocus();
                    et2.setError("Please enter the department");
                } else {
                    int year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    int day = datePicker.getDayOfMonth();
                    String selectedDate = day + "\t" + month + "\t" + year;

                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra(namet, name);
                    i.putExtra(deptt, dept);
                    i.putExtra(datet, selectedDate);
                    startActivity(i);
                }
            }
        });
    }
}
