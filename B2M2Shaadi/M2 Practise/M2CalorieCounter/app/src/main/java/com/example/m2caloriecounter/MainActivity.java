package com.example.m2caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.name);
        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameSt = name.getText().toString();
                String weightSt = height.getText().toString();
                String heightSt = weight.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput("details.txt",MODE_PRIVATE);
                    fos.write(("Name" + nameSt + "\t").getBytes());
                    fos.write(("Weight" + weightSt + "\t").getBytes());
                    fos.write(("Height" + heightSt + "\t").getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Intent act2 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(act2);
            }
        });

    }
}