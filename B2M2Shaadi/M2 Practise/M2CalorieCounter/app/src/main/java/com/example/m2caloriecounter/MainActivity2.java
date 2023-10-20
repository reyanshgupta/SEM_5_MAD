package com.example.m2caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] foodItems = {"CholeBhature","Nepal","Pizza","Samosa"};
        ListView breakfast = findViewById(R.id.lvbreakfast);
        ListView lunch = findViewById(R.id.lvlunch);
        ListView dinner = findViewById(R.id.lvdinner);
        int[] foodImg = {R.drawable.cholebhature,R.drawable.nepal,R.drawable.pizza,R.drawable.samosa};
        List<HashMap<String,String>> li = new ArrayList<>();
        for (int i = 0; i <4 ;i++){
            HashMap<String,String> hm = new HashMap<>();
            hm.put("Name",foodItems[i]);
            hm.put("Image",foodImg[i]+"");
            li.add(hm);
        }
        String[] from = {"Name","Image"};
        int[] to = {R.id.tv,R.id.iv};
        SimpleAdapter sa = new SimpleAdapter(this, li, R.layout.sa_items, from, to);
        breakfast.setAdapter(sa);
        lunch.setAdapter(sa);
        dinner.setAdapter(sa);
    }
}