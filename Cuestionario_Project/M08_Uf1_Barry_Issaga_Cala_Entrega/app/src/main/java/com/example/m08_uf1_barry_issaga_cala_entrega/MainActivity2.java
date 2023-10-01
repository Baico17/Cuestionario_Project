package com.example.m08_uf1_barry_issaga_cala_entrega;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Button higher,lower;
    ImageView image1,image2;
    TextView textName, numberText, scoreText,textName2,textWellDone;
    Higher_Lower currentQuestion, nextQuestion, aux;
    String key;
    int gameScore;
    int answersNumbers;
    int quizSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        higher = findViewById(R.id.Higher);
        lower =  findViewById(R.id.Lower);
        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        textName = findViewById(R.id.textViewName);
        textName2 = findViewById(R.id.textView4);
        textWellDone = findViewById(R.id.textViewWellDone);
        numberText = findViewById(R.id.textView7);
        scoreText = findViewById(R.id.textViewScore);

        Intent intent = getIntent();


         key = intent.getStringExtra("key");


        //Higher_Lower currentQuestion, nextQuestion;

        Higher_Lower[] quizSelected = QuizGame.getQuizByName(key);

        quizSize = quizSelected.length;
        answersNumbers = 0;

        QuizGame.InitQuestions(quizSize);
        currentQuestion = QuizGame.getCurrentQuestion(key);



        QuizGame.InitQuestions(quizSize);
        nextQuestion = QuizGame.getNextQuestion(key);
        LoadInformation(currentQuestion,nextQuestion);

        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestion.value != nextQuestion.value) {

                    if (currentQuestion.value > nextQuestion.value) {
                        gameScore = QuizGame.score++;

                        answersNumbers++;

                        if (answersNumbers >= quizSize*0.6) {

                                textWellDone.setText("WELL DONE");

                        }

                        if(answersNumbers >= quizSize){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            gameScore = 0;
                        }

                        aux = nextQuestion;

                        QuizGame.nextQuestion();
                        currentQuestion = QuizGame.getCurrentQuestion(key);
                        nextQuestion = currentQuestion;
                        currentQuestion = aux;

                        LoadInformation(aux, nextQuestion);

                    } else {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        gameScore = 0;
                    }
                }
            }
        });

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestion.value!= nextQuestion.value) {

                    if (currentQuestion.value < nextQuestion.value) {
                        gameScore = QuizGame.score++;
                        answersNumbers++;

                        if (answersNumbers >= quizSize * 0.6) {
                            textWellDone.setText("WELL DONE");
                        }

                        if(answersNumbers >= quizSize){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            gameScore = 0;
                        }

                        aux = nextQuestion;

                        QuizGame.nextQuestion();
                        currentQuestion = QuizGame.getCurrentQuestion(key);
                        nextQuestion = currentQuestion;
                        currentQuestion = aux;

                        LoadInformation(aux, nextQuestion);

                    } else {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        gameScore = 0;
                    }
                }
            }
        });

    }

    public void LoadInformation(Higher_Lower currentQuestion, Higher_Lower nextQuestion){

        image1.setImageResource(currentQuestion.drawable);
        image2.setImageResource(nextQuestion.drawable);
        textName.setText(currentQuestion.title);
        textName2.setText(nextQuestion.title);
        int numberViews = currentQuestion.value;
        String numberStringsViews = String.valueOf(numberViews);
        numberText.setText(numberStringsViews);
        String scoreGameString = String.valueOf(gameScore);
        scoreText.setText(scoreGameString);


    }

}
