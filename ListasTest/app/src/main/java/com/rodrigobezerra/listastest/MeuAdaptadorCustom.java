package com.rodrigobezerra.listastest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rodrigobezerra on 21/02/16.
 */
public class MeuAdaptadorCustom extends ArrayAdapter{

    public MeuAdaptadorCustom(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;

        if (convertView != null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.minha_celula, parent, false);

            handler = new DataHandler();
            handler.imagemIcone = (ImageView) row.findViewById(R.id.icone);
            handler.nomePersonagem = (TextView) row.findViewById(R.id.nome);
            handler.descricaoPersonagem = (TextView) row.findViewById(R.id.descricao);

            row.setTag(handler);
        } else {
            handler = (DataHandler) row.getTag();
        }

        // MeuDataProvider provider;

        return super.getView(position, convertView, parent);
    }

    // inner class
    private class DataHandler{
        ImageView imagemIcone;
        TextView nomePersonagem;
        TextView descricaoPersonagem;
    }
}
