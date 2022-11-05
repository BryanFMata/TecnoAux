package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecnoaux.R;

public class LinguagensTradutoresModulo extends AppCompatActivity {

    private ImageView returnIcon;
    private TextView tittleToolbar;

    private Button btnQuizTextoLinguagens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linguagens_tradutores_modulo);
        returnIcon = findViewById(R.id.return_Icon);
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinguagensTradutoresModulo.this, IntroducaoComputacao.class);
                startActivity(intent);
                finish();
            }
        });
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Linguagens e Tradutores");


        btnQuizTextoLinguagens = findViewById(R.id.btn_quiz_textoLinguagens);
        btnQuizTextoLinguagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinguagensTradutoresModulo.this, QuizActivity.class);
                intent.putExtra("topicName", "linguagens");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LinguagensTradutoresModulo.this, IntroducaoComputacao.class));
        finish();
    }
}