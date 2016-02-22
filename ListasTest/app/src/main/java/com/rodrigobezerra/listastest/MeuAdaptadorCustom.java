package com.rodrigobezerra.listastest;

import android.content.Context;
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

        return super.getView(position, convertView, parent);
    }

    private class DataHandler{
        ImageView imageIcon;
        TextView nomePersonagem;
        TextView descricaoPersonagem;
    }
}
