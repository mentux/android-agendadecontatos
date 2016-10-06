package net.tormen.agendadecontatos.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import net.tormen.agendadecontatos.R;
import net.tormen.agendadecontatos.model.Contato;

import java.util.List;

/**
 * Created by tormen on 04/10/16.
 */

public class MinhaListViewAdapter extends BaseAdapter {
    private List<Contato> items;
    private int layoutResourceId;
    private Context context;
    private LayoutInflater mInflater;

    public MinhaListViewAdapter(Context context, int layoutResourceId, List<Contato> items) {
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ContatoHolder itemHolder = null;
        if (view == null) {
            view = mInflater.inflate(layoutResourceId, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ContatoHolder();
            itemHolder.nome = ((EditText) view.findViewById(R.id.atomPay_name));
            itemHolder.btnDeleteContato = ((ImageButton) view.findViewById(R.id.btListViewRemove));

            //define os itens na view;
            view.setTag(itemHolder);
        }else{
            //se a view já existe pega os itens.
            itemHolder = (ContatoHolder) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        Contato item = items.get(position);
        itemHolder.nome.setText(item.getNome());
        //itemHolder.imgIcon.setImageResource(item.getIconeRid());
        return view;
    }

    private void setupItem(ContatoHolder holder) {
        holder.nome.setText(holder.contato.getNome());
        //holder.telefone.setText(String.valueOf(holder.contato.getTelefone()));
        //holder.endereco.setText(String.valueOf(holder.contato.getTelefone()));
    }

    public static class ContatoHolder {
        Contato contato;
        EditText nome;
        TextView telefone;
        TextView endereco;
        ImageButton btnDeleteContato;
    }

    private void setNameTextChangeListener(final ContatoHolder holder) {
        holder.nome.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                holder.contato.setNome(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void setValueTextListeners(final ContatoHolder holder) {
        holder.telefone.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    holder.contato.setTelefone(s.toString());
                    //Double.parseDouble(s.toString()));
                } catch (NumberFormatException e) {
                    //Log.e(LOG_TAG, "error reading double value: " + s.toString());
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
