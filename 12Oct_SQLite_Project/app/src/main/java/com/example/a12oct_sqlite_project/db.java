package com.example.a12oct_sqlite_project;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class db extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "lib1";
    public db(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE library(bookNo INTEGER PRIMARY KEY AUTOINCREMENT, bookID INTEGER NOT NULL, bookName TEXT NOT NULL, bookAuthor TEXT NOT NULL, bookGenre TEXT NOT NULL, bookRentPrice INTEGER NOT NULL "+")";
        db.execSQL(CREATE_USER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
