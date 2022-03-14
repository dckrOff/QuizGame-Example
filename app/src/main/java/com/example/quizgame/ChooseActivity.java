package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ChooseActivity extends AppCompatActivity {
    private ImageView geo, history, aljabr, english, bio, geometria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        initViews();
        onBtnClick();

    }

    private void onBtnClick() {
        geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        geo = findViewById(R.id.btngeo);
        geometria = findViewById(R.id.btngeometria);
        english = findViewById(R.id.english);
        history = findViewById(R.id.btnhis);
        aljabr = findViewById(R.id.btnaljabr);
        bio = findViewById(R.id.btnbio);
    }

    @Override
    public void onBackPressed() {
        // Confirmation message
        new SweetAlertDialog(ChooseActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Внимание!")
                .setContentText("Вы уверены что хотите выйти?")
                .setConfirmText("Да")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
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
}