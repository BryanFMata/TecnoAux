package com.example.tecnoaux;

import androidx.annotation.NonNull;
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
import android.widget.TextView;

import com.example.tecnoaux.Activity.Dicionario;
import com.example.tecnoaux.Activity.IntroducaoComputacao;
import com.example.tecnoaux.Activity.Login;
import com.example.tecnoaux.Models.UserModel;
import com.example.tecnoaux.ui.main.ListViewAdapter;
import com.example.tecnoaux.ui.main.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_logout;
    private TextView txt_nome_usuario;
    View rectangle_Dicionario;
    ImageView logoutIcon;
    View rectangle_Introducao;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    String usuarioId;
    UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_nome_usuario = findViewById(R.id.txt_nome_usuario);

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

        if(currentUser != null){
            usuarioId = currentUser.getUid().toString();
            databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");
            if(!usuarioId.isEmpty()){
                getUserData();
            }
        }else{
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
    }

    private void getUserData() {
        databaseReference.child(usuarioId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel user1 = snapshot.getValue(UserModel.class);
                txt_nome_usuario.setText("Olá " + user1.getNome());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}