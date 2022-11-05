package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tecnoaux.R;

public class QuizResults extends AppCompatActivity {

    private Button btnNxtPart;
    private Button btnRemakeQuiz;
    private Button btnBackText;
    private TextView result;
    private TextView msgResult;
    private int totalQuestionsQuiz = 4;
    private String getTopicName;
    private String congratulations = "Parabéns :D \nVocê alcançou a nota necessária para avançar " +
            "para a próxima fase! \nNovos desafios e conhecimentos estão te esperando!";
    private String fail = "Game Over :( \nInfelizmente você não alcançou a nota necessária para" +
            " avançar de fase (3/4). \nMas não desista, tente novamente, pois outros desafios te aguardam!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        btnNxtPart = findViewById(R.id.btn_next_part);
        btnRemakeQuiz = findViewById(R.id.btn_remake_quiz);
        btnBackText = findViewById(R.id.btn_back_to_text);
        result = findViewById(R.id.txt_result);
        msgResult = findViewById(R.id.txt_msg_result);

        getTopicName = getIntent().getStringExtra("topicName");

        final int getCorrectAnswers = getIntent().getIntExtra("correct",0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        changeResult(getCorrectAnswers);

        btnRemakeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizResults.this, QuizActivity.class);
                intent.putExtra("topicName", getTopicName);
                startActivity(intent);
                finish();
            }
        });

        btnBackText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTexto();
            }
        });

        btnNxtPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPart();
            }
        });
    }

    private void nextPart() {
        if(getTopicName.equals("variaveis")){
            Intent intent = new Intent(QuizResults.this, FuncaoModulo.class);
            startActivity(intent);
            finish();
        }
        else if(getTopicName.equals("funcoes")){
            Intent intent = new Intent(QuizResults.this, PassagemParametroModulo.class);
            startActivity(intent);
            finish();
        }
        else if(getTopicName.equals("parametros")){
            Intent intent = new Intent(QuizResults.this, LinguagensTradutoresModulo.class);
            startActivity(intent);
            finish();
        }
        else if(getTopicName.equals("linguagens")){
            Intent intent = new Intent(QuizResults.this, IntroducaoComputacao.class);
            startActivity(intent);
            finish();
        }
    }

    private void voltarTexto() {
        if(getTopicName.equals("variaveis")){
            Intent intent = new Intent(QuizResults.this, VariaveisModulo.class);
            startActivity(intent);
            finish();
        }
        else if(getTopicName.equals("funcoes")){
            Intent intent = new Intent(QuizResults.this, FuncaoModulo.class);
            startActivity(intent);
            finish();
        }
        else if(getTopicName.equals("parametros")){
            Intent intent = new Intent(QuizResults.this, PassagemParametroModulo.class);
            startActivity(intent);
            finish();
        }
        else if(getTopicName.equals("linguagens")){
            Intent intent = new Intent(QuizResults.this, LinguagensTradutoresModulo.class);
            startActivity(intent);
            finish();
        }
    }

    private void changeResult(int correctAnswers) {
        if(getTopicName.equals("linguagens")){
            btnNxtPart.setText("Finalizar Quiz");
        }
        float perc = (float) correctAnswers/totalQuestionsQuiz;
        perc = perc *100;
        result.setText(correctAnswers + "/" + totalQuestionsQuiz + "questões (" + perc + "%)");
        if(correctAnswers >= 3){
            result.setTextColor(Color.parseColor("#00C853"));
            msgResult.setText(congratulations);
            btnNxtPart.setEnabled(true);
            btnNxtPart.setBackgroundColor(Color.parseColor("#00C853"));
            btnNxtPart.setTextColor(Color.WHITE);
        }else{
            result.setTextColor(Color.parseColor("#DD2C00"));
            msgResult.setText(fail);
            btnNxtPart.setEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this, IntroducaoComputacao.class));
        finish();
    }
}