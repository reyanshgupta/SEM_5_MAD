package com.example.a12sept_audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.bt1);
        Button b2 = (Button) findViewById(R.id.bt2);
        Button b3 = (Button) findViewById(R.id.bt3);
        VideoView v1 = (VideoView)findViewById(R.id.vv);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.audio);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
                v1.setVideoURI(Uri.parse(path));
                v1.start();
            }
        });
    }

    public void start(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.audio);
        mp.start();
    }
    public void stop(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.audio);
        mp.stop();
    }
}