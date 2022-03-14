package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ChooseActivity extends AppCompatActivity {
    private ImageView geography, history, aljabr, english, biology, geometria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        initViews();
        onBtnClick();

    }

    private void onBtnClick() {

        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 1);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 2);
                startActivity(intent);
            }
        });
        aljabr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 3);
                startActivity(intent);
            }
        });
        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 4);
                startActivity(intent);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 5);
                startActivity(intent);
            }
        });
        geometria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                intent.putExtra("ScienceIndex", 6);
                startActivity(intent);
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
}