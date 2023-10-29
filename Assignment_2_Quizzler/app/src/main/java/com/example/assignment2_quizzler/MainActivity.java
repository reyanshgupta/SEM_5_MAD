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
                String password = passwordET.getText().toString();
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] columns = {DbHelper.COLUMN_ID};
                String selection = DbHelper.COLUMN_USERNAME + "=? AND " + DbHelper.COLUMN_PASSWORD + "=?"; // Check both username and password
                String[] selectionArgs = {username, password}; // Provide both username and password

                Cursor cursor = db.query(DbHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
                int cursorCount = cursor.getCount();
                cursor.close();

                if (cursorCount > 0) {
                    Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    // User with the provided username and password exists; allow login
                    // You can navigate to another activity or show a success message
                } else {
                    // User with the provided username and password does not exist; handle this case
                    // For example, show an error message indicating invalid login credentials
                }
            }
        });
    }

    public void registertv(View view){
        Intent i = new Intent(MainActivity.this, RegisterPage.class);
        startActivity(i);
    }
}