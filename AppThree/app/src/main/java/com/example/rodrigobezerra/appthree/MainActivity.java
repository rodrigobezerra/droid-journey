package com.example.rodrigobezerra.appthree;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Handler: classe responsável por manipular o processo principal do app  */
        Handler handler = new Handler();
        handler.postDelayed(this, 2000);
    }

    /*
     * Execução automática após o método onCreate
     */
    @Override
    public void run(){
        startActivity(new Intent(this, TelaPrincipal.class));
        finish();
    }
}
