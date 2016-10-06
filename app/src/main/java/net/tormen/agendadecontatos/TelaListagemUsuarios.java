package net.tormen.agendadecontatos;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal telaPrincipal;
    Button btnAnterior, btnProximo, btnFechar;
    TextView txtNome, txtTelefone, txtEndereco, txtStatus;
    int index;

    public TelaListagemUsuarios(MainActivity act, TelaPrincipal
            telaPrincipal) {
        this.act = act;
        this.telaPrincipal = telaPrincipal;
        index = 0;
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
        act.setContentView(R.layout.listagem_usuarios_cadastrados);
        btnAnterior = (Button) act.findViewById(R.id.btanterior);
        btnProximo = (Button) act.findViewById(R.id.btproximo);
        btnFechar = (Button) act.findViewById(R.id.btfechar);
        txtNome = (TextView) act.findViewById(R.id.txtnome);
        txtEndereco = (TextView) act.findViewById(R.id.txtendereco);
        txtTelefone = (TextView) act.findViewById(R.id.txttelefone);
        txtStatus = (TextView) act.findViewById(R.id.txtstatus);
        PreencheCampos(index);
        AtualizaStatus(index);
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getContatos().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaPrincipal.CarregarTela();
            }
        });
    }

    private void PreencheCampos(int idx) {
        txtNome.setText(act.getContatos().get(idx).getNome());
        txtTelefone.setText(act.getContatos().get(idx).getTelefone());
        txtEndereco.setText(act.getContatos().get(idx).getEndereco());
    }

    private void AtualizaStatus(int idx) {
        int total = act.getContatos().size();
        txtStatus.setText("Registros: " + (idx + 1) + "/" + total);
    }
}
