package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecnoaux.R;

public class PassagemParametroModulo extends AppCompatActivity {

    private ImageView returnIcon;
    private TextView tittleToolbar;

    private Button btnQuizTextoParametro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passagem_parametro_modulo);
        returnIcon = findViewById(R.id.return_Icon);
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassagemParametroModulo.this, IntroducaoComputacao.class);
                startActivity(intent);
                finish();
            }
        });
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Passagem de Parâmetros");


        btnQuizTextoParametro = findViewById(R.id.btn_quiz_textoParametro);
        btnQuizTextoParametro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassagemParametroModulo.this, QuizActivity.class);
                intent.putExtra("topicName", "parametros");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PassagemParametroModulo.this, IntroducaoComputacao.class));
        finish();
    }
}