package com.example.quizgame.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizgame.Utils.Questions;
import com.example.quizgame.Model.QuizModel;
import com.example.quizgame.R;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    private int scienceIndex;
    private Random random;
    private int currentScore = 0, questionAttempted = 1, currentPos;
    private TextView questionTv, questionNumberTv, option1Btn, option2Btn, option3Btn, option4Btn;
    public ArrayList<QuizModel> currentScience;
    //    public ArrayList<QuizModel> currentScience, geography, history, math, biology, english, geometry;
    private View decorView;
    private ImageView icBack;
    private Bundle indexOfScience;
    private MediaPlayer mpSuccess, mpFailed;
    private Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexOfScience = getIntent().getExtras();
        scienceIndex = indexOfScience.getInt("ScienceIndex", 0);

        questions.addScienceQuestion(); // add questions

        initViews();
        onBtnClick();
        hideBars();
    }

    private void initViews() {
        random = new Random();
        questionTv = findViewById(R.id.idTvQuestion);
        questionNumberTv = findViewById(R.id.idTvQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOprion1);
        option2Btn = findViewById(R.id.idBtnOprion2);
        option3Btn = findViewById(R.id.idBtnOprion3);
        option4Btn = findViewById(R.id.idBtnOprion4);
        icBack = findViewById(R.id.ic_back);
        mpSuccess = MediaPlayer.create(MainActivity.this, R.raw.succefull);
        mpFailed = MediaPlayer.create(MainActivity.this, R.raw.dontsuceful);

        currentScience = new ArrayList<>();
        choose();
    }

    @SuppressLint("SetTextI18n")
    private void alertDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.congratulation_custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView currAnswers = dialog.findViewById(R.id.correctAnswers);
        currAnswers.setText("Число правильных ответов: " + currentScore);
        TextView restartBtn = dialog.findViewById(R.id.restartBtn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void setDataToViews(int currentPos) {
        questionNumberTv.setText(questionAttempted + "/10");
        if (questionAttempted == 11) {
            alertDialog();
        } else {
            questionTv.setText(currentScience.get(currentPos).getQuestion());
            option1Btn.setText(currentScience.get(currentPos).getOption1());
            option2Btn.setText(currentScience.get(currentPos).getOption2());
            option3Btn.setText(currentScience.get(currentPos).getOption3());
            option4Btn.setText(currentScience.get(currentPos).getOption4());
        }
    }

    public void choose() {
        switch (scienceIndex) {
            case 1:
                currentScience.addAll(questions.getGeographyLevel1());
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                icBack.setBackgroundResource(R.drawable.ic_geografy);
                changeBg(R.drawable.btn_bg_geography);
                break;
            case 2:
                currentScience.addAll(questions.getHistory());
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                icBack.setBackgroundResource(R.drawable.ic_history);
                changeBg(R.drawable.btn_bg_history);
                break;
            case 3:
                currentScience.addAll(questions.getMath());
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                icBack.setBackgroundResource(R.drawable.ic_algebra);
                changeBg(R.drawable.btn_bg_algebra);
                break;
            case 4:
                currentScience.addAll(questions.getBiology());
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                icBack.setBackgroundResource(R.drawable.ic_biology);
                changeBg(R.drawable.btn_bg_biology);
                break;
            case 5:
                currentScience.addAll(questions.getEnglish());
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                icBack.setBackgroundResource(R.drawable.ic_english);
                changeBg(R.drawable.btn_bg_english);
                break;
            case 6:
                currentScience.addAll(questions.getGeometry());
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                icBack.setBackgroundResource(R.drawable.ic_geomtria);
                changeBg(R.drawable.btn_bg_geometriya);
                break;
        }
    }

    private void onBtnClick() {
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                    mpSuccess.start();
                } else {
                    mpFailed.start();
                }
                currentScience.remove(currentPos);
                questionAttempted++;
                //koroche ishorda xato bolib duribdi 230 skroke
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.size() >= 1) {
                    if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                        currentScore++;
                        mpSuccess.start();
                    } else {
                        mpFailed.start();
                    }
                    currentScience.remove(currentPos);
                    questionAttempted++;

                    //koroche ishorda xato bolib duribdi 247 stroke
                    currentPos = random.nextInt(currentScience.size());

                    setDataToViews(currentPos);
                }
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viwew) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                    mpSuccess.start();
                } else {
                    mpFailed.start();
                }
                currentScience.remove(currentPos);
                questionAttempted++;
                //koroche ishorda xato bolib duribdi 263 troke
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                    mpSuccess.start();
                } else {
                    mpFailed.start();
                }
                currentScience.remove(currentPos);
                questionAttempted++;
                //koroche ishorda xato bolib duribdi 279 stroke
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Confirmation message
        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Внимание!")
                .setContentText("Вы уверены что хотите выйти?")
                .setConfirmText("Да")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        finish();
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

    private void hideBars() {
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visiblity) {
                if (visiblity == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                //                | View.SYSTEM_UI_FLAG_FULLSCREEN
                //                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        //                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

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

    public void changeBg(int btnBg) {
        option1Btn.setBackgroundResource(btnBg);
        option2Btn.setBackgroundResource(btnBg);
        option3Btn.setBackgroundResource(btnBg);
        option4Btn.setBackgroundResource(btnBg);
    }

}