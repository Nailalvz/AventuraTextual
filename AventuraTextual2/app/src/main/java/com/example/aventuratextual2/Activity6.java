package com.example.aventuratextual2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity6 extends AppCompatActivity {
    //Declaración de variables
    private ImageView fondo, cuadroTexto , personaje ; //Fondo de pantalla y cuadro de texto
    private Typewriter texto;
    private int contador =0;
    private  boolean pasar = true;
    private Button bsi, bno;
    private int decision = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        //Vincular cada layout con su id
        fondo = findViewById(R.id.fondo);
        cuadroTexto = findViewById(R.id.cuadrotxt);
        personaje = findViewById(R.id.xandre);
        bno = findViewById(R.id.buttonno);
        bsi = findViewById(R.id.buttonsi);
        texto = findViewById(R.id.textView);

        //Poner los layouts invisible para que solo se vea el fondo
        cuadroTexto.setVisibility(ImageView.INVISIBLE);
        personaje.setVisibility(ImageView.INVISIBLE);
        bno.setVisibility(Button.INVISIBLE);
        bsi.setVisibility(Button.INVISIBLE);

        texto.setCharacterDelay(25); // Delay para la velocidad del texto
        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if para controlar que tome una decisión en el case 1
                if(pasar){
                    switch (contador){
                        case 0:
                            cuadroTexto.setVisibility(ImageView.VISIBLE);
                            personaje.setVisibility(ImageView.VISIBLE);
                            texto.animatedText("Venga chicos ¿Y si vamos todos? Así tiene más gracia, voy yo primero no os rayeis.");
                            contador ++;
                            break;
                        case 1:
                            personaje.setImageResource(R.drawable.tana);
                            texto.animatedText("Si quieres que entre ahí, tengo que beber más");
                            pasar = false;
                            bno.setVisibility(Button.VISIBLE);
                            bsi.setVisibility(Button.VISIBLE);
                            contador ++;
                            break;

                        case 2:
                            //no
                            if(decision == 0){
                                personaje.setImageResource(R.drawable.tana);
                                texto.animatedText("Que no es eso hombre, asi es mas divertido, pero bueno da igual.");
                                contador ++;
                                //si
                            }else if(decision == 1){
                                personaje.setImageResource(R.drawable.naila);
                                texto.animatedText("Xandre coge el ron.");
                                contador ++;
                            }
                            break;
                        case 3:
                            //no
                            if(decision == 0){
                                personaje.setImageResource(R.drawable.naila);
                                texto.animatedText("Xandre coge el ron.");
                                contador ++;
                                //si
                            }else if(decision == 1){
                                personaje.setImageResource(R.drawable.quejicadre);
                                texto.animatedText("Yo nunca me dejo el ron.");
                                contador ++;
                            }
                            break;
                        case 4:
                            //no
                            if(decision == 0 ){
                                personaje.setImageResource(R.drawable.quejicadre);
                                texto.animatedText("Yo nunca me dejo el ron.");
                                contador ++;
                                //si
                            }else if (decision == 1){
                                //cambiar intent
                                Intent intent = new Intent(Activity6.this, InteriorMausoleo7.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }
                            break;

                        case 5:
                                //cambiar intent
                                Intent intento = new Intent(Activity6.this, InteriorMausoleo7.class);
                                                                intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                                startActivity(intento);
                                                                finish();
                    }
                }
            }
        });

        //Boton por si decide no beber
        bno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bno.setVisibility(Button.INVISIBLE);
                bsi.setVisibility(Button.INVISIBLE);
                decision = 0;
                pasar = true;
                texto.animatedText("Aitana, no seas miedica no va a pasar nada, vamos.");
                personaje.setImageResource(R.drawable.quejicadre);


            }
        });
        //Boton por si decide beber
        bsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bno.setVisibility(Button.INVISIBLE);
                bsi.setVisibility(Button.INVISIBLE);
                decision = 1;
                pasar = true;
                texto.animatedText("Dale");
                personaje.setImageResource(R.drawable.quejicadre);

            }
        });
    }
}