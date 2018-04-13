package com.example.xp.isonidos;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    SoundPool sonidos;
    int sonidon1;
    Field[] nombreC = R.raw.class.getFields();
    int[] su = new int[nombreC.length];
    int idC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonidos = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);


        //Selecciono el linerlayout
        LinearLayout principal = (LinearLayout) findViewById(R.id.botones);
        for(int i = 0; i < nombreC.length; i++){
            //creamos un botón por código y lo añadimos a la pantalla principal
            Button b = new Button(this);
            b.setText(nombreC[i].getName());
            b.setTextColor(Color.WHITE);
            b.setBackgroundColor(Color.BLUE);
            b.setAllCaps(false);//todas las letras del botón en minúscula
            b.setTag(i+1);
            b.setId(i);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sonido(v);
                }
            });

            //añadimos el botón al layout
            principal.addView(b);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        for (int i = 0; i < su.length; i++) {
            try {
                idC = nombreC[i].getInt(nombreC[i]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            su[i] = sonidos.load(this, idC , 1);
        }
    }

    public void sonido(View vista) {
        Button boton = (Button) findViewById(vista.getId());
        int numeroSonido = Integer.valueOf(boton.getTag().toString()) - 1;
        sonidos.play(su[numeroSonido], 1, 1, 1, 0, 1);
    }


}
