package com.example.mahagatbandhan;

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
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button read = findViewById(R.id.read);
        Button write = findViewById(R.id.write);
        Button act4 = findViewById(R.id.act4);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker dp = findViewById(R.id.dp);
                TimePicker tp = findViewById(R.id.tp);
                String Day = String.valueOf(dp.getDayOfMonth());
                String Month = String.valueOf(dp.getMonth()+1);
                String Year = String.valueOf(dp.getYear());
                String finalDate = Day + "\t" + Month + "\t" + Year + "\t";
                String Hour = String.valueOf(tp.getHour());
                String minute = String.valueOf(tp.getMinute());
                String finaltime = Hour + "\t" + minute;
                try {
                    FileOutputStream fos = openFileOutput("datetime.txt",MODE_PRIVATE);
                    fos.write(finalDate.getBytes());
                    fos.write(finaltime.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.outputDT);
                FileInputStream fis = null;
                try {
                    fis = openFileInput("datetime.txt");
                    int size = fis.available();
                    byte[]buffer = new byte[size];
                    fis.read(buffer);
                    String result = new String(buffer);
                    et.setText(result);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        act4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act4 = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(act4);
            }
        });

    }
}