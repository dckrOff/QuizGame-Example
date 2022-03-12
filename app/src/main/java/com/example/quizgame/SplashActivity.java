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

        changeGif();
        intentToNextActivity();
    }

    private void changeGif() {
        Random rn = new Random();
        gifNumber = rn.nextInt(10);
        switch (gifNumber) {
            case 1:
                splashGif.setBackgroundResource(R.color.splash1);
                splashGif.setImageResource(R.drawable.splash1);
                break;
            case 2:
                splashGif.setBackgroundResource(R.color.splash2);
                splashGif.setImageResource(R.drawable.splash2);
                break;
            case 3:
                splashGif.setBackgroundResource(R.color.splash3);
                splashGif.setImageResource(R.drawable.splash3);
                break;
            case 4:
                splashGif.setBackgroundResource(R.color.splash4);
                splashGif.setImageResource(R.drawable.splash4);
                break;
            case 5:
                splashGif.setBackgroundResource(R.color.splash5);
                splashGif.setImageResource(R.drawable.splash5);
                break;
            case 6:
                splashGif.setBackgroundResource(R.color.splash6);
                splashGif.setImageResource(R.drawable.splash6);
                break;
            case 7:
                splashGif.setBackgroundResource(R.color.splash7);
                splashGif.setImageResource(R.drawable.splash7);
                break;
            case 8:
                splashGif.setBackgroundResource(R.color.splash8);
                splashGif.setImageResource(R.drawable.splash8);
                break;
            case 9:
                splashGif.setBackgroundResource(R.color.splash9);
                splashGif.setImageResource(R.drawable.splash9);
                break;
            case 10:
                splashGif.setBackgroundResource(R.color.splash10);
                splashGif.setImageResource(R.drawable.splash10);
                break;
            default:
                break;
        }

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