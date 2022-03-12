package com.example.quizgame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;
    private TextView questionTv, questionNumberTv;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        onBtnClick();

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

    @SuppressLint("SetTextI18n")
    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTv = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTv.setText("Your score is: " + currentScore);
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelsArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void setDataToViews(int currentPos) {
        questionNumberTv.setText("Question Attempted : " + questionAttempted + "/10");
        if (questionAttempted == 10) {
            showBottomSheet();
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


}