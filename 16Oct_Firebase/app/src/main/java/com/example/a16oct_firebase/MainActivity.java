package com.example.a16oct_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    String name, department, rollNo;
    FirebaseDatabase db;
    DatabaseReference reference;
    EditText ed1,ed2,ed3;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.department);
        ed3 = findViewById(R.id.rollNo);
        b1 = findViewById(R.id.save);
        b2 = findViewById(R.id.update);
        db = FirebaseDatabase.getInstance();
        reference = db.getReference("updatehelper");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = ed1.getText().toString();
                department = ed2.getText().toString();
                rollNo = ed3.getText().toString();
                if(!name.isEmpty() && !department.isEmpty() && !rollNo.isEmpty()){
                    updatehelper uh = new updatehelper(name, department, rollNo);
                    reference.child(name).setValue(uh).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            ed1.setText("");
                            ed2.setText("");
                            ed3.setText("");
                            Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UpdateData.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, DisplayData.class);
            }
        });
    }
}