package com.example.tecnoaux.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecnoaux.MainActivity;
import com.example.tecnoaux.R;

public class Texto extends AppCompatActivity {
    ImageView returnIcon;
    TextView tittleToolbar;
    String textoEstudo = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
            "It has roots in a piece of classical Latin literature from 45 BC, making it over " +
            "2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in " +
            "Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem " +
            "Ipsum passage, and going through the cites of the word in classical literature, " +
            "discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and " +
            "1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by " +
            "Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very " +
            "popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum " +
            "dolor sit amet..\", comes from a line in section 1.10.32. The standard chunk of " +
            "Lorem Ipsum used since the 1500s is reproduced below for those interested. " +
            "Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" " +
            "by Cicero are also reproduced in their exact original form, accompanied by " +
            "English versions from the 1914 translation by H. Rackham. It is a long established " +
            "fact that a reader will be distracted by the readable content of a page when " +
            "looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less " +
            "normal distribution of letters, as opposed to using 'Content here, content here', " +
            "making it look like readable English.";
    TextView txtViewTextoEstudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        returnIcon = findViewById(R.id.return_Icon);
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Texto.this, IntroducaoComputacao.class);
                startActivity(intent);
                finish();
            }
        });
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Título do Texto");
        txtViewTextoEstudo = findViewById(R.id.txtViewTextoEstudo);
        txtViewTextoEstudo.setText(textoEstudo);
    }
}