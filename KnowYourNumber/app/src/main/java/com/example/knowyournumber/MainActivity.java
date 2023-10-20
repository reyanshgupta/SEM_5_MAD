package com.example.knowyournumber;

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

        Button bt1 = findViewById(R.id.factorial);
        Button bt2 = findViewById(R.id.OddEven);
        EditText et1 = findViewById(R.id.edt2);
        TextView tv2 = findViewById(R.id.res);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(et1.getText().toString());
                int i, fact=1;
                for(i=1; i<=num1; i++){
                    fact = fact*i;
                }
                tv2.setText(fact+" ");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(et1.getText().toString());
                if(num1 % 2 == 0){
                    tv2.setText("Number is even");
                }else{
                    tv2.setText("Number is odd");
                }
            }
        });
    }
}