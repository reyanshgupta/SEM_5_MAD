package com.example.a16oct_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateData extends AppCompatActivity {
    String name, department, rollNo;
    FirebaseDatabase db;
    DatabaseReference reference;
    EditText ed1,ed2,ed3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.department);
        ed3 = findViewById(R.id.rollNo);
        b1 = findViewById(R.id.update);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = ed1.getText().toString();
                department = ed2.getText().toString();
                rollNo = ed3.getText().toString();
                updateUser(name, department, rollNo);
            }

            private void updateUser(String name, String department, String rollNo) {
                HashMap user = new HashMap();
                user.put("name",name);
                user.put("department",department);
                user.put("rollNo",rollNo);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("updatehelper");
                reference.child(name).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        Toast.makeText(UpdateData.this, "Data Updated", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}