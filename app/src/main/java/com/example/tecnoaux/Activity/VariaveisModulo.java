package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecnoaux.R;

public class VariaveisModulo extends AppCompatActivity {
    private ImageView returnIcon;
    private TextView tittleToolbar;

    private Button btnQuizTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_variaveis);
        returnIcon = findViewById(R.id.return_Icon);
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VariaveisModulo.this, IntroducaoComputacao.class);
                startActivity(intent);
                finish();
            }
        });
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Título do Texto");


        //btnQuizTexto = findViewById(R.id.btn_quiz_texto);
        /*btnQuizTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VariaveisModulo.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}