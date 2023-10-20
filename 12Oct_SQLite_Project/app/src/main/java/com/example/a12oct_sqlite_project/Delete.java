package com.example.a12oct_sqlite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        db objdatabase = new db(this);
        SQLiteDatabase db1 = objdatabase.getWritableDatabase();

        Button deleteID = findViewById(R.id.deleteID);
        Button deleteName = findViewById(R.id.deleteName);

        deleteID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText EDid = findViewById(R.id.IDDel);
                String id = EDid.getText().toString();
                String table_name = "library";
                int numberofrows= db1.delete(table_name,"bookID="+id,null);
                if (numberofrows>=0){
                    Toast.makeText(getApplicationContext(),"Delete Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Delete Unsuccesful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText EDName = findViewById(R.id.IDDel);
                String name = EDName.getText().toString();
                String table_name = "library";
                int numberofrows= db1.delete(table_name,"bookName="+name,null);
                if (numberofrows>=0){
                    Toast.makeText(getApplicationContext(),"Delete Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Delete Unsuccesful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}