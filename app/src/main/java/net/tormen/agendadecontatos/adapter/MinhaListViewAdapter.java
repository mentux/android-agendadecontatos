package net.tormen.agendadecontatos.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import net.tormen.agendadecontatos.R;
import net.tormen.agendadecontatos.model.Contato;

import java.util.List;

/**
 * Created by tormen on 04/10/16.
 */

public class MinhaListViewAdapter extends ArrayAdapter<Contato> {
    private List<Contato> items;
    private int layoutResourceId;
    private Context context;

    public MinhaListViewAdapter(Context context, int layoutResourceId, List<Contato> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContatoHolder holder = null;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new ContatoHolder();
        holder.contato = items.get(position);
        holder.btnDeleteContato = (ImageButton)row.findViewById(R.id.listViewRemove);
        holder.btnDeleteContato.setTag(holder.contato);

        //holder.nome = (EditText)row.findViewById(R.id.edtNome);
        //holder.telefone = (TextView)row.findViewById(R.id.atomPay_value);
        //holder.endereco = (TextView)row.findViewById(R.id.atomPay_value);

        row.setTag(holder);

        setupItem(holder);
        return row;
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setValueTextListeners(final ContatoHolder holder) {
        holder.telefone.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    holder.contato.setTelefone(s.toString());
                            //Double.parseDouble(s.toString()));
                }catch (NumberFormatException e) {
                    //Log.e(LOG_TAG, "error reading double value: " + s.toString());
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}
