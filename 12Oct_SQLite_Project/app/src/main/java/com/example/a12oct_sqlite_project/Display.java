package com.example.a12oct_sqlite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        SQLiteDatabase db = openOrCreateDatabase("lib1",MODE_PRIVATE,null);
        String selectQuery = "SELECT * FROM library";
        Cursor cursor = db.rawQuery(selectQuery,null);
        int entryCount = cursor.getCount();
        if(entryCount==0){
            showMessage("Error","no records found.");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String author = cursor.getString(2);
            String g`enre = cursor.getString(3);
            String rentcost = cursor.getString(4);

            buffer.append("BookID: "+id+"\n");
            buffer.append("BookName: "+name+"\n");
            buffer.append("Author: "+author+"\n");
            buffer.append("Genre: "+genre+"\n");
            buffer.append("Book Rent Price: "+rentcost+"\n");
            buffer.append("------\n");

        }
        showMessage("Books:",buffer.toString());
    }
    private void showMessage(String title, String message) {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setCancelable(true);
        build.setTitle(title);
        build.setMessage(message);
        build.show();
    }

}
