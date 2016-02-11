package com.rodrigobezerra.ciclosvida;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("meuLog","{EVENTO} Abriu Cena!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("meuLog", "{EVENTO} Saiu do App!!!");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("meuLog","{EVENTO} Tocou na Cena!!!");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("meuLog", "{EVENTO} Abriu App!!!");
    }

    @Override
    protected void onPause() {
        Log.d("meuLog","{EVENTO} Pausou App!!!");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("meuLog","{EVENTO} Voltou para o App!!!");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

