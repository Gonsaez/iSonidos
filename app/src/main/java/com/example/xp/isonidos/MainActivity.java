package com.example.xp.isonidos;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SoundPool sonidos;
    int sonidon1;
    int[] su = new int[57];
    int sonidon2;
    int sonidon3;
    int sonidon4;
    int sonidon5;
    int sonidon6;
    int sonidon7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonidos = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        sonidon1 = sonidos.load(this, R.raw.inflar, 1);
        sonidon2 = sonidos.load(this, R.raw.memociono, 1);
        sonidon3 = sonidos.load(this, R.raw.oh_ma_gawd, 1);
        sonidon4 = sonidos.load(this, R.raw.bitesdedust, 1);
        sonidon5 = sonidos.load(this, R.raw.pedrerol_ya_esta_bien, 1);
        sonidon6 = sonidos.load(this, R.raw.notte, 1);
        sonidon7 = sonidos.load(this, R.raw.al_carrer, 1);
    }

    public void sonido(View vista){
        Button boton = (Button) findViewById(vista.getId());
        int numeroSonido = Integer.valueOf(boton.getTag().toString());
        switch (numeroSonido){
            case 0: sonidos.play(sonidon1,1,1,1,0,1f);  break;
            case 1: sonidos.play(sonidon2,1,1,1,0,1f); break;
            case 2: sonidos.play(sonidon3,1,1,1,0,1f); break;
            case 3: sonidos.play(sonidon4,1,1,1,0,1f); break;
            case 4: sonidos.play(sonidon5,1,1,1,0,1f); break;
            case 5: sonidos.play(sonidon6,1,1,1,0,1f); break;
            case 6: MediaPlayer mp = MediaPlayer.create(this, R.raw.al_carrer ); mp.start();break;
            default: sonidos.play(sonidon1,1,1,1,0,1f);  break;
        }


    }


}
