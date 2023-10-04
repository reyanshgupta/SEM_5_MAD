package com.example.radiocheckboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        CheckBox cb1,cb2,cb3;
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        Button b1;
        b1 = findViewById(R.id.bt);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalitems = 0;
                StringBuilder res = new StringBuilder();
                res.append("Selected Items: ");
                if (cb1.isChecked()){
                    res.append("You clicked cb1");
                    totalitems += 1;
                }
                if (cb2.isChecked()){
                    res.append("You clicked cb2");
                    totalitems += 1;
                }
                if (cb3.isChecked()){
                    res.append("You clicked cb3");
                    totalitems += 1;
                }
               res.append("Total items ordered: " + totalitems);
                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void checked(View view){
        int rid = rg.getCheckedRadioButtonId();
        rb = findViewById(rid);
        Toast.makeText(this,"Radio Button Selected" + rb.getText(), Toast.LENGTH_LONG).show();
    }
}