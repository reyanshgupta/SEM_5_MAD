package com.example.a12oct_sqlite_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    String bookID, bookName, bookAuthor, bookGenre, bookRentPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        db objdatabase = new db(this);
        SQLiteDatabase dbobj = objdatabase.getWritableDatabase();
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText bkName = findViewById(R.id.bookName);
                EditText bkID = findViewById(R.id.bookID);
                EditText bkGenre = findViewById(R.id.bookGenre);
                EditText bkRentPrice = findViewById(R.id.bookRentPrice);
                EditText bkAuthor = findViewById(R.id.bookAuthor);
                bookName = bkName.getText().toString();
                bookGenre = bkGenre.getText().toString();
                bookID = bkID.getText().toString();
                bookAuthor = bkAuthor.getText().toString();
                bookRentPrice = bkRentPrice.getText().toString();
                ContentValues values = new ContentValues();
                values.put("BookID", bookID); // Remove the colon after the column name
                values.put("bookName", bookName);
                values.put("bookAuthor", bookAuthor); // Correct the column name here
                values.put("bookGenre", bookGenre);
                values.put("bookRentPrice", bookRentPrice);

                dbobj.insert("library", null, values);
                SQLiteDatabase dbSel = openOrCreateDatabase("lib1", MODE_PRIVATE, null);
                String selectQuery = "SELECT * FROM library";
                Cursor cursor = dbSel.rawQuery(selectQuery, null);
                Toast.makeText(getApplicationContext(), "No. of records: " + cursor.getCount(), Toast.LENGTH_SHORT).show();
                objdatabase.close();
            }
        });
    }
}
