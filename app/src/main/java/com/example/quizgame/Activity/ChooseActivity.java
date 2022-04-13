package com.example.quizgame.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizgame.R;

import java.util.Hashtable;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ChooseActivity extends AppCompatActivity {
    private ImageView geography, history, aljabr, english, biology, geometria;
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        mp = MediaPlayer.create(ChooseActivity.this, R.raw.play);
        initViews();
        onBtnClick();

    }

    private void onBtnClick() {

        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent intent = new Intent(ChooseActivity.this, LevelActivity.class);
                intent.putExtra("ScienceIndex", 1);
                startActivity(intent);
//                finish();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 2);
                startActivity(intent);
                finish();
            }
        });
        aljabr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 3);
                startActivity(intent);
                finish();
            }
        });
        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 4);
                startActivity(intent);
                finish();
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 5);
                startActivity(intent);
                finish();
            }
        });
        geometria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 6);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initViews() {
        geography = findViewById(R.id.btngeography);
        geometria = findViewById(R.id.btngeometria);
        english = findViewById(R.id.english);
        history = findViewById(R.id.btnhis);
        aljabr = findViewById(R.id.btnaljabr);
        biology = findViewById(R.id.btnbiogia);
    }

    @Override
    public void onBackPressed() {
        // Confirmation message
        new SweetAlertDialog(ChooseActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Внимание!")
                .setContentText("Вы уверены что хотите выйти в главную меню?")
                .setConfirmText("Да")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        finish();
                    }
                })
                .setCancelButton("Нет", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
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