package com.example.a9oct_sqlitequeries;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db1;
    private EditText edn, edno, edd;
    private TextView txtMsg1, txtMsg2, txtMsg3;
    private Button Register, Show,Delete,Update;
    String Name, Number, Department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db objdatabase = new db(this);
        db1 = objdatabase.getWritableDatabase();
        edn = findViewById(R.id.employeeName);
        edno = findViewById(R.id.employeeNo);
        edd = findViewById(R.id.employeeDept);
        txtMsg1 = findViewById(R.id.displayName);
        txtMsg2 = findViewById(R.id.displayNo);
        txtMsg3 = findViewById(R.id.displayDepartment);
        Register = findViewById(R.id.save);
        Show = findViewById(R.id.display);
        Delete = findViewById(R.id.delete);
        Update = findViewById(R.id.update);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser(7);
            }
        });

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = openOrCreateDatabase("tt7",MODE_PRIVATE,null);
                String selectQuery = "SELECT * FROM userdetails2";
                Cursor cursor = db.rawQuery(selectQuery,null);
                int entryCount = cursor.getCount();
                if(entryCount==0){
                    showMessage("Error","no records found.");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(cursor.moveToNext()){
                    String n = cursor.getString(1);
                    String no = cursor.getString(2);
                    String de = cursor.getString(3);


                    buffer.append("Name: "+n+"\n");
                    buffer.append("Number: "+no+"\n");
                    buffer.append("Dept: "+de+"\n");
                    buffer.append("------\n");

                }
                showMessage("Employee Details",buffer.toString());
            }
        });

    }
    private void showMessage(String title, String message) {
        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
        build.setCancelable(true);
        build.setTitle(title);
        build.setMessage(message);
        build.show();
    }

    private void registerUser() {
        String empName, empNo, empDept;
        db objdatabase = new db(this);
        empName = edn.getText().toString();
        empNo = edn.getText().toString();
        empDept = edd.getText().toString();
        ContentValues values = new ContentValues();
        values.put("Name",empName);
        values.put("EmpNumber",empNo);
        values.put("Dept",empDept);
        long ID = db1.insert("userdetails2",null,values);
        Toast.makeText(MainActivity.this, "No. of records: "+ID,Toast.LENGTH_SHORT).show();
        objdatabase.close();
    }

    public void deleteUser(int i){
        String table_name = "userdetails2";
        int numberofrows= db1.delete(table_name,"id="+i,null);
        if (numberofrows>=0){
            Toast.makeText(getApplicationContext(),"Delete Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Delete Unsuccesful", Toast.LENGTH_SHORT).show();
        }
    }
    public void updateUser(int i){
        String tablename = "userdetails2";
        db objdatabase = new db(this);
        db1 = objdatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Dept","Finance");
        int numberofrowsupdated = db1.update(tablename,values,"id="+i,null);
        if (numberofrowsupdated>0){
            Toast.makeText(getApplicationContext(),"Update Successful",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Update Unsuccessful",Toast.LENGTH_SHORT).show();
        }
    }
}