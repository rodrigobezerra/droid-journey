package com.rodrigobezerra.sqlitetestapp;

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

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Inicializando o banco de dados SQLite
            SQLiteDatabase database = openOrCreateDatabase("MeuApp",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS cadastro_pessoas (nome VARCHAR, idade INT(3))");
//            database.execSQL("INSERT INTO cadastro_pessoas values('Rodrigo Bezerra',28)");
//            database.execSQL("INSERT INTO cadastro_pessoas values('Angela Argenta',24)");
//            database.execSQL("INSERT INTO cadastro_pessoas values('Laura Pinheiro',23)");
//
//            database.execSQL("DELETE FROM cadatro_pessoas WHERE nome LIKE '%rodrigo%'");

//            database.execSQL("DROP TABLE cadastro_pessoas");


            // Em caso de erro a função rawQuery retorna null
            Cursor cursor = database.rawQuery("SELECT * FROM cadastro_pessoas",null);
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while(cursor != null) {
                Log.i("LogX", cursor.getString(indiceNome));
                Log.i("LogX", cursor.getString(indiceIdade));

                if(!cursor.isLast()){
                    cursor.moveToNext(); // próximo registro
                }else{
                    break;
                }

            }
        }catch (Exception e){
            Log.e("LogX",e.getMessage());
        }

    }
}
