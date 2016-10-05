package net.tormen.agendadecontatos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import net.tormen.agendadecontatos.adapter.MinhaListViewAdapter;
import net.tormen.agendadecontatos.model.Contato;

import java.util.ArrayList;

/**
 * Created by tormen on 04/10/16.
 */

public class TelaListagemUsuariosListView{
    private MainActivity act;
    private TelaPrincipal tela_principal;
    private MinhaListViewAdapter adapter;

    protected void onCreate(MainActivity act, TelaPrincipal
            tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;

        setupListViewAdapter();

        setupAddPaymentButton();
    }

    public void CarregarTela() {
        act.setContentView(R.layout.cadastro_de_usuario);
    }


    public void removeAtomPayOnClickHandler(View v) {
        Contato itemToRemove = (Contato)v.getTag();
        adapter.remove(itemToRemove);
    }

    private void setupListViewAdapter() {
        adapter = new MinhaListViewAdapter(act, R.layout.listagem_usuarios_listview,
                new ArrayList<Contato>());
        ListView atomPaysListView = (ListView)act.findViewById(R.id.EnterPays_atomPaysList);
        atomPaysListView.setAdapter(adapter);
    }

    private void setupAddPaymentButton() {
        act.findViewById(R.id.EnterPays_addAtomPayment).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.insert(new Contato("", "",""), 0);
            }
        });
    }
}
