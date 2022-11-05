package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecnoaux.MainActivity;
import com.example.tecnoaux.R;

public class IntroducaoComputacao extends AppCompatActivity {

    private ImageView returnIcon;
    private TextView tittleToolbar;
    private View rectangle_part1;
    private View rectangle_part2;
    private View rectangle_part3;
    private View rectangle_part4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao_computacao);
        returnIcon = findViewById(R.id.return_Icon);
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroducaoComputacao.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Introdução à Computação");
        rectangle_part1 = findViewById(R.id.rectangle_part1);
        rectangle_part1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroducaoComputacao.this, VariaveisModulo.class);
                startActivity(intent);
                finish();
            }
        });
        rectangle_part2 = findViewById(R.id.rectangle_part2);
        rectangle_part2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroducaoComputacao.this, FuncaoModulo.class);
                startActivity(intent);
                finish();
            }
        });
        rectangle_part3 = findViewById(R.id.rectangle_part3);
        rectangle_part3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroducaoComputacao.this, PassagemParametroModulo.class);
                startActivity(intent);
                finish();
            }
        });
        rectangle_part4 = findViewById(R.id.rectangle_part4);
        rectangle_part4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroducaoComputacao.this, LinguagensTradutoresModulo.class);
                startActivity(intent);
                finish();
            }
        }));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(IntroducaoComputacao.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}