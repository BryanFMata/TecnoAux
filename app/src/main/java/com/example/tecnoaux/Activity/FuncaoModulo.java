package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecnoaux.R;

public class FuncaoModulo extends AppCompatActivity {

    private ImageView returnIcon;
    private TextView tittleToolbar;

    private Button btnQuizTextoFuncao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcao_modulo);
        returnIcon = findViewById(R.id.return_Icon);
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FuncaoModulo.this, IntroducaoComputacao.class);
                startActivity(intent);
                finish();
            }
        });
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Funções");


        btnQuizTextoFuncao = findViewById(R.id.btn_quiz_textoFuncao);
        btnQuizTextoFuncao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FuncaoModulo.this, QuizActivity.class);
                intent.putExtra("topicName", "funcoes");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FuncaoModulo.this, IntroducaoComputacao.class));
        finish();
    }
}