package com.example.a12oct_sqlite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Insert = findViewById(R.id.insert);
        Button Display = findViewById(R.id.display);
        Button Delete = findViewById(R.id.delete);
        Button Update = findViewById(R.id.update);

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insActivity = new Intent(MainActivity.this, com.example.a12oct_sqlite_project.Insert.class);
                startActivity(insActivity);
            }
        });
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disAct = new Intent(MainActivity.this, com.example.a12oct_sqlite_project.Display.class);
                startActivity(disAct);
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delAct = new Intent(MainActivity.this, com.example.a12oct_sqlite_project.Delete.class);
                startActivity(delAct);
            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upAct = new Intent(MainActivity.this, com.example.a12oct_sqlite_project.Update.class);
                startActivity(upAct);
            }
        });

    }
}