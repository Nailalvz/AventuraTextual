package com.example.aventuratextual2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class Activity9 extends AppCompatActivity {

    private ImageView fondo, cuadroTexto , personaje;
    private Typewriter txt;
    private Button abrir , ignorar;
    private int contador = 0;
    private int decision = -1;
    private boolean pasar = true;
    private VideoView screamer;

    public static int subidon;
    public static int cordura;

    //Progress Bar de subidon y cordura
    private ProgressBar subid;
    private ProgressBar cordur;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

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
                            txt.animatedText("Intentan abrirla, pero no son capaces.");
                            contador ++;
                            break;
                        case 2:
                            personaje.setVisibility(ImageView.VISIBLE);
                            txt.animatedText("La puerta esta cerrada, necesitar??amos una llave.");
                            contador++;
                            break;
                        case 3:
                            personaje.setImageResource(R.drawable.quejicadre);
                            txt.animatedText("Mira dentro de esos barriles a ver si est??.");
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
                                //En este activity en el gui??n no pone nada de que sube el subidon pero como pone chupitazo
                                //Pues lo he a??adido
                                subeSubidon();
                                subid.setProgress(subidon);
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
                                contador++;
                            }else if(decision == 0){
                                personaje.setVisibility(ImageView.VISIBLE);
                                personaje.setImageResource(R.drawable.tana);
                                txt.animatedText("valeee");
                                contador++;
                            }
                            break;
                        case 9:
                            if(decision == 0){
                                Intent intent = new Intent(Activity9.this, PasilloCalaveras10.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("subidon", subidon);
                                intent.putExtra("cordura", cordura);
                                startActivity(intent);
                                finish();
                            }else if(decision == 1){
                                Intent intent = new Intent(Activity9.this, PasilloCalaveras10.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("subidon", subidon);
                                intent.putExtra("cordura", cordura);
                                startActivity(intent);
                                finish();
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
                bajaCordura();
                cordur.setProgress(cordura);
                personaje.setImageResource(R.drawable.dre);
                txt.animatedText("Ol??, vamos a abrirla");
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
                txt.animatedText("Yo paso de entrar ah?? tengo un mal presentimiento.");
            }
        }));

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