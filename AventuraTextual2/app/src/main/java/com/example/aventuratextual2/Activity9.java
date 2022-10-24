package com.example.aventuratextual2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class Activity9 extends AppCompatActivity {

    private ImageView fondo, cuadroTexto , personaje;
    private Typewriter txt;
    private Button abrir , ignorar;
    private int contador = 0;
    private int decision = -1;
    private boolean pasar = true;
    private VideoView screamer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        Uri uri = Uri.parse("android.resource://" + getPackageName() +"/"+ R.raw.zuzto);

        fondo = (ImageView) findViewById(R.id.puertasuzto);
        cuadroTexto = findViewById(R.id.cuadrotexto);
        personaje = findViewById(R.id.imagedre);
        txt = findViewById(R.id.type_textWriter);
        abrir = findViewById(R.id.buttonsi);
        ignorar = findViewById(R.id.buttonno);
        screamer = (VideoView) findViewById(R.id.video);

        screamer.setVisibility(VideoView.INVISIBLE);
        cuadroTexto.setVisibility(ImageView.INVISIBLE);
        personaje.setVisibility(ImageView.INVISIBLE);
        abrir.setVisibility(ImageView.INVISIBLE);
        ignorar.setVisibility(ImageView.INVISIBLE);

        txt.setCharacterDelay(25); // Delay para la velocidad del texto

        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pasar){
                    switch (contador){
                        case 0:
                            cuadroTexto.setVisibility(ImageView.VISIBLE);
                            txt.animatedText("Llegan a un pasadizo recto y oscuro con mucha humedad y una puerta en el medio.");
                            contador ++;
                            break;
                        case 1:
                            txt.animatedText("Intentan abrirla pero no son capaces.");
                            contador ++;
                            break;
                        case 2:
                            personaje.setVisibility(ImageView.VISIBLE);
                            txt.animatedText("La puerta esta cerrada, necesitaríamos una llave.");
                            contador++;
                            break;
                        case 3:
                            personaje.setImageResource(R.drawable.quejicadre);
                            txt.animatedText("Mira dentro de esos barriles a ver si está.");
                            contador ++;
                            break;
                        case 4:
                            personaje.setImageResource(R.drawable.tana);
                            txt.animatedText(" Pues parece que estaba dentro de uno. Menudo sitio para dejar una llave.");
                            pasar = false;
                            abrir.setVisibility(ImageView.VISIBLE);
                            ignorar.setVisibility(ImageView.VISIBLE);
                            contador ++;
                            break;
                        case 5:
                            if(decision == 1){
                                screamer.setVisibility(VideoView.VISIBLE);
                                screamer.setVideoURI(uri);
                                screamer.start();
                                txt.animatedText("TU MADRE");

                            }else if(decision == 0){
                                personaje.setImageResource(R.drawable.quejicadre);
                                txt.animatedText("Y para eso nos ponemos a buscarla...");
                                contador ++;
                            }
                            break;
                        case 6:
                            if(decision == 0){
                                personaje.setImageResource(R.drawable.tana);
                                txt.animatedText("La verdad es que es mejor pasar y seguir palante.");
                                contador ++;

                            }else if(decision == 1){
                                personaje.setImageResource(R.drawable.tana);
                                txt.animatedText("Corred");
                                contador ++;
                            }
                            break;
                        case 7:
                            if (decision == 0) {
                                personaje.setImageResource(R.drawable.dre);
                                txt.animatedText("Pues nada si no entramos chupitazo.");
                                contador++;
                            } else if(decision == 1){
                                personaje.setImageResource(R.drawable.naila);
                                txt.animatedText("Vamos a morir");
                                contador ++;
                            }
                            break;
                        case 8:
                            if(decision == 1){
                                personaje.setVisibility(ImageView.INVISIBLE);
                                txt.animatedText("Cierran la puerta de golpe dejando al ente dentro.");
                            }else if(decision == 0){
                                personaje.setVisibility(ImageView.VISIBLE);
                                personaje.setImageResource(R.drawable.tana);
                                txt.animatedText("valeee");
                            }
                            break;
                        case 9:
                            if(decision == 0){
                                //siguiente activity
                            }else if(decision == 1){
                                //siguiente acticity
                            }

                    }
                }
            }
        });

        abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrir.setVisibility(ImageView.INVISIBLE);
                ignorar.setVisibility(ImageView.INVISIBLE);
                decision = 1;
                pasar = true;
                personaje.setImageResource(R.drawable.dre);
                txt.animatedText("Olé, vamos a abrirla");
            }
        });

        screamer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!screamer.isPlaying()){
                    // screamer.stopPlayback();
                    screamer.suspend();
                    screamer.setVisibility(VideoView.GONE);
                    contador++;
                }
            }
        });

        ignorar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrir.setVisibility(ImageView.INVISIBLE);
                ignorar.setVisibility(ImageView.INVISIBLE);
                decision = 0;
                pasar = true;
                personaje.setImageResource(R.drawable.naila);
                txt.animatedText("Yo paso de entrar ahi tengo un mal presentimiento.\n");
            }
        }));


    }
}