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
 * A classe "MeuAdaptadorCustom" herda ArrayAdapter e consequentemente,
 * seus métodos necessários para uso na lista.
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

    /**
     * O método getView obtém uma view responsável por exibir os
     * dados na posição especificada no conjunto de dados.
     *
     * O convertView é um parâmetro usado estritamente para aumentar
     * o desempenho do seu adaptador. Quando um ListView usa um adapter
     * para preencher suas linhas com views, o adapter preencherá cada
     * item da lista com um objeto de exibição, chamando getView() em cada linha.
     * O adapter usa o convertView como uma maneira de "reciclar" Views que não
     * estão mais sendo utilizadas. Desta forma, o ListView pode enviar o adapter
     * antigo, "reciclado" com as views que não estão mais sendo exibidas em vez
     * de instanciar um objeto inteiramente novo cada vez que o adaptador quiser
     * exibir um novo item da lista. Esta é a finalidade do parâmetro convertView.
     *
     * De uma forma macro, o getTag tem a responsabilidade de armazenar o objeto,
     * enquanto o setTag permite a geração de chaves exclusivas para cada Tag,
     * utilizado para referenciar o objeto.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;

        if (convertView == null) {
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

        // Filling in the dataProvider object
        MeuDataProvider provider;
        provider = (MeuDataProvider) this.getItem(position);
        handler.imagemIcone.setImageResource(provider.getIcone());
        handler.nomePersonagem.setText(provider.getNome());
        handler.descricaoPersonagem.setText(provider.getDescricao());

        return row;
    }

    // inner class
    private class DataHandler{
        ImageView imagemIcone;
        TextView nomePersonagem;
        TextView descricaoPersonagem;
    }
}
