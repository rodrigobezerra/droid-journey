package com.rodrigobezerra.meusalertas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicaTela(View v){
        Log.i("LogX","Clicou na tela!!!");
        // Toast meuToast;
        // meuToast = Toast.makeText(MainActivity.this, "Eu sou o toast", Toast.LENGTH_SHORT);
        // meuToast.show();

        Toast.makeText(MainActivity.this, "Eu sou o toast", Toast.LENGTH_SHORT).show();
        // getApplicationContext(): realiza a chamada da classe responsável pelo acionamento da mensagem;
        // que por exemplo para este caso seria a propria 'MainActivity.this';
        Toast.makeText(getApplicationContext(), "Eu sou o toast também", Toast.LENGTH_SHORT).show();

        Snackbar snackbar;
        snackbar =  Snackbar.make(v, "Eu sou o snackbar", Snackbar.LENGTH_SHORT);
        snackbar.show();

        snackbar.setAction("Snack Action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LogX", "Clicou no snack!!!");
            }
        });

        // Alerta personalisado baseado em um construtor
        AlertDialog.Builder construtorAlerta;
        construtorAlerta = new AlertDialog.Builder(this);
        construtorAlerta.setTitle("Titulo de alerta");
        construtorAlerta.setMessage("Qual é a sua opção?");
        construtorAlerta.setIcon(R.drawable.homer);

        construtorAlerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("LogX", "Clicou no sim!!!");
            }
        });

        construtorAlerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("LogX", "Clicou no não!!!");
            }
        });

        construtorAlerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("LogX", "Clicou no não!!!");
            }
        });

        construtorAlerta.setNeutralButton("Tanto Faz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("LogX", "Clicou no não!!!");
            }
        });

        AlertDialog meuAlerta = construtorAlerta.create();
        meuAlerta.show();
    }

}
