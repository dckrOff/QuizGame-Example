package com.example.quizgame;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
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

    private int scienceIndex;
    Random random;
    private int currentScore = 0, questionAttempted = 1, currentPos;
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

        chooseScience();
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

    private void addScienceQuestion() {
        geography.add(new QuizModel("В какой стране находится одно из оставшихся семи чудес света?", "Египет", "Италия", "Египет", "Англия", "Македония"));
        geography.add(new QuizModel("Этот океан самый маленький и холодный", "Северный Ледовитый", "Атлантический", "Тихий океан", "Северный Ледовитый", "Индийский океан"));
        geography.add(new QuizModel("Какой остров можно надеть на голову?", "Сомбреро", "Новая Зеландия", "Карибский остров", "Фиджи", "Сомбреро"));
        geography.add(new QuizModel("Назовите самую длинную реку?", "Нил", "Нил", "Рейн", "Янцзы", "Амазонка"));
        geography.add(new QuizModel("Он сам вода и плавает по воде?", "Лёд", "Вода", "Лёд", "Соль", "Н2О"));
        geography.add(new QuizModel("Как называется австралийская дикая собака?", "Динго", "Доберман", "Алабай", "Динго", "Руперт"));
        geography.add(new QuizModel("Черным золотом называют…", "Нефт", "Нефт", "Хлопок", "Золота", "Алмаз"));
        geography.add(new QuizModel("Назовите скопление мелких пригородов вокруг центрального города?", "Агломерация", "Централизация", "Агломерация", "Урбанизация", "Нет правилного ответа"));
        geography.add(new QuizModel("Столица Ливии", "Триполи", "Крит'", "Варшава", "Триполи", "Люблана"));
        geography.add(new QuizModel("На сколько видов делятся полезные ископаемые?", "На три вида", "На две вида", "На три вида", "На семь вида", "На пять вида"));
        geography.add(new QuizModel("В каком месте Китай среди ВВП?", "На первом", "В третьем", "На первом", "На втором", "В четвертом"));

        history.add(new QuizModel("Как называются гробницы  фараонов Древнего Египта ?", "пирамиды", "храмы", "пирамиды", "катакомбы", "гроб"));
        history.add(new QuizModel("Какому богу были посвящены Олимпийские игры в Древней Греции:", "Зевсу", "Зевсу ", "Аполлону", "Посейдону", "Гефесту"));
        history.add(new QuizModel("Как называется огромный амфитеатр Рима, где сражались гладиаторы  и в котором могло находиться  до 50 тысяч зрителей:", "Колизей", "Театр", "Пантеон", "Колизей", "Форум"));
        history.add(new QuizModel("Огромная держава монголов была создана:", "Чингизханом", "Батыем", "Тамерланом", "Тимучин", "Чингизханом"));
        history.add(new QuizModel("Кто был первым русским царём", "Иван IV Грозный", "Иван IV Грозный", "Пётр I", "Иван Калита", "Иван Грозный"));
        history.add(new QuizModel("Какой титул получил Наполеон в 1804 году:", "император", "король", "царь", "император", "Уничтожитель"));
        history.add(new QuizModel("Отец историй:", "Геродот", "Геродот", "Аристотель", "Аристофан", "Цицерон"));
        history.add(new QuizModel("Своё государство жители Китая называли:", "Поднебесная империя", "Непобедимая империя", "Благородная империя", "Поднебесная империя", "Империя возле жёлтого реки"));
        history.add(new QuizModel("Создател переменого тока", "Никола Тесла", "Уильямом Гильбертом'", "Никола Тесла", "Андре Мари Ампер", "Чарльз Августин"));
        history.add(new QuizModel("Назовите три чудес из 7ми", "Акрополь,Пирамиды,Александрский Маяк", "Родос,Эфес,Эйфил", "Акрополь,Пирамиды,Александрский Маяк", "Олимпия,Вавилон,Храм Буды ", "Александрия Египетская,Галикарнас,Вавилон"));
        history.add(new QuizModel("Кто расшифировал (Розетский камень) ", "Шампольон", "Шампольон", "Фредрик", "Арасту", "Немо"));

        english.add(new QuizModel("This __ a good restaurant - Это хороший ресторан", "is", "are", "was", "is", "at"));
        english.add(new QuizModel("I __ a new student - Я новый ученик:", "am", "is ", "are", "to", "am"));
        english.add(new QuizModel("Where __ you last night? - Где вы были прошлой ночью?", "were", "was", "are", "were", "how"));
        english.add(new QuizModel("Claire and James __ listening - Клэр и Джеймс не слушали", "weren't", "weren't", "wasn't", "isn't", "realy"));
        english.add(new QuizModel("We (to understand) __ each other.", "Understood", "Understanded", "Understood", "Understand", "Underground"));
        english.add(new QuizModel("Did you (to see) __ my new bike?", "see", "saw", "seen", "see", "look"));
        english.add(new QuizModel("I __ a big family. – У меня большая семья.", "have", "has", "have", "had", "am"));
        english.add(new QuizModel("They __ got many friends. - У них много друзей.", "have", "have", "has", "had", "is"));
        english.add(new QuizModel("I __ decided yet. - Я еще не решил.", "haven't", "haven't", "hasn't", "hadn't", "hisn't"));
        english.add(new QuizModel("The plane (to take off) __ right now. - Самолет взлетает прямо сейчас.", "is taking off", "is take off", "is taking off", "taking", "take"));
        english.add(new QuizModel("We must be geting close (перевод)", "Похоже мы приближаеися", "Мы должны приближаться", "Похоже мы приближаемся", "Мы близко", "мы далеко"));

        math.add(new QuizModel("Какая фигура не имеет углов?", "Круг", "Круг", "Прямоугольник", "луч", "Треугольник"));
        math.add(new QuizModel("Что составляют вместе 12 месяцев?", "Год", "Месяц", "365 день", "Год", "День"));
        math.add(new QuizModel("Какая азбука состоит из двух знаков", "Азбука Морзе", "Летопис", "Шангриланский", "Азбука Морзе", "Обычный"));
        math.add(new QuizModel("Чему равно произведение всех чисел?", "Нулю", "Нулю", "99999", "На один", "К натуралным числам"));
        math.add(new QuizModel("Когда мы смотрим на цифру 1, а говорим «пять»?", "Когда смотрим на часы и говорим «пять минут»", "Когда смотри на пять", "Нет правильного ответа", "Когда увидим римскую цифру", "Когда смотрим на часы и говорим «пять минут»"));
        math.add(new QuizModel("Двое играли в шахматы 2 часа. Сколько всего времени сыграл каждый?", "2 часа", "4 часа", "1 час", "2 часа.", "2 часа 5 минут"));
        math.add(new QuizModel("Яйцо варится вкрутую четыре минуты. Если бросить пять яиц в кипящую воду в восемь часов, когда можно выключить газовую плиту?", "В 8 часов 4 минуты", "Никогда", "В 8 часов 4 минуты", "После 4 минута", "после 40 минута"));
        math.add(new QuizModel("С утра температура воздуха была минус 9 °С, а затем потеплело на семь градусов, то положительной ли стала температура воздуха к полудню?", "Нет", "Нет", "Да", "Незнаю", "Да на 7 градусов"));
        math.add(new QuizModel("Кто из ученых не был математиком?", "Колумб", "Гаусс", "Колумб", "Виет", "Пифагор"));
        math.add(new QuizModel("Слово «алгебра» произошло от арабского «аль-джабр». В переводе это ...", "Восполнение", "Вычисление", "Понимание", "Восполнение", "Умножение"));
        math.add(new QuizModel("Давайте вспомним графики! Каким он будет у линейной функции?", "Это прямая", "Это парабола", "Это синусоида", "Это лагарифм", "Это прямая"));

        biology.add(new QuizModel("Какой цветок считают последней улыбкой осени?", "Астра", "Астра", "Лилия Шевчук", "Хризантемы", "Георгины"));
        biology.add(new QuizModel("Какой цветок является символом солнца и символом Японии?", "Хризантемы", "Лилия Шевчук", "Георгины", "Хризантемы", "Астра"));
        biology.add(new QuizModel("Какие существа имеют три сердца?", "Осьминоги, Каракатицы, Кальмары", "Осьминоги, Каракатицы, Киты", "Осьминоги, Акулы, Кальмары", "Осьминоги, Рыба клоун, Кальмары", "Осьминоги, Каракатицы, Кальмары"));
        biology.add(new QuizModel("Какого цвета у моллюсков кровь", "голубая", "Красная", "голубая", "Зеленая", "Чёрная"));
        biology.add(new QuizModel("Какое растение дает лучший мед?", "Липа", "Липа", "Растение не дает мёд", "Каштан", "Акация"));
        biology.add(new QuizModel("Название какого растения связано со звоном?", "Колокольчик", "Голубки", "Колокольчик", "Котелки", "Нет такого растение"));
        biology.add(new QuizModel("Самая большая дерево по росту в мире?", "Баобаб", "Никогда", "Гиперион", "Генерал Шерман", "Берёза"));
        biology.add(new QuizModel("С утра температура воздуха была минус 9 °С, а затем потеплело на семь градусов, то положительной ли стала температура воздуха к полудню?", "Нет", "Нет", "Да", "Незнаю", "Да на 7 градусов"));
        biology.add(new QuizModel("Кто из ученых не был математиком?", "Колумб", "Гаусс", "Колумб", "Виет", "Пифагор"));
        biology.add(new QuizModel("Слово «алгебра» произошло от арабского «аль-джабр». В переводе это ...", "Восполнение", "Вычисление", "Понимание", "Восполнение", "Умножение"));
        biology.add(new QuizModel("Давайте вспомним графики! Каким он будет у линейной функции?", "Это прямая", "Это парабола", "Это синусоида", "Это лагарифм", "Это прямая"));

        geometry.add(new QuizModel("Сколько сторон у шестиугольника?", "6", "5", "6", "7", "1"));
        geometry.add(new QuizModel("Правда или ложь? Параллелограмм имеет три пары параллельных сторон?", "Ложь", "Не бывает такого", "Правда", "Ложь", "Нет правильного ответа"));
        geometry.add(new QuizModel("Сколько градусов имеют внутренние углы равностороннего треугольника?", "60", "45", "180", "60", "90"));
        geometry.add(new QuizModel("Сколько точек на пентаграмме?", "5", "5", "10", "4", "Бесконечно"));
        geometry.add(new QuizModel("Как называется расстояние от центра круга до его края?", "Радиус", "Радиус", "Алфа", "Делта", "Окружность"));
        geometry.add(new QuizModel("Сколько сторон одинаковой длины имеет квадрат?", "4", "6", "5", "4", "10"));
        geometry.add(new QuizModel("Сколько у трапеции пар параллельных сторон?", "1", "2", "Не имею сторон", "1", "0"));
        geometry.add(new QuizModel("Как называется сумма длин всех сторон фигуры?", "Периметр", "Площад", "Периметр", "Синус", "Пополнение"));
        geometry.add(new QuizModel("Какого из терминов существует в геометрии?", "Полуплоскость", "Плотност", "Плоскость", "Полуплоскость", "Трапеция"));
        geometry.add(new QuizModel("Какое понятие описывается как отношение противолежащего катета к прилежащему (применительно к острому углу)?", "Тангенс угла", "Котангенс угла", "Тангенс угла", "Косинус угла", "Синус угла"));
        geometry.add(new QuizModel("Каков диапазон значений синуса?", "от -1 до +1", "от -1 до 0", "от -1 до +1", "от +1 до -1", "от 0 до +1"));
    }

    public void chooseScience() {
        switch (scienceIndex) {
            case 1:
                currentScience.addAll(geography);
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                break;
            case 2:
                currentScience.addAll(history);
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                break;
            case 3:
                currentScience.addAll(math);
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                break;
            case 4:
                currentScience.addAll(biology);
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                break;
            case 5:
                currentScience.addAll(english);
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                break;
            case 6:
                currentScience.addAll(geometry);
                currentPos = random.nextInt(currentScience.size());
                setDataToViews(currentPos);
                break;
        }
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
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
    }
}