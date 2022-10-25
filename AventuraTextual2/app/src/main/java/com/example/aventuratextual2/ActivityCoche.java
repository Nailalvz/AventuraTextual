package com.example.aventuratextual2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityCoche extends AppCompatActivity {
    private int cordura , subidon , contador;
    private ImageView fondo, cuadroTexto, personaje ;
    private Typewriter txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche6);

        fondo = findViewById(R.id.fondoCoche);
        cuadroTexto = findViewById(R.id.cuadrotexto);
        personaje = findViewById(R.id.imagedre);
        txt = findViewById(R.id.type_textWriter);


        cuadroTexto.setVisibility(ImageView.INVISIBLE);
        personaje.setVisibility(ImageView.INVISIBLE);

        txt.setCharacterDelay(25); // Delay para la velocidad del texto


        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cordura < 50 && subidon > 85){
                    switch (contador){
                        case 0:
                            personaje.setVisibility(ImageView.VISIBLE);
                            cuadroTexto.setVisibility(ImageView.VISIBLE);
                            txt.setVisibility(Typewriter.VISIBLE);
                            txt.animatedText("Bueno bro se hizo tarde nosotros nos vamos.");
                            contador ++;
                        case 1:
                            personaje.setImageResource(R.drawable.naila);
                            txt.animatedText("Bye bye");
                            contador ++;
                        case 2:
                            personaje.setImageResource(R.drawable.tana);
                            txt.animatedText("Estuvo bien conocerte pero deberíamos volver ya.");
                            contador ++;
                        case 3:
                            personaje.setVisibility(ImageView.INVISIBLE);
                            txt.animatedText(" Los chavales se dirigen a sus casa  pero de repente se les cruza una vaca por el camino y tienen un grave accidente de coche.");
                            contador ++;
                        case 4:
                            personaje.setVisibility(ImageView.VISIBLE);
                            personaje.setImageResource(R.drawable.israel);
                            txt.animatedText("JAJAJA, os caería bien pero el mate ese no era buena idea tomarlo");
                            contador ++;
                        case 5:
                            personaje.setVisibility(ImageView.INVISIBLE);
                            txt.animatedText("Por conducir bebidos estaban condenados a deambular por el cementerio toda la eternidad");
                            contador ++;
                        case 6:
                            txt.animatedText("Recuerda, si bebes no conduzcas. Dirección General de Tráfico.");
                    }
                }else{
                    switch (contador){
                        case 0:
                            personaje.setVisibility(ImageView.VISIBLE);
                            cuadroTexto.setVisibility(ImageView.VISIBLE);
                            txt.setVisibility(Typewriter.VISIBLE);
                            txt.animatedText("Ese mate me mato. Yo no estoy para conducir ahora.");
                            contador++;
                            break;
                        case 1:
                            personaje.setImageResource(R.drawable.naila);
                            txt.animatedText(" Pues no queda otra que dormir en el coche.");
                            contador++;
                            break;
                        case 2:
                            personaje.setImageResource(R.drawable.tana);
                            txt.animatedText("Y una mierda yo me voy andando");
                            contador ++;
                            break;
                        case 3:
                            personaje.setImageResource(R.drawable.quejicadre);
                            txt.animatedText("Como quieras yo voy a sobar, Además está amaneciendo.");
                            contador ++;
                            break;
                        case 4:
                            personaje.setImageResource(R.drawable.naila);
                            txt.animatedText("Aitana es mejor dormir en el coche que caminar por el bosque sola. Te puedes encontrar con algún otro fantasma como los anteriores. ¿Estás segura de que quieres eso?");
                            contador++;
                            break;
                        case 5:
                            personaje.setImageResource(R.drawable.tana);
                            txt.animatedText("Tienes razón. Mejor me quedo aquí.");
                            contador ++;
                            break;
                        case 6:
                            personaje.setVisibility(ImageView.INVISIBLE);
                            txt.animatedText("Se pasaron toda la mañana durmiendo");
                            contador ++;
                            break;
                        case 7:
                            Intent intnt = new Intent(ActivityCoche.this, MainActivity2_Final.class);
                            startActivity(intnt);

                    }
                }
            }
        });
    }
}