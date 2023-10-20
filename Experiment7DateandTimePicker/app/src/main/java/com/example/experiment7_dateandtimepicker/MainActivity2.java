package com.example.experiment7_dateandtimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;

public class MainActivity2 extends AppCompatActivity {
String file_name = "data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i2 = getIntent();
        EditText proj = findViewById(R.id.et3);
        Button read = findViewById(R.id.read);
        Button write = findViewById(R.id.write);
        TextView destination = findViewById(R.id.filedest);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = i2.getStringExtra(MainActivity.namet);
                String dept = i2.getStringExtra(MainActivity.deptt);
                String date = i2.getStringExtra(MainActivity.datet);
                String projname = proj.getText().toString();
                if (projname.length() == 0) {
                    proj.requestFocus();
                    proj.setError("Please enter the project name");
                } else {
                    TimePicker timePicker = findViewById(R.id.tp);
                    int hour = timePicker.getHour();
                    int minute = timePicker.getMinute();
                    String selectedTime = String.format("%02d:%02d", hour, minute);
                    try {
                        FileOutputStream fos = openFileOutput(file_name, MODE_PRIVATE);
                        fos.write(("Name: "+ name + "\n").getBytes());
                        fos.write(("Department: "+ dept + "\n").getBytes());
                        fos.write(("Project Name: "+projname + "\n").getBytes());
                        fos.write(("Date: "+ date + "\n").getBytes());
                        fos.write(("Time: "+ selectedTime + "\n").getBytes());
                        fos.close();
                        Toast.makeText(MainActivity2.this, "Output Saved", Toast.LENGTH_LONG).show();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                try{
                    FileInputStream fis = openFileInput(file_name);
                    int size = fis.available();
                    byte[]buffer = new byte[size];
                    fis.read(buffer);
                    text = new String(buffer);
                    fis.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                destination.setText(text);
            }
        });




    }
}