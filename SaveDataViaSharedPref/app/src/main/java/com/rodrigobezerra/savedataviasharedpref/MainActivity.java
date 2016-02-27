package com.rodrigobezerra.savedataviasharedpref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button botao;
    private TextView meuTexto;
    private EditText nome;
    private EditText idade;
    private static String MINHAS_PREFERENCIAS="Minhas preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.btSalvar);
        meuTexto = (TextView) findViewById((R.id.txCompleto));
        nome = (EditText) findViewById(R.id.campoNome);
        idade = (EditText) findViewById(R.id.campoIdade);

        SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, MODE_PRIVATE);

        if (sharedPreferences.contains("nome")) {
            final String nomeUsuario = sharedPreferences.getString("nome","");
            final Integer idadeUsuario = sharedPreferences.getInt("idade", 0);

            meuTexto.setText("Meu Nome é " + nomeUsuario + ", minha idade é " + idadeUsuario + " anos");
        } else {
            meuTexto.setText("Por favor, insira os seus dados!");
        }

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MODE_PRIVATE (0): object can only be edited by this app
                SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                System.out.print("aqui");
                try {
                    editor.putString("nome", nome.getText().toString());
                    editor.putInt("idade", Integer.parseInt(idade.getText().toString()));

                    editor.commit();
                }catch (NumberFormatException e){
                    Log.e("ERRO", e.getMessage());
                }
            }
        });

    }
}
