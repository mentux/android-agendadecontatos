package net.tormen.agendadecontatos;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.tormen.agendadecontatos.model.Contato;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contato> contatos;
    TelaPrincipal tela_principal;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuarios tela_listagem;
    TelaListagemUsuariosListView tela_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        contatos = new ArrayList<Contato>();
        tela_principal = new TelaPrincipal(this);
        tela_cadastro = new TelaCadastroUsuario(this, tela_principal);
        tela_listagem = new TelaListagemUsuarios(this, tela_principal);
        tela_principal.setTelaCadastro(tela_cadastro);
        tela_principal.setTelaListagem(tela_listagem);
        tela_principal.setTelaListagemListView(tela_listview);
        tela_principal.CarregarTela();
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void ExibirMensagem(String msg) {
        AlertDialog.Builder d = new
                AlertDialog.Builder(MainActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK", null);
        d.show();
    }
}
