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
    private ArrayList<QuizModel> currentScience, geography, history, math, biology, english, geometry;
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
        history = new ArrayList<>();
        math = new ArrayList<>();
        biology = new ArrayList<>();
        english = new ArrayList<>();
        geometry = new ArrayList<>();

        addScienceQuestion();
        
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

    private void addScienceQuestion() {
        geography.add(new QuizModel("В какой стране находится одно из оставшихся семи чудес света??", "Египет", "Италия", "Египет", "Англия", "Македония"));
        geography.add(new QuizModel("Этот океан самый маленький и холодный", "Северный Ледовитый", "Атлантический", "Тихий океан", "Северный Ледовитый", "Индийский океан"));
        geography.add(new QuizModel("Какой остров можно надеть на голову?", "Сомбреро", "Новая Зеландия", "Карибский остров", "Фиджи", "Сомбреро"));
        geography.add(new QuizModel("Назовите самую длинную реку?", "Нил", "Нил", "Рейн", "Янцзы", "Амазонка"));
        geography.add(new QuizModel("Он сам вода и плавает по воде?", "Лёд", "Вода", "Лёд", "Соль", "Н2О"));
        geography.add(new QuizModel("Как называется австралийская дикая собака?", "Динго", "Доберман", "Алабай", "Динго", "Руперт"));
        geography.add(new QuizModel("Черным золотом называют…", "Нефт", "Нефт", "Хлопок", "Золота", "Алмаз"));
        geography.add(new QuizModel("Назовите скопление мелких пригородов вокруг центрального города?", "Агломерация", "Централизация", "Агломерация", "Урбанизация", "Нет правилного ответа"));
        geography.add(new QuizModel("Столица Ливии", "Триполи", "Крит'", "Варшава", "Триполи", "Люблана"));
        geography.add(new QuizModel("На сколько видов делятся полезные ископаемые?", "На три вида", "На две вида", "На три вида", "На семь вида", "На пять вида"));

        history.add(new QuizModel("Как называются гробницы  фараонов Древнего Египта ?", "пирамиды", "храмы", "пирамиды", "катакомбы", "гроб"));
        history.add(new QuizModel("Какому богу были посвящены Олимпийские игры в Древней Греции:", "Зевсу", "Зевсу ", "Аполлону", "Посейдону", "Гефесту"));
        history.add(new QuizModel("Как называется огромный амфитеатр Рима, где сражались гладиаторы  и в котором могло находиться  до 50 тысяч зрителей:", "Колизей", "Театр", "Пантеон", "Колизей", "Форум"));
        history.add(new QuizModel("Огромная держава монголов была создана:", "Чингизханом", "Батыем", "Тамерланом", "Тимучин", "Чингизханом"));
        history.add(new QuizModel("Кто был первым русским царём", "Иван IV Грозный", "Иван IV Грозный", "Пётр I", "Иван Калита", "Иван Грозный"));
        history.add(new QuizModel("Какой титул получил Наполеон в 1804 году:", "император", "король", "царь", "император", "Уничтожитель"));
        history.add(new QuizModel("Отец историй:", "Геродот", "Геродот", "Аристотель", "Аристофан", "Цицерон"));
        history.add(new QuizModel("Своё государство жители Китая называли:", "Поднебесная империя", "Непобедимая империя", "Благородная империя", "Поднебесная империя", "Империя возле жёлтого реки"));
        history.add(new QuizModel("Создател переменого тока", "Никола Тесла", "Уильямом Гильбертом'", "Никола Тесла", "Андре Мари Ампер", "Чарльз Августин"));
        history.add(new QuizModel("Назовите три чудесь из 7ми", "Акрополь,Пирамиды,Александрский Маяк", "Родос,Эфес,Эйфил", "Акрополь,Пирамиды,Александрский Маяк", "Олимпия,Вавилон,Храм Буды ", "Александрия Египетская,Галикарнас,Вавилон"));

        english.add(new QuizModel("This __ a good restaurant - Это хороший ресторан", "is", "are", "was", "is", "at"));
        english.add(new QuizModel("I __ a new student - Я новый ученик:", "am", "is ", "are", "to", "am"));
        english.add(new QuizModel("КWhere __ you last night? - Где вы были прошлой ночью?", "were", "was", "are", "were", "how"));
        english.add(new QuizModel("Claire and James __ listening - Клэр и Джеймс не слушали", "weren't", "weren't", "wasn't", "isn't", "realy"));
        english.add(new QuizModel("We (to understand) __ each other.", "Understood", "Understanded", "Understood", "Understand", "Underground"));
        english.add(new QuizModel("Did you (to see) __ my new bike?", "see", "saw", "seen", "see", "look"));
        english.add(new QuizModel("I __ a big family. – У меня большая семья.", "have", "has", "have", "had", "am"));
        english.add(new QuizModel("They __ got many friends. - У них много друзей.", "have", "have", "has", "had", "is"));
        english.add(new QuizModel("I __ decided yet. - Я еще не решил.", "haven't", "haven't", "hasn't", "hadn't", "hisn't"));
        english.add(new QuizModel("The plane (to take off) __ right now. - Самолет взлетает прямо сейчас.", "is taking off", "is take off  ", "is taking off", "taking", "take"));

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