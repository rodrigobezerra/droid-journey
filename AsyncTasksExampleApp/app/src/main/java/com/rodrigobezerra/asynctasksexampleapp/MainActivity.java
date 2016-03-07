package com.rodrigobezerra.asynctasksexampleapp;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private Button botao;
    private ImageView imagem;
    private String urlImagem = "http://wallpapercave.com/wp/tqKF1yF.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.button);
        imagem = (ImageView) findViewById(R.id.imageView);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagemDownloader imagemDownloader = new ImagemDownloader();
                imagemDownloader.execute(urlImagem);
            }
        });

    }

    public class ImagemDownloader extends AsyncTask<String, String, Bitmap>{

        AlertDialog alerta = new AlertDialog.Builder(MainActivity.this)
                .setMessage("Carregando imagem...")
                .show();

        @Override
        protected Bitmap doInBackground(String... params) {

            try{
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
                return bitmap;
            }catch(Exception e){
                Log.e("Logx", e.getMessage().toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            if(bitmap != null) {
                imagem.setImageBitmap(bitmap);
                alerta.hide();
            }
            super.onPostExecute(bitmap);
        }
    }
}
