package com.example.quizgame.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizgame.R;

import java.util.Hashtable;

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
                Intent intent = new Intent(SplashActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context c, String name) {
        synchronized (cache) {
            if (!cache.containsKey(name)) {
                String path = "fonts/" + name;
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), path);
                    cache.put(name, t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return cache.get(name);
        }
    }
}