package com.example.tecnoaux.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tecnoaux.MainActivity;
import com.example.tecnoaux.R;

import android.content.Intent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    ImageView returnIcon;
    TextView tittleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        returnIcon = findViewById(R.id.return_Icon);
        tittleToolbar = findViewById(R.id.tittle_Toolbar);
        tittleToolbar.setText("Dicionário");
        returnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewActivity.this, Dicionario.class);
                startActivity(intent);
                finish();
            }
        });
        TextView mDetailTv = findViewById(R.id.textView);

        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");

        tittleToolbar.setText(mActionBarTitle);

        //set text in textview
        mDetailTv.setText(mContent);
    }
}