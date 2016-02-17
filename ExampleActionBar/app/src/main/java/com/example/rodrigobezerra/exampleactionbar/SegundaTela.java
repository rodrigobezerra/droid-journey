package com.example.rodrigobezerra.exampleactionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        TextView meuTexto = (TextView) findViewById(R.id.txSegundaTela);

        Intent intentNovo = getIntent();
        String texto = intentNovo.getStringExtra("meuTexto");
        meuTexto.setText(texto);
    }

}
