package com.rodrigobezerra.calculadoraapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoTexto;
    private float numeroA = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = (TextView) findViewById(R.id.campoResultado);
        campoTexto.setText("0");
    }

    public void clicaBotao(View v) {
        switch (v.getId()){
            case R.id.btReset:
                campoTexto.setText("0");
                numeroA = 0;
                operacao= "";
                break;
            case  R.id.btAdicao:
                calculaNumeros("+");
                break;
            case  R.id.btSubtrai:
                calculaNumeros("-");
                break;
            case  R.id.btDivide:
                calculaNumeros("/");
                break;
            case  R.id.btMultiplica:
                calculaNumeros("*");
                break;
            case  R.id.btIgual:
                mostraResultado();
                break;
            default:
                String numb;
                numb = ((Button)v).getText().toString();
                if (!numb.equals("0")) {
                    getKeyboard(numb);
                }
                break;
        }

    }

    private void mostraResultado() {
        float numeroB = Float.parseFloat(campoTexto.getText().toString());
        float result = 0;
        if (operacao.equals("+")) {
            result = numeroB + numeroA;

        }
        if (operacao.equals("-")) {
            result = numeroB + numeroA;

        }
        if (operacao.equals("*")) {
            result = numeroB * numeroA;
        }
        if (operacao.equals("/")) {
            result = numeroB / numeroA;
        }
        campoTexto.setText(String.valueOf(result));
    }

    public void calculaNumeros(String tipoOperacao) {
        numeroA = Float.parseFloat(campoTexto.getText().toString());
        operacao = tipoOperacao;
        campoTexto.setText("0");
    }

    public void getKeyboard(String str){
        String scrCurrent = campoTexto.getText().toString();
        scrCurrent += str;
        campoTexto.setText(scrCurrent);
    }
}
