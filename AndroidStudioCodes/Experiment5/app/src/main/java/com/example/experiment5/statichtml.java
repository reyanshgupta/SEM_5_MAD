package com.example.experiment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class statichtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statichtml);
        WebView wv1 = findViewById(R.id.wv1);
        String s = "<html>\n" +
                "    <body>\n" +
                "        <h1>Welcome to NMIMS</h1>\n" +
                "        <p>Static Web HTML content</p>\n" +
                "    </body>\n" +
                "</html>";
        wv1.loadData(s,"text/html","UTF-8");

    }
}