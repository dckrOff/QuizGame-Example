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

public class MainActivity extends AppCompatActivity {

    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;
    private TextView questionTv, questionNumberTv, option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelsArrayList;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        onBtnClick();
        hideBars();
    }

    private void initViews() {
        questionTv = findViewById(R.id.idTvQuestion);
        questionNumberTv = findViewById(R.id.idTvQuestionAttempted);
        questionNumberTv = findViewById(R.id.idTvQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOprion1);
        option2Btn = findViewById(R.id.idBtnOprion2);
        option3Btn = findViewById(R.id.idBtnOprion3);
        option4Btn = findViewById(R.id.idBtnOprion4);
        quizModelsArrayList = new ArrayList<>();
        getQuizQuestion(quizModelsArrayList);
        random = new Random();
        currentPos = random.nextInt(quizModelsArrayList.size());
        setDataToViews(currentPos);
    }

    private void alertDialog() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.congratulation_custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView currAnswers = dialog.findViewById(R.id.correctAnswers);
        currAnswers.setText("To'gri javoblar soni: " + currentScore);
        TextView restartBtn = dialog.findViewById(R.id.restartBtn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelsArrayList.size());
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
        if (questionAttempted == 10) {
            alertDialog();
        } else {
            questionTv.setText(quizModelsArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelsArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelsArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelsArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelsArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelsArrayList) {
        quizModelsArrayList.add(new QuizModel("Tabaco - trenidat poytaxti qayer?", "Port-of-Spain", "Port-of-Spain", "Tashkent", "Braziliya", "Vatican"));
        quizModelsArrayList.add(new QuizModel("Dunyodagi eng aholi ko'p davlat", "India", "China", "Uzbekistan", "India", "Amerika"));
        quizModelsArrayList.add(new QuizModel("Neandertalning yosh zamondoshi bo'lgan odamning atalishi nima edi?", "Kromanyon", "Zinjantrop", "Kromanyon", "Pitikantrop", "Avstrolopit"));
        quizModelsArrayList.add(new QuizModel("Germaniya orqali qaysi daryo oqib o'tadi?", "Reyn", "Nil", "Delta", "Reyn", "Amudaryo"));
        quizModelsArrayList.add(new QuizModel("Qoraqum sahrosi qayerda joylashgan?", "Turkmanistonda", "Armeniya", "Turkmaniston", "Kozog'iston", "Uzbekison"));
        quizModelsArrayList.add(new QuizModel("Evropadagi eng yer maydoni katta bo'lgan davlat", "Rossiya", "Buyuk Britaniya", "Germaniya", "Fransiya", "Rossiya"));
        quizModelsArrayList.add(new QuizModel("Yer yuzida qancha materiklar bor?", "6", "5", "3", "6", "1"));
        quizModelsArrayList.add(new QuizModel("Sloveniyani poytaxti?", "Lyublana", "Bratislava", "Lyublana", "Zagreb", "Izola"));
        quizModelsArrayList.add(new QuizModel("Rossiyadagi eng katta daryo", "Ob'", "Ob'", "Yenisey", "Volga", "Qora daryo"));
        quizModelsArrayList.add(new QuizModel("Dunyoadgi eng kichkina davlat?", "Vatikan", "Kipr", "Vatikan", "Chili", "Yangi zenlandiya"));
    }

    private void onBtnClick() {
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelsArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelsArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelsArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelsArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelsArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelsArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelsArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelsArrayList.size());
                setDataToViews(currentPos);
            }
        });
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