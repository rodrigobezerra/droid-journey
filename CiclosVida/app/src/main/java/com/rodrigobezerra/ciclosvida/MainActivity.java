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

        // Log.d("LogX", "{EVENTO} Abriu Cena!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LogX","EVENTO:STOP");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("LogX","EVENTO:TOUCH EVENT");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStart() {
        Log.d("LogX", "EVENTO:START");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("LogX","EVENTO:PAUSE");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("LogX","EVENTO:RESUME");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {

        Log.d("LogX","EVENTO:DESTROY");
        super.onDestroy();
    }
}