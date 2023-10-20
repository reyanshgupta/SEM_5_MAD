package com.example.mahagatbandhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int CAMERA_REQUEST = 1188;
    final public static String checkTransfer = "checkTransfer";
    final public static String intTransfer = "intTransfer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button act2button = findViewById(R.id.act2button);
        act2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb1 = findViewById(R.id.cb1);
                CheckBox cb2 = findViewById(R.id.cb2);
                CheckBox cb3 = findViewById(R.id.cb3);
                EditText intInput = findViewById(R.id.intInput);
                StringBuilder checkSelected = new StringBuilder();
                if(cb1.isChecked()){
                    checkSelected.append(" "+cb1.getText().toString());
                }if(cb2.isChecked()){
                    checkSelected.append(" "+cb2.getText().toString());
                }if(cb3.isChecked()){
                    checkSelected.append(" "+cb3.getText().toString());
                }
                String checkResult = checkSelected.toString();
                String intInputFromUser =intInput.getText().toString();
                if(intInput.getText().toString().isEmpty()){
                    intInput.requestFocus();
                    intInput.setError("Please enter an integer");
                }
                Intent act2 = new Intent(MainActivity.this, MainActivity2.class);
                act2.putExtra(checkTransfer,checkResult);
                act2.putExtra(intTransfer,intInputFromUser);
                startActivity(act2);
            }
        });
    }
    public void clickPicture(View view){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    public void radioCheck(View view){
        RadioGroup rg = findViewById(R.id.radioGroup);
        int checkedID = rg.getCheckedRadioButtonId();
        RadioButton selectedRadio = findViewById(checkedID);
        String radioText = selectedRadio.getText().toString();
        Toast.makeText(this,"Selected Radio: "+ radioText, Toast.LENGTH_LONG).show();
    }

}