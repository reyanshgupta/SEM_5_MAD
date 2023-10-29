package com.example.assignment2_quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usernameET, passwordET;
        Button Login;
        Login = findViewById(R.id.loginbutton);
        usernameET=findViewById(R.id.loginusername);
        passwordET=findViewById(R.id.loginpass);
        dbHelper = new DbHelper(this);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameET.getText().toString();
                if (username.isEmpty()){
                    usernameET.setError("Username can't be empty");
                    usernameET.requestFocus();
                }
                String password = passwordET.getText().toString();
                if (password.isEmpty()){
                    passwordET.setError("Password can't be empty");
                    passwordET.requestFocus();
                }
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] columns = {DbHelper.COLUMN_ID};
                String selection = DbHelper.COLUMN_USERNAME + "=? AND " + DbHelper.COLUMN_PASSWORD + "=?"; // Check both username and password
                String[] selectionArgs = {username, password}; // Provide both username and password

                Cursor cursor = db.query(DbHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
                int cursorCount = cursor.getCount();
                cursor.close();

                if (cursorCount > 0) {
                    Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    deleteFile("currentloggedinuser.txt");
                    try {
                        FileOutputStream fos = openFileOutput("currentloggedinuser.txt",MODE_APPEND);
                        fos.write(username.getBytes());
                        fos.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    startActivity(new Intent(MainActivity.this,LandingPage.class));;
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials, Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registertv(View view){
        Intent i = new Intent(MainActivity.this, RegisterPage.class);
        startActivity(i);
    }
}