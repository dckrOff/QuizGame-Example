package com.example.quizgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private final static int SPLASH_TIME_OUT = 6500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MediaPlayer ring = MediaPlayer.create(SplashActivity.this, R.raw.intro);
                ring.start();
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}