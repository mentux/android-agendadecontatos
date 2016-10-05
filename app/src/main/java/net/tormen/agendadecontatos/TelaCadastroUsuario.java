package net.tormen.agendadecontatos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.tormen.agendadecontatos.model.Contato;

public class TelaCadastroUsuario {

    MainActivity act;
    EditText edtNome, edtEndereco, edtTelefone;
    Button btnCadastrar, btnCancelarCadastro;
    TelaPrincipal telaPrincipal;

    public TelaCadastroUsuario(MainActivity act, TelaPrincipal
            telaPrincipal) {
        this.act = act;
        this.telaPrincipal = telaPrincipal;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.cadastro_de_usuario);
        edtNome = (EditText) act.findViewById(R.id.ednome);
        edtTelefone = (EditText) act.findViewById(R.id.edtelefone);
        edtEndereco = (EditText) act.findViewById(R.id.edendereco);
        btnCadastrar = (Button) act.findViewById(R.id.btcadastrar);
        btnCancelarCadastro = (Button)
                act.findViewById(R.id.btcancelar_cadastro);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                String nome =
                                        edtNome.getText().toString();
                                String telefone =
                                        edtTelefone.getText().toString();
                                String endereco =
                                        edtEndereco.getText().toString();
                                act.getContatos().add(new
                                        Contato(nome, telefone, endereco));
                                act.ExibirMensagem("Cadastro efetuado com sucesso.");
                                telaPrincipal.CarregarTela();
                            }
                        });
                dialogo.show();
            }
        });
        btnCancelarCadastro.setOnClickListener(new
                                                       View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                               AlertDialog.Builder dialogo = new
                                                                       AlertDialog.Builder(act);
                                                               dialogo.setTitle("Aviso");
                                                               dialogo.setMessage("Sair do cadastro?");
                                                               dialogo.setNegativeButton("Não", null);
                                                               dialogo.setPositiveButton("Sim", new
                                                                       DialogInterface.OnClickListener() {
                                                                           @Override
                                                                           public void onClick(DialogInterface dialog,
                                                                                               int which) {
                                                                               telaPrincipal.CarregarTela();
                                                                           }
                                                                       });
                                                               dialogo.show();
                                                           }
                                                       });
    }
}
