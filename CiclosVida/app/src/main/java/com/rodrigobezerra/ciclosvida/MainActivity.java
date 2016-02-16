package com.rodrigobezerra.ciclosvida;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log.d("meuLog","{EVENTO} Abriu Cena!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("meuLog","{EVENTO} STOP");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("meuLog","{EVENTO} TOUCH EVENT");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("meuLog", "{EVENTO} START");
    }

    @Override
    protected void onPause() {
        Log.d("meuLog","{EVENTO} PAUSE");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("meuLog","{EVENTO} RESUME");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {

        Log.d("meuLog","{EVENTO} DESTROY");
        super.onDestroy();
    }
}

