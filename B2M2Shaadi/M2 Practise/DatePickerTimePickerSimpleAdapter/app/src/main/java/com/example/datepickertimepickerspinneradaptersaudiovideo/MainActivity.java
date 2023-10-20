package com.example.datepickertimepickerspinneradaptersaudiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker dp = findViewById(R.id.dp);
        TimePicker tp = findViewById(R.id.tp);
        EditText output = findViewById(R.id.et1);
        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
//DatePicker and TimePicker, putting the data in a file, and reading it.
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput("datetime.txt",MODE_PRIVATE);
                    String date = String.valueOf(dp.getDayOfMonth());
                    String month = String.valueOf(dp.getMonth()); //have to add + 1 since month starts with 0 - create with int and then add 1 then string
                    String year = String.valueOf(dp.getYear());
                    String finalDate = date + ' ' + month + ' ' + year;
                    fos.write("Date: ".getBytes());
                    fos.write((finalDate+" ").getBytes());
                    String hour = String.valueOf(tp.getHour());
                    String minute = String.valueOf(tp.getMinute());
                    String finalTime = hour + " " + minute;
                    fos.write(("Time"+ finalTime).getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    FileInputStream fis = openFileInput("datetime.txt");
                    int size = fis.available();
                    byte[] buffer = new byte[size];
                    fis.read(buffer);
                    String textOutput = new String(buffer);
                    output.setText(textOutput);
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}