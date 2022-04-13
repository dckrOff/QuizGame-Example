package com.example.quizgame.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.quizgame.R;

import java.util.Hashtable;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class StartActivity extends AppCompatActivity {
    private TextView img_btn;
    private ImageView setting;
    private SwitchCompat switcht,switch1;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        img_btn = findViewById(R.id.play);
        setting = findViewById(R.id.setting);
        switcht = findViewById(R.id.switcht);

        mp = MediaPlayer.create(StartActivity.this, R.raw.garry_potter);

        switcht.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if (check) {
                    mp.start();

                } else {
                    mp.pause();
                }
            }
                                           });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(StartActivity.this);
            }
        });

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, ChooseActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        // Confirmation message
        MediaPlayer.create(StartActivity.this, R.raw.play);
        mp.start();
        new SweetAlertDialog(StartActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Внимание!")
                .setContentText("Вы уверены что хотите выйти?")
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
    public void showDialog(Activity activity) {
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        switch1 = dialog.findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                if (check) {
                    mp.start();

                } else {
                    mp.pause();

                }
            }
        });
        dialog.show();
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