package com.example.backtobasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public static final String data1 = "data1";
public static final String data2 = "data2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt2 = findViewById(R.id.bt2);

        //Implicit Intent using onClickListener
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://qubitechcorp.com"));
                startActivity(i1);
            }
        });
    }

    //Explicit intent with multiple data transfer using onClick attribute


    public void intentDataTransfer(View view){
        EditText d1 = findViewById(R.id.et1);
        EditText d2 = findViewById(R.id.et2);
        String datatbt1 = d1.getText().toString();
        int datatbt2 = Integer.parseInt(d2.getText().toString());
        //Validation
        if (datatbt1.length()==0){
            d1.requestFocus();
            d1.setError("Please enter a value to be sent");
        }
// Send a String and integer value along with the intent
        Intent i2 = new Intent(MainActivity.this, MainActivity2.class);
        i2.putExtra(data1,datatbt1);
        i2.putExtra(data2,datatbt2);
        startActivity(i2);
    }
}


