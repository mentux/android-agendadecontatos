package net.tormen.agendadecontatos;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.tormen.agendadecontatos.model.Contato;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contato> contatos;
    TelaPrincipal telaPrincipal;
    TelaCadastroUsuario telaCadastro;
    TelaListagemUsuarios telaListagem;
    TelaListagemUsuariosListView telaListagemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        contatos = new ArrayList<Contato>();
        telaPrincipal = new TelaPrincipal(this);
        telaCadastro = new TelaCadastroUsuario(this, telaPrincipal);
        telaListagem = new TelaListagemUsuarios(this, telaPrincipal);
        telaPrincipal.setTelaCadastro(telaCadastro);
        telaPrincipal.setTelaListagem(telaListagem);
        telaPrincipal.setTelaListagemListView(telaListagemListView);
        telaPrincipal.CarregarTela();
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void ExibirMensagem(String msg) {
        AlertDialog.Builder dialogBuilder = new
                AlertDialog.Builder(MainActivity.this);
        dialogBuilder.setTitle("Aviso");
        dialogBuilder.setMessage(msg);
        dialogBuilder.setNeutralButton("OK", null);
        dialogBuilder.show();
    }
}
