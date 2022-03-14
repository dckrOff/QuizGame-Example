package com.example.quizgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private final static int SPLASH_TIME_OUT = 3000;
    private final String TAG = "SplashActivity";

    private GifImageView splashGif;
    private int gifNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashGif = findViewById(R.id.splashGif);

        intentToNextActivity();
    }

    private void intentToNextActivity() {
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