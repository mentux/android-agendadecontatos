package net.tormen.agendadecontatos;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

    public TelaListagemUsuariosListView(MainActivity act, TelaPrincipal
            tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
    }

    public void CarregarTela() {
        //Antes de carregar a tela, verifica se existe registros inseridos
        if (act.getContatos().size() == 0) {
            (new AlertDialog.Builder(act))
                    .setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado.")
                    .setNeutralButton("OK", null)
                    .show();
            return;
        }
        act.setContentView(R.layout.listagem_usuarios_listview);
        setupListViewAdapter();
        setupAddPaymentButton();
    }


    /*public void removeAtomPayOnClickHandler(View v) {
        Contato itemToRemove = (Contato)v.getTag();
        adapter.remove(itemToRemove);
    }*/

    private void setupListViewAdapter() {
        adapter = new MinhaListViewAdapter(act, R.layout.listagem_usuarios_listview,
                act.getContatos());
        ListView atomPaysListView = (ListView)act.findViewById(R.id.lstViewListagemContatos);
        atomPaysListView.setAdapter(adapter);
    }

    private void setupAddPaymentButton() {
        /*act.findViewById(R.id.EnterPays_addAtomPayment).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.insert(new Contato("", "",""), 0);
            }
        });*/
    }
}
