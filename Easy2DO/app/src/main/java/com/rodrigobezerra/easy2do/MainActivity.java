package com.rodrigobezerra.easy2do;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText meuTexto;
    private ListView minhaLista;
    private Button meuBotao;

    private SQLiteDatabase bd;

    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<Integer> ids;
    private ArrayList<String> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuTexto = (EditText) findViewById(R.id.editText);
        minhaLista = (ListView) findViewById(R.id.listView);
        meuBotao = (Button) findViewById(R.id.button);

        carregaTarefas();

        minhaLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                apagarTarefa(ids.get(position));
                return false;
            }
        });

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
            Cursor cursor = bd.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

            int indiceColunaID = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();

            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text1,
                    itens);

            minhaLista.setAdapter(itensAdaptador);

            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("logX", "ID: "+ cursor.getString(indiceColunaID) + "| Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaID)));
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

    private void apagarTarefa(Integer id) {

        try {
            bd.execSQL("DELETE FROM tarefas WHERE id=" + id);
            Toast.makeText(MainActivity.this, "Tarefa removida!", Toast.LENGTH_SHORT).show();
            carregaTarefas(); //recarregar lista de tarefas;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void alertaApagaTarefa(final Integer idSelecionado) {
        String tarefaSelecionada = itens.get(idSelecionado);
        final Integer numeroId = idSelecionado;
        new AlertDialog.Builder(getApplicationContext()).
                setTitle("Aviso!").
                setMessage("Deseja remover a tarefa selecionada?").
                setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        apagarTarefa(ids.get(numeroId));
                    }
                });
    }
}
