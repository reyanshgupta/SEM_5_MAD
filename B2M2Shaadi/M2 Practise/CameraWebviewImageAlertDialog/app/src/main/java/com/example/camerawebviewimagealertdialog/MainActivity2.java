package com.example.camerawebviewimagealertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button website = findViewById(R.id.website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText webidet = findViewById(R.id.webid);
                String webid = webidet.getText().toString();

                //Alert Dialog
                AlertDialog.Builder ar = new AlertDialog.Builder(MainActivity2.this);
                ar.setMessage("Where do you want to open this website?");
                ar.setPositiveButton("Browser", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Implicit Intent
                        Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse(webid));
                        startActivity(i2);
                    }
                });
                ar.setNegativeButton("WebView", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //WebView
                        WebView wv = findViewById(R.id.wv);
                        wv.loadUrl(webid);
                    }
                });

                //create AlertDialog
                AlertDialog ad = ar.create();
                ad.show();
            }
        });

    }
}