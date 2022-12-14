package com.example.aventuratextual2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class Pasadizo8 extends AppCompatActivity {

    private ImageView fondo, personaje, cuadroTexto, fantasma;

    private Button si, no, beber, nobeber;

    private int contador = 0, escena = 0, contaux = 0;
    private int decision = 3;

    private boolean pasar = true;

    public static int subidon;
    public static int cordura;

    //Progress Bar de subidon y cordura
    private ProgressBar subid;
    private ProgressBar cordur;

    ArrayList<String> historia = new ArrayList<String>();
    ArrayList<String> verDinos = new ArrayList<String>();
    ArrayList<String> noVerDinos = new ArrayList<String>();
    ArrayList <String> aux = historia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasadizo8);

        //Coger los valores de subidon y cordura del anterior activity
        Bundle extras = getIntent().getExtras();
        subidon = extras.getInt("subidon");
        cordura = extras.getInt("cordura");

        //Progress bar Subidon
        subid = findViewById(R.id.subidonBar);
        //Progress bar cordura
        cordur = findViewById(R.id.corduraBar);

        subid.setProgress(subidon);
        cordur.setProgress(cordura);

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

        historia.add("Al llegar al final de la escalera pod??an divisar un pasadizo subterr??neo oscuro. No sab??an como de largo era, ya que poco se pod??a distinguir con la luz que hab??a.");
        historia.add("El lugar era h??medo y fr??o. Hab??a millones de telara??as por las paredes y demasiada suciedad en aquel sitio.");
        historia.add("No me esperaba que esto estuviera tan oscuro");
        historia.add("Como me toque una ara??a yo me muero");
        historia.add("YO TAMBI??N, me da igual que haya firulais, ratas o lo que quer??is pero ARA??AS NO...");
        historia.add("Naila sin quejas que dijiste t?? de bajar");
        historia.add("S??, pero no esperaba que las escaleras dieran a este lugar");
        historia.add("Est?? lleno de telara??as. Prefiero que nos aparezca un fantasma que un mont??n de ara??as");
        historia.add("Ostia puta, tanto lo ped??as pues ah?? lo tienes");
        historia.add("Que haceis vosotros aqu??, ??ven??s a ver mis dinosaurios?");
        historia.add("??Qu?? co??o dice este?");
        historia.add("Qu?? dinosaurios? Venga, vamos");
        historia.add("...");
        historia.add("Estoy cansada de los dinosaurios");
        historia.add("Shhhhh que no te oiga");
        historia.add("??Pero quer??is verlos o no?");

        verDinos.add("Esto va a salir muy mal");
        verDinos.add("Un fantasma que nos quiere ense??ar unos dinosaurios. No s?? Rick, parece falso");
        verDinos.add("Vamos Naila, eres una desconfiada");
        verDinos.add("Aitana agarr?? a Naila del brazo y comenz?? a caminar en direcci??n al fantasma.");
        verDinos.add("Vale, acomp????enme pues");


        noVerDinos.add("Ay mi bachatasaurio...");
        noVerDinos.add("El fantasma del paleont??logo se va cabizbajo y triste, mientras maldice a los j??venes entre dientes.");
        noVerDinos.add("Me da pena, parec??a un buen tipo");
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
                            if(decision == 1){
                                Intent intent = new Intent(Pasadizo8.this, VerDinos.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("subidon", subidon);
                                intent.putExtra("cordura", cordura);
                                startActivity(intent);
                                finish();
                            } else if(decision == 0){
                                Intent intent = new Intent(Pasadizo8.this, ActivityNoVerDinos.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("subidon", subidon);
                                intent.putExtra("cordura", cordura);
                                startActivity(intent);
                                finish();
                            }

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

        //Ver dinos
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

        //No ver Dinos
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decision = 0;
                pasar = true;
                si.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                bajaCordura();
                cordur.setProgress(cordura);
                txtView2.animatedText("Vosotros tambi??n sois como los dem??s, no creeis que haya descubierto un tipo nuevo de dinosaurio");

            }
        });

        beber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar = true;
                subeSubidon();
                subid.setProgress(subidon);
                Intent intent = new Intent(Pasadizo8.this, Activity9.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("subidon", subidon);
                intent.putExtra("cordura", cordura);
                startActivity(intent);
                finish();

            }
        });

        nobeber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar = true;
                bajaSubidon();
                subid.setProgress(subidon);
                Intent intent = new Intent(Pasadizo8.this, Activity9.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("subidon", subidon);
                intent.putExtra("cordura", cordura);
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

    public static void bajaCordura() {
        if(cordura > 20){
            int valorBajada = (int) (Math.random()*30+5); //Si no baja muy poco
            cordura = cordura - valorBajada;
        }
    }

    public static void corduraRandom(){
        if(bajaCorduraRandom()){
            int valorBajada = (int) (Math.random()*30+1);
            cordura = cordura - valorBajada;
        }

    }

    //Metodo que saca un n??mero entre el uno y el 5 si el n??mero es menor o igual a 3
    //Entonces la cordura baja y si no se mantiene.
    public static boolean bajaCorduraRandom(){
        int baja = (int) (Math.random()*5+1);

        if(baja <= 3){
            return true;
        } else {
            return false;
        }

    }

}