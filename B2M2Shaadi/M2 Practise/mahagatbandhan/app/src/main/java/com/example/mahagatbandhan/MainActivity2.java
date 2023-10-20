package com.example.mahagatbandhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText checkOutput = findViewById(R.id.checkOutput);
        EditText intOutput = findViewById(R.id.intOutput);
        Button act3 = findViewById(R.id.act3);
        Intent getIntent = getIntent();
        String check = getIntent.getStringExtra(MainActivity.checkTransfer);
        String intout = getIntent.getStringExtra(MainActivity.intTransfer);
        checkOutput.setText(check);
        intOutput.setText(intout);

        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3 = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(act3);
            }
        });

    }
}