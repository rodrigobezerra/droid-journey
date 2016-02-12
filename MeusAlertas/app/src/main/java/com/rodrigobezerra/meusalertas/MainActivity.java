package com.rodrigobezerra.meusalertas;

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

        Snackbar snackbar = Snackbar.make(v, "Eu sou o snackbar", Snackbar.LENGTH_SHORT);
        snackbar.show();
        //snackbar.setAction();
    }
}
