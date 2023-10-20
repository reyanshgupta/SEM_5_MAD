package com.example.datepickertimepickerspinneradaptersaudiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Using Adapter to populate ListView
        ListView lv = findViewById(R.id.lv);
        String[] veg = {"Broccoli", "Cauliflower", "Onion","Potato","Tomato"};
        int[] vegImages = {R.drawable.broc,R.drawable.cauli,R.drawable.onion,R.drawable.potato,R.drawable.tom};
        List<HashMap<String,String>> li= new ArrayList<>();
        for (int i = 0; i<5;i++){
            HashMap<String,String> hm = new HashMap<>();
            hm.put("Name",veg[i]);
            hm.put("Image",vegImages[i]+" ");
            li.add(hm);
        }
        String[] from = {"Name","Image"};
        int[] to = {R.id.tv,R.id.iv};
        SimpleAdapter sa = new SimpleAdapter(this, li, R.layout.items_list, from, to);
        lv.setAdapter(sa);
    }
}