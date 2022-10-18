package com.example.aventuratextual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typewriter txtView = findViewById(R.id.type_Characters);
        txtView.setText("");
        txtView.setCharacterDelay(150);

        txtView.animatedText("31 de Octubre");
        super.onStart();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                txtView.setVisibility(Typewriter.INVISIBLE);
            }
        }, 4000);



    }
}