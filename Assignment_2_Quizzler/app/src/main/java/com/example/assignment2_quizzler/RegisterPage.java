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
                // Call the validateInputs function to check input validity
                if (validateInputs()) {
                    // If inputs are valid, proceed with registration
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
                    addUser(fullName, username, email, age, password);
                }
            }
        });
    }

    private boolean validateInputs() {
        EditText fullNameET = findViewById(R.id.registerfull);
        EditText usernameET = findViewById(R.id.registeruser);
        EditText emailET = findViewById(R.id.registeremail);
        EditText ageET = findViewById(R.id.registerage);
        EditText passwordET = findViewById(R.id.registerpass);

        String fullName = fullNameET.getText().toString();
        String username = usernameET.getText().toString();
        String email = emailET.getText().toString();
        String ageStr = ageET.getText().toString();
        String password = passwordET.getText().toString();

        boolean isValid = true;

        if (fullName.isEmpty()) {
            fullNameET.setError("Please enter a name");
            fullNameET.requestFocus();
            isValid = false;
        }

        if (username.isEmpty()) {
            usernameET.setError("Username can't be empty");
            usernameET.requestFocus();
            isValid = false;
        }

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty() || !email.matches(emailPattern)) {
            emailET.setError("Invalid email format");
            emailET.requestFocus();
            isValid = false;
        }

        if (ageStr.isEmpty() || Integer.parseInt(ageStr) <= 0) {
            ageET.setError("Please enter a valid positive age");
            ageET.requestFocus();
            isValid = false;
        }

        if (password.isEmpty()) {
            passwordET.setError("Password can't be empty");
            passwordET.requestFocus();
            isValid = false;
        }

        return isValid;
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
