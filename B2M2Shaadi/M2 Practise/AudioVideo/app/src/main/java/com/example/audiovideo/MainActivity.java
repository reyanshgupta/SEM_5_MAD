package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.bt1);
        Button b2 = findViewById(R.id.bt2);
        Button b3 = findViewById(R.id.bt3);
        VideoView vw = findViewById(R.id.vw);
        //Video Player
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
                vw.setVideoURI(Uri.parse(path));
                vw.start();
            }
        });
        MediaPlayer mp = MediaPlayer.create(this,R.raw.audio);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    mp.pause();
                }
            }
        });
    }
}

