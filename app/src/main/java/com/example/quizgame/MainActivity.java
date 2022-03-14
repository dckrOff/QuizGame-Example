package com.example.quizgame;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    Random random;
    private int currentScore = 0, questionAttempted = 1, currentPos, scienceIndex;
    private TextView questionTv, questionNumberTv, option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> geography, currentScience;
    private View decorView;
    private Bundle indexOfScience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexOfScience = getIntent().getExtras();
        scienceIndex = indexOfScience.getInt("ScienceIndex", 0);

        initViews();
        onBtnClick();
        hideBars();
    }

    private void initViews() {
        random = new Random();
        questionTv = findViewById(R.id.idTvQuestion);
        questionNumberTv = findViewById(R.id.idTvQuestionAttempted);
        questionNumberTv = findViewById(R.id.idTvQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOprion1);
        option2Btn = findViewById(R.id.idBtnOprion2);
        option3Btn = findViewById(R.id.idBtnOprion3);
        option4Btn = findViewById(R.id.idBtnOprion4);

        currentScience = new ArrayList<>();

        geography = new ArrayList<>();
        getGeographyQuestion(geography);


        currentScience.addAll(geography);
        currentPos = random.nextInt(currentScience.size());
        setDataToViews(currentPos);
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
                currentScience.clear();
                currentScience.addAll(geography);
                currentPos = random.nextInt(currentScience.size());
                questionAttempted = 1;
                currentScore = 0;
                setDataToViews(currentPos);
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

    private void getGeographyQuestion(ArrayList<QuizModel> quizModelsArrayList) {
        quizModelsArrayList.add(new QuizModel("В какой стране находится одно из оставшихся семи чудес света??", "Египет", "Италия", "Египет", "Англия", "Македония"));
        quizModelsArrayList.add(new QuizModel("Этот океан самый маленький и холодный", "Северный Ледовитый", "Атлантический", "Тихий океан", "Северный Ледовитый", "Индийский океан"));
        quizModelsArrayList.add(new QuizModel("Какой остров можно надеть на голову?", "Сомбреро", "Новая Зеландия", "Карибский остров", "Фиджи", "Сомбреро"));
        quizModelsArrayList.add(new QuizModel("Назовите самую длинную реку?", "Нил", "Нил", "Рейн", "Янцзы", "Амазонка"));
        quizModelsArrayList.add(new QuizModel("Он сам вода и плавает по воде?", "Лёд", "Вода", "Лёд", "Соль", "Н2О"));
        quizModelsArrayList.add(new QuizModel("Как называется австралийская дикая собака?", "Динго", "Доберман", "Алабай", "Динго", "Руперт"));
        quizModelsArrayList.add(new QuizModel("Черным золотом называют…", "Нефт", "Нефт", "Хлопок", "Золота", "Алмаз"));
        quizModelsArrayList.add(new QuizModel("Назовите скопление мелких пригородов вокруг центрального города?", "Агломерация", "Централизация", "Агломерация", "Урбанизация", "Нет правилного ответа"));
        quizModelsArrayList.add(new QuizModel("Столица Ливии", "Триполи", "Крит'", "Варшава", "Триполи", "Люблана"));
        quizModelsArrayList.add(new QuizModel("На сколько видов делятся полезные ископаемые?", "На три вида", "На две вида", "На три вида", "На семь вида", "На пять вида"));
    }

    private void onBtnClick() {
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                currentScience.remove(currentPos);
                questionAttempted++;
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                currentScience.remove(currentPos);
                questionAttempted++;
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                currentScience.remove(currentPos);
                questionAttempted++;
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScience.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                currentScience.remove(currentPos);
                questionAttempted++;
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
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

    }
}