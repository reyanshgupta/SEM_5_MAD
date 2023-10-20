package com.example.a12oct_sqlite_project;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Update extends AppCompatActivity {

    private EditText edupdateID, edubookID, edubookName, edubookAuthor, edubookGenre, edubookRentPrice;
    private Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edupdateID = findViewById(R.id.IDUpd);
        edubookID = findViewById(R.id.ubookID);
        edubookName = findViewById(R.id.ubookName);
        edubookAuthor = findViewById(R.id.ubookAuthor);
        edubookGenre = findViewById(R.id.ubookGenre);
        edubookRentPrice = findViewById(R.id.ubookRentPrice);
        updateButton = findViewById(R.id.updateBtn);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateID = edupdateID.getText().toString();
                String updatedBookID = edubookID.getText().toString();
                String updatedBookName = edubookName.getText().toString();
                String updatedBookAuthor = edubookAuthor.getText().toString();
                String updatedBookGenre = edubookGenre.getText().toString();
                String updatedBookRentPrice = edubookRentPrice.getText().toString();

                ContentValues values = new ContentValues();
                values.put("BookID", updatedBookID);
                values.put("bookName", updatedBookName);
                values.put("bookAuthor", updatedBookAuthor);
                values.put("bookGenre", updatedBookGenre);
                values.put("bookRentPrice", updatedBookRentPrice);

                db objdatabase = new db(Update.this);
                SQLiteDatabase db1 = objdatabase.getWritableDatabase();
                int numberofrowsupdated = db1.update("library", values, "bookID="+updateID, null);

                if (numberofrowsupdated > 0) {
                    Toast.makeText(Update.this, "Update Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Update.this, "Update Unsuccessful", Toast.LENGTH_SHORT).show();
                }
                objdatabase.close();
            }
        });
    }
}
