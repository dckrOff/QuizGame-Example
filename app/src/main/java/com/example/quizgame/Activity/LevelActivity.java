package com.example.quizgame.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizgame.Adapter.LevelAdapter;
import com.example.quizgame.Model.Levels;
import com.example.quizgame.R;
import com.example.quizgame.Utils.Questions;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {

    private final String TAG = "LevelActivity";
    ArrayList<Levels> levels = new ArrayList<Levels>();
    private RecyclerView recyclerView;
    private LevelAdapter levelAdapter;
    Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        questions.levels();
        initViews();
//        setInitialData();
        createAndSetAdapter();
    }

    private void createAndSetAdapter() {
        // создаем адаптер
        levelAdapter = new LevelAdapter(this, levels);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(levelAdapter);
    }

    private void initViews() {
        // начальная инициализация списка
        recyclerView = findViewById(R.id.levelList);

        levels.addAll(questions.getLevelsGeography());
    }

//    private void setInitialData() {
//        levels.add(new Levels("Угадай флаг", "Найдите флаг страны из рисунка", R.drawable.img_flag, R.drawable.star1));
//    }
    public void chooseLvl(int lvl){
        Intent intent;
        switch (lvl){
            case 1:
                intent = new Intent(LevelActivity.this , MainActivity.class);
                intent.putExtra("LVL",1);
                startActivity(intent);
                finish();
                break;
            case 2:
                intent = new Intent(LevelActivity.this, MainActivity.class);
                intent.putExtra("LVL",2);
                startActivity(intent);
                finish();
                break;
            case 3:
                intent = new Intent(LevelActivity.this , MainActivity.class);
                intent.putExtra("LVL",3);
                startActivity(intent);
                finish();
                break;
            case 4:
                intent = new Intent(LevelActivity.this , MainActivity.class);
                intent.putExtra("LVL",4);
                startActivity(intent);
                finish();
                break;
            case 5:
                intent = new Intent(LevelActivity.this , MainActivity.class);
                intent.putExtra("LVL",5);
                startActivity(intent);
                finish();
                break;
        }

    }
}