package com.rodrigobezerra.listastest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView minhaListView;

    private String[] listaNomes = {"Homer", "Bart", "Lisa", "Maggie",
            "Margie", "Mr. Burns", "Moe",
            "Smithers", "Abraham", "Ajudante de Papai Noel"};

    private String[] listaDescricoes = {"Eu sou o Homer",
            "Eu sou o Bart",
            "Eu sou o Lisa",
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
            R.drawable.santas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minhaListView = (ListView) findViewById(R.id.listView);

//        ArrayAdapter<String> meuAdaptador = new ArrayAdapter<String>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1, listaNomes);
//
//        minhaLista.setAdapter(meuAdaptador);

        minhaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = listaNomes[position];
                Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_SHORT).show();
            }
        });

        MeuAdaptadorCustom adaptador;
        adaptador = new MeuAdaptadorCustom(getApplicationContext(),R.layout.minha_celula);
        int i = 0;

        for (String nome: listaNomes) {
            MeuDataProvider dataProvider = new MeuDataProvider(listaIcones[i], nome, listaDescricoes[i]);
            adaptador.add(dataProvider);
            i++;
        }

        minhaListView.setAdapter(adaptador);
    }
}
