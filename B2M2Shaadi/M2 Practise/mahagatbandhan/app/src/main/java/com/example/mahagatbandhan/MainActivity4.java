package com.example.mahagatbandhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] website = {"www.google.com","www.qubitechcorp.com","www.globalsummit.heatlh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button nextact5 = findViewById(R.id.act5);
        List<HashMap<String, String>> li = new ArrayList<>();
        ListView lv = findViewById(R.id.lv);
        Spinner spin = findViewById(R.id.spinner);
        String[] veg = {"Broc", "Onion", "Cauli"};
        int[] vegImages = {R.drawable.broc, R.drawable.onion, R.drawable.cauli};
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("Name", veg[i]);
            hm.put("Image", vegImages[i] + "");
            li.add(hm);
        }
        String[] from = {"Name", "Image"};
        int[] to = {R.id.tv, R.id.iv};
        SimpleAdapter sa = new SimpleAdapter(getApplicationContext(), li, R.layout.lv_layout, from, to);
        lv.setAdapter(sa);

        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, website);
        aa.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spin.setOnItemSelectedListener(MainActivity4.this);
        spin.setAdapter(aa);
        nextact5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(i5);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int a = i+1;
        Toast.makeText(getApplicationContext(), website[i],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}