package com.example.tecnoaux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.tecnoaux.Activity.Dicionario;
import com.example.tecnoaux.Activity.IntroducaoComputacao;
import com.example.tecnoaux.Activity.Login;
import com.example.tecnoaux.ui.main.ListViewAdapter;
import com.example.tecnoaux.ui.main.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_logout;
    View rectangle_Dicionario;
    ImageView logoutIcon;
    View rectangle_Introducao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        logoutIcon = findViewById(R.id.logout_icon);
        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mAuth.signOut();
               Intent intent = new Intent(MainActivity.this,Login.class);
               startActivity(intent);
               finish();
            }
        });
        rectangle_Dicionario = findViewById(R.id.rectangle_Dicionario);
        rectangle_Dicionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dicionario.class);
                startActivity(intent);
                finish();
            }
        });
        rectangle_Introducao = findViewById(R.id.rectangle_Introducao);
        rectangle_Introducao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntroducaoComputacao.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
    }


}