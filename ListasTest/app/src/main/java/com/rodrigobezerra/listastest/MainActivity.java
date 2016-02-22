package com.rodrigobezerra.listastest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView minhaLista;

    private String[] nomes = {"Homer", "Bart", "Lisa", "Maggie",
            "Margie", "Mr. Burns", "Moe",
            "Smithers", "Abraham", "Ajudante de Papai Noel"};

    private String[] descricoes = {"Eu sou o Homer",
            "Eu sou o Bart",
            "Eu sou o Maggie",
            "Eu sou o Margie",
            "Eu sou o Mr. Burns",
            "Eu sou o Moe",
            "Eu sou o Smithers",
            "Eu sou o Abraham",
            "Au au au!!!"};

    int[] listaIcones = {R.drawable.homersimpson,
            R.drawable.bartsimpson,
            R.drawable.lisasimpson,
            R.drawable.maggiesimpson,
            R.drawable.margesimpson,
            R.drawable.mrburns,
            R.drawable.moe,
            R.drawable.smithers,
            R.drawable.abrahamsimpson,
            R.drawable.bartsanta};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minhaLista = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, nomes);

        // minhaLista.setAdapter(adaptador);

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = nomes[position];
                Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_SHORT).show();
            }
        });

        MeuAdaptadorCustom adaptador;

    }
}
