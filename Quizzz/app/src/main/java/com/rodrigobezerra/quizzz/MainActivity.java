package com.rodrigobezerra.quizzz;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView textoPergunta;

    private RadioButton radioA;
    private RadioButton radioB;
    private RadioButton radioC;

    private Button botaoOK;

    String[] perguntas = {"Primeira pergunta?",
            "Segunda Pergunta?",
            "Terceira pergunta?",
            "Quarta pergunta?",
            "Quinta pergunta?"};

    String[] opcoesA = {"Resposta A primeira pergunta.",
    "Resposta A segunda pergunta",
            "Resposta A terceira pergunta",
            "Resposta A quarta pergunta",
            "Resposta A quinta pergunta"};

    String[] opcoesB = {"Resposta B primeira pergunta.",
            "Resposta B segunda pergunta",
            "Resposta B terceira pergunta",
            "Resposta B quarta pergunta",
            "Resposta B quinta pergunta"};

    String[] opcoesC = {"Resposta C primeira pergunta.",
            "Resposta C segunda pergunta",
            "Resposta C terceira pergunta",
            "Resposta C quarta pergunta",
            "Resposta C quinta pergunta"};

    int[] listaRespostas = new int[perguntas.length];
    int listaGabarito[] = {1,2,3,1,2};
    int respostasCorretas = 0;
    int numeroPergunta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoOK = (Button) findViewById(R.id.btOk);
        botaoOK.setEnabled(false);

        textoPergunta = (TextView) findViewById(R.id.campoTexto);

        radioA = (RadioButton) findViewById(R.id.opcaoA);
        radioB = (RadioButton) findViewById(R.id.opcaoB);
        radioC = (RadioButton) findViewById(R.id.opcaoC);

        radioGroup = (RadioGroup) findViewById(R.id.grupoRadio);

        atualizaPerguntas(botaoOK);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.opcaoA:
                        Log.d("logX","Clicou na alternativa A");
                        listaRespostas[numeroPergunta-1] = 1;
                        break;

                    case R.id.opcaoB:
                        Log.d("logX","Clicou na alternativa B");
                        listaRespostas[numeroPergunta-1] = 2;
                        break;

                    case R.id.opcaoC:
                        Log.d("logX","Clicou na alternativa C");
                        listaRespostas[numeroPergunta-1] = 3;
                        break;
                }
                botaoOK.setEnabled(true);
            }
        });
    }

    public void atualizaPerguntas(View view){

        if (numeroPergunta == perguntas.length) {

            radioA.setEnabled(false);
            radioB.setEnabled(false);
            radioC.setEnabled(false);
            radioGroup.clearCheck();
            confereResultado();


        } else {
            textoPergunta.setText(perguntas[numeroPergunta]);

            radioA.setText(opcoesA[numeroPergunta]);
            radioB.setText(opcoesB[numeroPergunta]);
            radioC.setText(opcoesC[numeroPergunta]);

            numeroPergunta++;
            // limpa todos os radios dentro do grupo e
            // bloqueia o botão ok
            radioGroup.clearCheck();
            botaoOK.setEnabled(false);
        }


    }

    public void confereResultado(){
        int contadorLista = 0;
        for (int numero : listaRespostas) {
            if (numero == listaGabarito[contadorLista]){
                respostasCorretas++;
                Log.d("logX","Resposta correta!!!");
            }else {
                Log.d("logX","Resposta errada!!!");
            }
            contadorLista++;
        }
        alertaResultado(botaoOK);
    }

    public void alertaResultado(View view){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("IT WORKED!");
        alertDialog.setMessage("Você acertou "+ respostasCorretas + " questões!");
        alertDialog.show();

        botaoOK.setEnabled(false);
    }

    public void liberarOK(View view){
        if(radioA.isChecked() || radioB.isChecked() || radioC.isChecked()){
            botaoOK.setEnabled(true);
        }
    }
}


