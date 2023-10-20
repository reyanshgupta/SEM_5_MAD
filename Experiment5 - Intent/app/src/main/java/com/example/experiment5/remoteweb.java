package com.example.experiment5;

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
import android.widget.Toast;

import java.net.URI;

public class remoteweb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remoteweb);
        WebView wv2 = findViewById(R.id.wv2);
        EditText et1 = findViewById(R.id.et1);
        Button bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et1.getText().toString();
                if (s.length() == 0) {
                    et1.requestFocus();
                    et1.setError("URL can't be empty, please enter a URL");
                } else if (isValid(s)) {
                    wv2.loadUrl(s);
                    AlertDialog.Builder alertdialogue = new AlertDialog.Builder(remoteweb.this);
                    alertdialogue.setMessage("Do you want to open the URL in your browser?");
                    alertdialogue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
                            startActivity(i3);
                        }
                    });
                    alertdialogue.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(remoteweb.this, "You selected no", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog = alertdialogue.create();
                    alertDialog.show();
                } else {
                    et1.setError("Wrong URL format");
                }
            }
        });
    }

    private boolean isValid(String s) {
        String pattern = "^(?:https?://)?(?:www\\.)?[a-zA-Z0-9-_]+(?:\\.[a-zA-Z]{2,63}){1,}$";
        return s.matches(pattern);
    }
}