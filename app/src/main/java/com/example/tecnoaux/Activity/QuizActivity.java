package com.example.tecnoaux.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tecnoaux.Models.QuestionsList;
import com.example.tecnoaux.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    ImageView returnIconQuiz;
    TextView tittleToolbarQuiz;

    TextView questions;
    TextView question;
    AppCompatButton option1, option2, option3, option4;
    Timer quizTimer;
    AppCompatButton nxtBtn;
    int totalTimeInMins = 3;
    int seconds = 0;
    private List<QuestionsList> questionsLists = new ArrayList<>();
    private int currentQuestionPosition = 0;
    private String selectedOptionByUser ="";
    private String getTopicName;
    private TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timer = findViewById(R.id.txt_timer);
        setContentView(R.layout.activity_quiz);
        returnIconQuiz = findViewById(R.id.return_Icon_Quiz);
        tittleToolbarQuiz = findViewById(R.id.tittle_Toolbar_Quiz);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.txt_question);

        option1 = findViewById(R.id.txt_opc1);
        option2 = findViewById(R.id.txt_opc2);
        option3 = findViewById(R.id.txt_opc3);
        option4 = findViewById(R.id.txt_opc4);

        nxtBtn = findViewById(R.id.nxtBtn);


        getTopicName = getIntent().getStringExtra("topicName");

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tecnoaux-79485-default-rtdb.firebaseio.com/");
        ProgressDialog progressDialog = new ProgressDialog(QuizActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Carregando...");
        progressDialog.show();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.child(getTopicName ).getChildren()){
                    String getQuestion = dataSnapshot.child("questao").getValue(String.class);
                    String getOption1 = dataSnapshot.child("opcao1").getValue(String.class);
                    String getOption2 = dataSnapshot.child("opcao2").getValue(String.class);
                    String getOption3 = dataSnapshot.child("opcao3").getValue(String.class);
                    String getOption4 = dataSnapshot.child("opcao4").getValue(String.class);
                    String getAnswer = dataSnapshot.child("resposta").getValue(String.class);

                    QuestionsList questionsList = new QuestionsList(getQuestion, getOption1, getOption2, getOption3, getOption4,getAnswer);
                    questionsLists.add(questionsList);
                }
                progressDialog.hide();

                questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
                question.setText(questionsLists.get(0).getQuestion());
                option1.setText(questionsLists.get(0).getOption1());
                option2.setText(questionsLists.get(0).getOption2());
                option3.setText(questionsLists.get(0).getOption3());
                option4.setText(questionsLists.get(0).getOption4());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        startTimer();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    if(isCorrectedAnswer()){
                        option1.setBackgroundResource(R.drawable.round_back_green10);
                    }
                    else {
                        option1.setBackgroundResource(R.drawable.round_back_red10);
                    }
                    option1.setTextColor(Color.WHITE);

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    if(isCorrectedAnswer()){
                        option2.setBackgroundResource(R.drawable.round_back_green10);
                    }
                    else {
                        option2.setBackgroundResource(R.drawable.round_back_red10);
                    }
                    option2.setTextColor(Color.WHITE);

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    if(isCorrectedAnswer()){
                        option3.setBackgroundResource(R.drawable.round_back_green10);
                    }
                    else {
                        option3.setBackgroundResource(R.drawable.round_back_red10);
                    }
                    option3.setTextColor(Color.WHITE);

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    if(isCorrectedAnswer()){
                        option4.setBackgroundResource(R.drawable.round_back_green10);
                    }
                    else {
                        option4.setBackgroundResource(R.drawable.round_back_red10);
                    }
                    option4.setTextColor(Color.WHITE);

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "Favor selecionar uma opção", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

        returnIconQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();
                startActivity(new Intent(QuizActivity.this, IntroducaoComputacao.class));
                finish();
            }
        });
    }

    private boolean isCorrectedAnswer() {
        if(selectedOptionByUser.equals(questionsLists.get(currentQuestionPosition).getAnswer())){
            return true;
        }
        return false;
    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionsLists.size()){
            nxtBtn.setText("Finalizar Quiz");
        }
        if(currentQuestionPosition < questionsLists.size()){
            selectedOptionByUser = "";
            setBackgroundResourceOptions();
            setTextColorOptions();
            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());

        }
        else{
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", questionsLists.size() - getCorrectAnswers());
            intent.putExtra("topicName", getTopicName);
            startActivity(intent);
            finish();
        }
    }

    private void setBackgroundResourceOptions(){
        option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
        option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
        option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
        option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
    }

    private void setTextColorOptions(){
        option1.setTextColor(Color.parseColor("#02366c"));
        option2.setTextColor(Color.parseColor("#02366c"));
        option3.setTextColor(Color.parseColor("#02366c"));
        option4.setTextColor(Color.parseColor("#02366c"));
    }

    private void startTimer(){

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds == 0){
                    totalTimeInMins--;
                    seconds = 59;
                }
                else if(seconds == 0 && totalTimeInMins == 0){
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(QuizActivity.this, "Tempo acabou :(", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                    intent.putExtra("corrects", getCorrectAnswers());
                    intent.putExtra("incorrects", questionsLists.size() - getCorrectAnswers());
                    startActivity(intent);
                    finish();
                }
                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0" + finalMinutes;
                        }

                        if(finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }
                        timer = findViewById(R.id.txt_timer);
                        timer.setText(finalMinutes + ":" + finalSeconds);
                    }
                });
            }
        }, 1000, 1000 );
    }

    private int getCorrectAnswers(){
        int correctAnswers = 0;
        for (int i = 0; i<questionsLists.size(); i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();
        startActivity(new Intent(QuizActivity.this, IntroducaoComputacao.class));
        finish();
    }
}