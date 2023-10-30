package com.example.assignment2_quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MADActivity extends AppCompatActivity {
    private TextView currentScore;
    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madactivity);
        dbHelper = new DbHelper(this);
        deleteFile("currentscore.txt");
        try {
            FileOutputStream fos = openFileOutput("currentscore.txt",MODE_APPEND);
            int initScore = 0;
            String scorevalinit = String.valueOf(initScore);
            fos.write(scorevalinit.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_mad, new MADQ1Fragment())
                    .commit();
        }
    }
    private int currentQuestion = 1;
    public void loadNextQuestion() {
        if (currentQuestion == 1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_mad, new MADQ2Fragment())
                    .addToBackStack(null)
                    .commit();
        } else if (currentQuestion == 2) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_mad, new MADQ3Fragment())
                    .addToBackStack(null)
                    .commit();
        }
        else if(currentQuestion==3){
            ScoreUpdate();
        }
        currentQuestion++;
        ScoreUpdate();
    }
    public void ScoreUpdate(){
        currentScore = findViewById(R.id.currentScore);
        try {
            FileInputStream fis = openFileInput("currentscore.txt");
            int size = fis.available();
            byte buffer[] = new byte[size];
            fis.read(buffer);
            String currentScoreVal = new String(buffer);
            currentScore.setText("Current Score: " + currentScoreVal);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveFinalScore() {
        String username;
        String finalScoreVal;
        try {
            FileInputStream fis = openFileInput("currentloggedinuser.txt");
            int size = fis.available();
            byte buffer[] = new byte[size];
            fis.read(buffer);
            username = new String(buffer);
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis2 = openFileInput("currentscore.txt");
            int size = fis2.available();
            byte buffer[] = new byte[size];
            fis2.read(buffer);
            finalScoreVal = new String(buffer);
            fis2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_SCORE, finalScoreVal);

        String selection = DbHelper.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        int numRowsUpdated = db.update(DbHelper.TABLE_NAME, values, selection, selectionArgs);
        if (numRowsUpdated > 0) {
            Toast.makeText(this, "Final Score: " + finalScoreVal, Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}