package com.example.m08_uf1_barry_issaga_cala_entrega;

import java.util.Random;

public class QuizGame {

    static  public Higher_Lower[] games = {
            new Higher_Lower("God of war", 50000,R.drawable.kratos),
            new Higher_Lower("Devil May Cry", 60000,R.drawable.devilmaycry),
            new Higher_Lower("Sonic", 70000,R.drawable.sonic),
            new Higher_Lower("Infamous", 80000,R.drawable.infamous),
            new Higher_Lower("Prince of Persia", 90000,R.drawable.princeofpersia),
            new Higher_Lower("Age of Empires", 100000,R.drawable.ageofempires),
            new Higher_Lower("GTA", 110000,R.drawable.gta),
            new Higher_Lower("Prototype", 120000,R.drawable.prototype),
            new Higher_Lower("Tekken7", 130000,R.drawable.tekken7),
            new Higher_Lower("Ninja Gaiden", 140000,R.drawable.ryuhayabusa),
            new Higher_Lower("Super Mario", 150000,R.drawable.supermario),
            new Higher_Lower("Street Fighter", 160000,R.drawable.streetfighter),
            new Higher_Lower("Soul Calibur", 170000,R.drawable.soulcalibur),
            new Higher_Lower("Metal Gear Rising", 180000,R.drawable.raiden),
            new Higher_Lower("Halo", 190000,R.drawable.halo)
    };

    static  public Higher_Lower[] animals ={
            new Higher_Lower("Bear",200,R.drawable.bear),
            new Higher_Lower("Chimpanzee",300,R.drawable.chimpanzee),
            new Higher_Lower("Dog",500,R.drawable.dog),
            new Higher_Lower("Hamster",100,R.drawable.hamster),
            new Higher_Lower("Lion",1000,R.drawable.lion),
            new Higher_Lower("Lemur",400,R.drawable.lemur),
            new Higher_Lower("Panther",900,R.drawable.panther),
            new Higher_Lower("Elephant",30000,R.drawable.elephant),
            new Higher_Lower("Rhino",2300,R.drawable.rhino),
            new Higher_Lower("Tiger",4000,R.drawable.tiger),
            new Higher_Lower("Falcon",7000,R.drawable.falcon),
            new Higher_Lower("Cat",8000,R.drawable.cat),
            new Higher_Lower("MountainGoat", 9000,R.drawable.mountaingoat),
            new Higher_Lower("Gorilla", 3000,R.drawable.gorila),
            new Higher_Lower("Buffalo",5000,R.drawable.buffalo)
    };

    static public Higher_Lower[] basketball = {
            new Higher_Lower("Iverson",30000,R.drawable.alleniverson),
            new Higher_Lower("Carmelo", 29000,R.drawable.carmelo),
            new Higher_Lower("Denis Rodman", 28000,R.drawable.dennisrodman),
            new Higher_Lower("Wade", 27000,R.drawable.dwayenwade),
            new Higher_Lower("Boykins", 25000,R.drawable.earlboykins),
            new Higher_Lower("Kobe", 24000,R.drawable.kobebryan),
            new Higher_Lower("Irving", 23000,R.drawable.kyrieirving),
            new Higher_Lower("Lebron", 22000,R.drawable.lebronjames),
            new Higher_Lower("O neal", 21000,R.drawable.oneal),
            new Higher_Lower("Chamberlain", 20000,R.drawable.wiltchamberlain),
            new Higher_Lower("Vince Carter", 19000,R.drawable.vincecarter),
            new Higher_Lower("Tracy Mcgrady", 18000,R.drawable.tracymcgrady),
            new Higher_Lower("Nate Robinson", 17000,R.drawable.naterobinson),
            new Higher_Lower("Steve Nach", 15000,R.drawable.stevenash),
            new Higher_Lower("Michel Jordan", 31000,R.drawable.michealjordan)

        };

    static public Higher_Lower[] mma ={
            new Higher_Lower(" Anderson Silva", 31000, R.drawable.adersonsilva),
            new Higher_Lower("Paulo Costa", 29000,R.drawable.paulocosta),
            new Higher_Lower("Israel Adesanya", 28000,R.drawable.israeladesanya),
            new Higher_Lower("Islam Makachev", 27000,R.drawable.islammackachev),
            new Higher_Lower("Oliveira", 25000,R.drawable.charlesoliveira),
            new Higher_Lower("Nganou", 24000,R.drawable.francisnganou),
            new Higher_Lower("Chimaev", 23000,R.drawable.chimaev),
            new Higher_Lower("Cyril Gane", 22000,R.drawable.cyrilgane),
            new Higher_Lower("Khabib", 21000,R.drawable.khabib),
            new Higher_Lower("Lesnar", 20000,R.drawable.brocklesnar),
            new Higher_Lower("Jon Jones", 19000,R.drawable.jonjones),
            new Higher_Lower("Kamaru Usman", 18000,R.drawable.kamaruusman),
            new Higher_Lower("Conor Mcgregor", 17000,R.drawable.conormcgregor),
            new Higher_Lower("Nate Diaz", 15000,R.drawable.natediaz),
            new Higher_Lower("Overremm", 30000,R.drawable.overremm)
    };

    static public int score;
    static public int theNextQuestion;
    static public int currentQuestion;
    static public int[] shuffleQuiz;

    static  public void InitQuestions(int questionNumbers){
        score = 0;
        theNextQuestion = 0;
        currentQuestion = 0;
        shuffleQuiz = new int[questionNumbers];

        for(int i = 0; i < shuffleQuiz.length;i++){
            shuffleQuiz[i] = i;
        }

        //Change the value
        for(int i = 0; i < shuffleQuiz.length;i++){
            int aux = shuffleQuiz[i];
            Random random = new Random();
            int randomValue = random.nextInt(shuffleQuiz.length);
            shuffleQuiz[i] = shuffleQuiz[randomValue];
            shuffleQuiz[randomValue] = aux;

        }

    }

    static public Higher_Lower getCurrentQuestion(String name){
        switch (name){

            case "animals":
                return animals[shuffleQuiz[currentQuestion]];

            case "mma":
                return mma[shuffleQuiz[currentQuestion]];

            case "basketball":
                return basketball[shuffleQuiz[currentQuestion]];

            case "games":
                return games[shuffleQuiz[currentQuestion]];

        }

        return null;
    }

    static public Higher_Lower getNextQuestion(String name){
        switch (name){

            case "animals":
                return animals[shuffleQuiz[theNextQuestion]];

            case "mma":
                return mma[shuffleQuiz[theNextQuestion]];

            case "basketball":
                return basketball[shuffleQuiz[theNextQuestion]];

            case "games":
                return games[shuffleQuiz[theNextQuestion]];

        }

        return null;
    }

    static public void nextQuestion(){
        currentQuestion++;
    }
    static public void nextCurrentQuestion(){theNextQuestion++;}


    static  public Higher_Lower[] getQuizByName(String name){

        switch (name){

            case "animals":
                return animals;

            case "mma":
                return mma;

            case "basketball":
                return basketball;

            case "games":
                return games;

        }
        return null;
    }
}




