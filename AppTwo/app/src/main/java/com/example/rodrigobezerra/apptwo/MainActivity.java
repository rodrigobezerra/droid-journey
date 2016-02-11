package com.example.rodrigobezerra.apptwo;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button botaoAlerta = (Button) findViewById(R.id.btAlerta);
        Button botaoNext = (Button) findViewById(R.id.btNext);
        Button botaoCor = (Button) findViewById(R.id.btCor);

        final RelativeLayout fundoTela = (RelativeLayout) findViewById(R.id.minhaView);

        /*
        botaoAlerta.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Log.d("meuLog", "Clicou no botão alerta!");
            }
        });
        */

        botaoNext.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.segunda_tela);
            }
        });

        botaoCor.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                fundoTela.setBackgroundColor(Color.parseColor("#0B9AE2"));
                Log.d("meuLog", "A cor foi alterada!");
            }
        });
    }

    /*  */
    public void alertaNormal(View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Funcionou");
        alertDialog.setMessage("Botão Alerta acionado!");
        alertDialog.show();
    }
}
