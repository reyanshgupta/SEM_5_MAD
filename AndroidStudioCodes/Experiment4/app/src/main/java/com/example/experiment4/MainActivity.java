package com.example.experiment4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button datebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        datebutton = findViewById(R.id.btn1);
        datebutton.setText(getTodaysDate());
        String[] veg = {"Broccoli", "Cauliflower", "Onion","Potato","Tomato"};
        int[] vegImages = {R.drawable.broc,R.drawable.cauli,R.drawable.onion,R.drawable.potato,R.drawable.tom};

        ListView slv = (ListView) findViewById(R.id.lv1);
        List<HashMap<String,String>> li = new ArrayList<>();
        for (int i = 0; i<5;i++){
            HashMap<String,String> hm = new HashMap<>();
            hm.put("Name",veg[i]);
            hm.put("Picture",vegImages[i]+"");
            li.add(hm);
        }
        String[] from = {"Name","Picture"};
        int[] to = {R.id.tv,R.id.iv};
        SimpleAdapter Sa = new SimpleAdapter(this, li, R.layout.items_list, from, to);
        slv.setAdapter(Sa);
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month+=1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dayOfMonth,month,year);
    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return getMonthFormat(month)+" "+dayOfMonth+" "+year;
    }

    private String getMonthFormat(int month) {
        if(month==1)
            return "JAN";
        if(month==2)
            return "FEB";
        if(month==3)
            return "MAR";
        if(month==4)
            return "APR";
        if(month==5)
            return "MAY";
        if(month==6)
            return "JUNE";
        if(month==7)
            return "JUL";
        if(month==8)
            return "AUG";
        if(month==9)
            return "SEPT";
        if(month==10)
            return "OCT";
        if(month==11)
            return "NOV";
        if(month==12)
            return "DEC";
        return "JAN";
    }

    public void startDatePicker(View view){
        datePickerDialog.show();
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dsl = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
                month += 1;
                String date = makeDateString(dayOfMonth, month, year);
                datebutton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month+=1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
//        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,dsl,year,month,dayOfMonth);
    }
}
