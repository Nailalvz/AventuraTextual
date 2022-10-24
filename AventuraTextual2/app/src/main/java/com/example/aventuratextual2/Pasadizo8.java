package com.example.aventuratextual2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Pasadizo8 extends AppCompatActivity {

    private ImageView fondo, personaje, cuadroTexto, fantasma;

    private Button si, no, beber, nobeber;

    private int contador = 0, escena = 0, contaux = 0;
    private int decision = 3;

    private boolean pasar = true;

    public static int subidon = 0;
    public static int cordura = 100;

    ArrayList<String> historia = new ArrayList<String>();
    ArrayList<String> verDinos = new ArrayList<String>();
    ArrayList<String> noVerDinos = new ArrayList<String>();
    ArrayList <String> aux = historia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasadizo8);

        Typewriter txtView2 = findViewById(R.id.type_textWriter);
        txtView2.setCharacterDelay(25); //delay con el que se escriben los caracteres

        fondo = (ImageView) findViewById(R.id.pasadizo);
        personaje = (ImageView) findViewById(R.id.personaje);
        cuadroTexto = (ImageView) findViewById(R.id.cuadrotexto);
        fantasma = (ImageView) findViewById(R.id.fantasma);

        si = (Button) findViewById(R.id.buttonsi);
        no = (Button) findViewById(R.id.buttonno);
        beber = (Button) findViewById(R.id.buttonsibeber);
        nobeber = (Button) findViewById(R.id.buttonnobeber);


        personaje.setVisibility(View.INVISIBLE);
        cuadroTexto.setVisibility(View.INVISIBLE);
        fantasma.setVisibility(View.INVISIBLE);
        si.setVisibility(View.INVISIBLE);
        no.setVisibility(View.INVISIBLE);
        beber.setVisibility(View.INVISIBLE);
        nobeber.setVisibility(View.INVISIBLE);

        historia.add("Al llegar al final de la escalera podían divisar un pasadizo subterráneo oscuro. No sabían como de largo era, ya que poco se podía distinguir con la luz que había.");
        historia.add("El lugar era húmedo y frío. Había millones de telarañas por las paredes y demasiada suciedad en aquel sitio.");
        historia.add("No me esperaba que esto estuviera tan oscuro");
        historia.add("Como me toque una araña yo me muero");
        historia.add("YO TAMBIEN, me da igual que haya firulais, ratas o lo que queráis pero ARAÑAS NO...");
        historia.add("Naila sin quejas que dijiste tu de bajar");
        historia.add("Si, pero no esperaba que las escaleras dieran a este lugar");
        historia.add("Está lleno de telarañas. Prefiero que nos aparezca un fantasma que un montón de arañas");
        historia.add("Ostia puta tanto lo pedias pues ahi lo tienes");
        historia.add("Que haceis vosotros aqui, ¿venis a ver mis dinosaurios?");
        historia.add("Que coño dice este");
        historia.add("Qué, dinosaurios? Venga vamos");
        historia.add("...");
        historia.add("Estoy cansada de los dinosaurios");
        historia.add("Shhhhh que no te oiga");
        historia.add("¿Pero queréis verlos o no?");

        verDinos.add("Esto va a salir muy mal");
        verDinos.add("Un fantasma que nos quiere enseñar unos dinosaurios. No se Rick parece falso");
        verDinos.add("Vamos Naila, eres una desconfiada");
        verDinos.add("Aitana agarró a Naila del brazo y comenzó a caminar en dirección al fantasma.");
        verDinos.add("Vale, acompáñenme pues");


        noVerDinos.add("Ay mi bachatasaurio...");
        noVerDinos.add("El fantasma del paleontólogo se va cabizbajo y triste, mientras maldice a los jóvenes entre dientes.");
        noVerDinos.add("Me da pena, parecía un buen tipo");
        noVerDinos.add("Que le den se parece a uno de mi clase que es un pajas");
        noVerDinos.add(" Creo que necesitamos un chupito");

        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pasar){
                    switch (escena){
                        case 0:
                        case 1:
                            cuadroTexto.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            personaje.setVisibility(View.VISIBLE);
                            personaje.setImageResource(R.drawable.quejicadre);
                            break;
                        case 3:
                            personaje.setImageResource(R.drawable.nailaechandolabronca);
                            break;
                        case 4:
                            personaje.setImageResource(R.drawable.tanainsultandoadre);
                            break;
                        case 5:
                            personaje.setImageResource(R.drawable.dre);
                            break;
                        case 6:
                            personaje.setImageResource(R.drawable.naila);
                            break;
                        case 7:
                            personaje.setImageResource(R.drawable.nailaechandolabronca);
                            break;
                        case 8:
                            personaje.setImageResource(R.drawable.quejicadre);
                            fantasma.setVisibility(View.VISIBLE);
                            break;
                        case 9:
                            personaje.setVisibility(View.INVISIBLE);
                            break;
                        case 10:
                            personaje.setVisibility(View.VISIBLE);
                            break;
                        case 11:
                            personaje.setImageResource(R.drawable.happytana);
                            break;
                        case 12:
                            personaje.setImageResource(R.drawable.naila);
                            break;
                        case 13:
                            personaje.setImageResource(R.drawable.nailaechandolabronca);
                            break;
                        case 14:
                            personaje.setImageResource(R.drawable.tanainsultandoadre);
                            break;
                        case 15:
                            pasar = false;
                            personaje.setVisibility(View.INVISIBLE);
                            si.setVisibility(View.VISIBLE);
                            no.setVisibility(View.VISIBLE);
                            break;
                        case 16:
                            //Decision 1 = ver dinos
                            //0 = no ver Dinos
                            contaux = contador;
                            contador = 0;
                            if(decision == 1){
                                aux = verDinos;
                                personaje.setImageResource(R.drawable.dre);
                            } else if(decision == 0){
                                aux = noVerDinos;
                                personaje.setVisibility(View.INVISIBLE);
                            }
                            break;
                        case 17:
                            if(decision == 1){
                                personaje.setImageResource(R.drawable.nailaechandolabronca);
                            } else if(decision == 0){
                                fantasma.setVisibility(View.INVISIBLE);
                                //Suena musica de evil morty
                            }
                            break;
                        case 18:
                            if(decision == 1){
                                personaje.setImageResource(R.drawable.tana);
                            } else if(decision == 0){
                                personaje.setVisibility(View.VISIBLE);
                                personaje.setImageResource(R.drawable.tanainsultandoadre);
                            }
                            break;
                        case 19:
                            if(decision == 1){
                                personaje.setVisibility(View.INVISIBLE);
                                fantasma.setVisibility(View.INVISIBLE);
                            } else if(decision == 0){
                                personaje.setImageResource(R.drawable.quejicadre);
                            }
                            break;
                        case 20:
                            if(decision == 1){
                                fantasma.setVisibility(View.VISIBLE);
                            } else if(decision == 0){
                                personaje.setImageResource(R.drawable.nailaechandolabronca);
                                beber.setVisibility(View.VISIBLE);
                                nobeber.setVisibility(View.VISIBLE);
                                pasar = false;
                            }
                            break;
                        case 21:
                            Intent intent = new Intent(Pasadizo8.this, Activity9.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                            break;

                    }
                    String text = aux.get(contador);
                    txtView2.setCharacterDelay(25);
                    txtView2.animatedText(text);
                    escena++;
                    contador++;
                }
            }
        });

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decision = 1;
                pasar = true;
                si.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                txtView2.animatedText("Venga vamos. Yo quiero verlos");
                personaje.setVisibility(View.VISIBLE);
                personaje.setImageResource(R.drawable.tana);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decision = 0;
                pasar = true;
                si.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                txtView2.animatedText("Vosotros también sois como los demás, no creeis que haya descubierto un tipo nuevo de dinosaurio");

            }
        });

        beber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar = true;
                subeSubidon();
                Intent intent = new Intent(Pasadizo8.this, Activity9.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });

        nobeber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar = true;
                cordura();
                Intent intent = new Intent(Pasadizo8.this, Activity9.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });

    }

    public static void subeSubidon(){
        int valorSubida = (int) (Math.random()*10+1);
        subidon += valorSubida;
    }

    public static void bajaSubidon(){
        int valorBajada = (int) (Math.random()*10+1);
        if (subidon != 0) {
            if(subidon < 10){
                valorBajada = (int) (Math.random()*subidon+1);
                subidon -= valorBajada;
            }else{
                subidon -= valorBajada;
            }
        }
    }

    public static void cordura(){
        if(bajaCordura()){
            int valorBajada = (int) (Math.random()*30+1);
            cordura = cordura - valorBajada;
        }

    }

    //Metodo que saca un número entre el uno y el 5 si el número es menor o igual a 3
    //Entonces la cordura baja y si no se mantiene.
    public static boolean bajaCordura(){
        int baja = (int) (Math.random()*5+1);

        if(baja <= 3){
            return true;
        } else {
            return false;
        }

    }

}