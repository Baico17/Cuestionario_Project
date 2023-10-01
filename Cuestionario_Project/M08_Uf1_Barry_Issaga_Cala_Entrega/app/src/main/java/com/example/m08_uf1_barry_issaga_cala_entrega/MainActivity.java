package com.example.m08_uf1_barry_issaga_cala_entrega;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonChoiceAnimals, buttonChoiceMma, buttonChoiceBasketball, buttonChoiceGame;
    TextView textViewInitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonChoiceGame = findViewById(R.id.option_games);
        buttonChoiceBasketball = findViewById(R.id.option_basketball);
        buttonChoiceMma = findViewById(R.id.option_mma);
        buttonChoiceAnimals = findViewById(R.id.option_animals);



        textViewInitial = findViewById(R.id.textView);

        // Manage the options

        buttonChoiceAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key","animals");
                startActivity(intent);
            }
        });

        buttonChoiceGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key","games");
                startActivity(intent);
            }
        });

        buttonChoiceMma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key","mma");
                startActivity(intent);
            }
        });

        buttonChoiceBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key","basketball");
                startActivity(intent);
            }
        });



    }


}