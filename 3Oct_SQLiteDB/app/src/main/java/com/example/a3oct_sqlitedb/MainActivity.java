package com.example.a3oct_sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView meow = findViewById(R.id.meow);
        File path = getApplication().getFilesDir();
        String s = path+"/"+"data";
        meow.setText("Database path: "+s);
        try{
            db = this.openOrCreateDatabase("data", MODE_PRIVATE, null);
            db.close();
        } catch (SQLException e) {
            meow.append("Error occurred: "+ e.getMessage());
        }
    }
}