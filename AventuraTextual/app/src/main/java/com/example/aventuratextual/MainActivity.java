package com.example.aventuratextual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView fondo, cuadroTexto; //Fondo de pantalla y cuadro de texto

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fondo = (ImageView) findViewById(R.id.imageView);
        cuadroTexto = (ImageView) findViewById(R.id.imageView2);

        ArrayList <String> historia = new ArrayList<String>();
        historia.add("Es el día de Halloween, un grupo de amigos decide celebrarlo, pero ya son un poco mayores " +
                "para los disfraces y este año les apetece hacer algo diferente");
        historia.add("Llevaban días pensando qué hacer para que fuera especial y tener un recuerdo memorable.");
        historia.add("Se les ocurrió que era una buena idea celebrarlo en el cementerio, contando historias de terror, probando a hacer rituales y ,por supuesto, bebiendo");


        Typewriter txtView = findViewById(R.id.type_Characters);
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


        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = historia.get(contador);
                Typewriter texto = findViewById(R.id.type_textView);
                texto.setCharacterDelay(100);
                texto.animatedText(text);
                contador++;
            }
        });











    }
}