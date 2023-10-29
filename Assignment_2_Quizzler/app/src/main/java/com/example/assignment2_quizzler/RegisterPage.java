package com.example.assignment2_quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        dbHelper = new DbHelper(this);

        Button registerButton = findViewById(R.id.registerbutton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input from EditText fields
                EditText fullNameET = findViewById(R.id.registerfull);
                EditText usernameET = findViewById(R.id.registeruser);
                EditText emailET = findViewById(R.id.registeremail);
                EditText ageET = findViewById(R.id.registerage);
                EditText passwordET = findViewById(R.id.registerpass);

                String fullName = fullNameET.getText().toString();
                String username = usernameET.getText().toString();
                String email = emailET.getText().toString();
                int age = Integer.parseInt(ageET.getText().toString());
                String password = passwordET.getText().toString();

                // Call addUser to insert user information into the database
                long userId = addUser(fullName, username, email, age, password);

                if (userId != -1) {
                    // User registration successful
                    // You can navigate to another activity or show a success message
                } else {
                    // User registration failed
                    // Handle the error, e.g., show an error message
                }
            }
        });
    }

    public long addUser(String name, String username, String email, int age, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Check if the provided username or email already exists in the database
        if (isUsernameExists(db, username) || isEmailExists(db, email)) {
            Toast.makeText(this, "User already exists, please login instead", Toast.LENGTH_LONG).show();
            return -1;
        }
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, name);
        values.put(DbHelper.COLUMN_USERNAME, username);
        values.put(DbHelper.COLUMN_EMAIL, email);
        values.put(DbHelper.COLUMN_AGE, age);
        values.put(DbHelper.COLUMN_PASSWORD, password);
        Toast.makeText(this, "User successfully registered! Happy Quizzing!.", Toast.LENGTH_SHORT).show();
        return db.insert(DbHelper.TABLE_NAME, null, values);
    }
    private boolean isUsernameExists(SQLiteDatabase db, String username) {
        String selection = DbHelper.COLUMN_USERNAME + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(DbHelper.TABLE_NAME, null, selection, selectionArgs, null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
    private boolean isEmailExists(SQLiteDatabase db, String email) {
        String selection = DbHelper.COLUMN_EMAIL + "=?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(DbHelper.TABLE_NAME, null, selection, selectionArgs, null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}