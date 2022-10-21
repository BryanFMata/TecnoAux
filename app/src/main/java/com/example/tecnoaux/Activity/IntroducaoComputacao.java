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

    ImageView returnIcon;
    TextView tittleToolbar;
    View rectangle_part1;
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
                Intent intent = new Intent(IntroducaoComputacao.this, Texto.class);
                startActivity(intent);
                finish();
            }
        });
    }
}