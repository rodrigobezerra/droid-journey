package com.rodrigobezerra.contadorpessoasapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int qtdeHomem = 0;
    int qtdeMulher = 0;
    int qtdePessoas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvPessoas = (TextView) findViewById(R.id.totalPessoas);

        final Button btHomem = (Button) findViewById(R.id.btHomem);

        final Button btMulher = (Button) findViewById(R.id.btMulher);

        final Button btReset = (Button) findViewById(R.id.btReset);

        btHomem.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String totalAnterior = Integer.toString(qtdePessoas);
                final String mensagem = tvPessoas.getText().toString();

                qtdePessoas++;
                qtdeHomem++;

                final String totalAtualizado = Integer.toString(qtdePessoas);
                tvPessoas.setText(mensagem.replace(totalAnterior,totalAtualizado));
                btHomem.setText(Integer.toString(qtdeHomem));

            }
        });

        btMulher.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String totalAnterior = Integer.toString(qtdePessoas);
                final String mensagem = tvPessoas.getText().toString();

                qtdePessoas++;
                qtdeMulher++;

                final String totalAtualizado = Integer.toString(qtdePessoas);
                tvPessoas.setText(mensagem.replace(totalAnterior,totalAtualizado));
                btMulher.setText(Integer.toString(qtdeMulher));

            }
        });

        btReset.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String totalAnterior = Integer.toString(qtdePessoas);
                final String mensagem = tvPessoas.getText().toString();

                qtdeMulher = 0;
                qtdeHomem = 0;
                qtdePessoas = 0;

                btHomem.setText(Integer.toString(0));
                btMulher.setText(Integer.toString(0));

                final String totalAtualizado = Integer.toString(qtdePessoas);
                tvPessoas.setText(mensagem.replace(totalAnterior, totalAtualizado));

            }
        });

    }

}
