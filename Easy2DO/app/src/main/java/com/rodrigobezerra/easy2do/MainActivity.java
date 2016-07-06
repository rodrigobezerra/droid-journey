package com.rodrigobezerra.easy2do;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText meuTexto;
    private ListView minhaLista;
    private Button meuBotao;

    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuTexto = (EditText) findViewById(R.id.editText);
        minhaLista = (ListView) findViewById(R.id.listView);
        meuBotao = (Button) findViewById(R.id.button);

        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionaNovaTarefa(meuTexto.getText().toString());
            }
        });

    }

    private void carregaTarefas() {
        try {

            // Listando os dados
            Cursor cursor = bd.rawQuery("SELECT * FROM tarefas", null);

            int indiceColunaID = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("logX", "ID: "+ cursor.getString(indiceColunaID) +
                        "| Tarefa: " + cursor.getString(indiceColunaTarefa));
                cursor.moveToNext();
            }

        } catch (Exception e) {
            Log.e("logX",e.getMessage().toString());
        }
    }

    private void adicionaNovaTarefa(String novaTarefa) {
        try {
           if (novaTarefa.trim().equals("")){
               Log.w("logX","Tarefa vazia!");
               Toast.makeText(MainActivity.this, "Informe uma tarefa!", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(MainActivity.this, "Tarefa " + novaTarefa + " criada!", Toast.LENGTH_SHORT).show();
               meuTexto.setText("");

               if (bd == null) {
                   bd = openOrCreateDatabase("TODOList", MODE_PRIVATE, null);
                   bd.execSQL("CREATE TABLE IF NOT EXISTS tarefas" +
                           "(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");
               } else {
                   if (!bd.isOpen()){
                       // criacao da tabela 'tarefas'
                       bd = openOrCreateDatabase("TODOList", MODE_PRIVATE, null);
                   }
               }

               bd.execSQL("INSERT INTO tarefas(tarefa) VALUES ('"+ novaTarefa +"')");
               carregaTarefas();
               Log.d("logX","Tarefa " + novaTarefa + " criada!");
           }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void apagarTarefa() {

    }
}
