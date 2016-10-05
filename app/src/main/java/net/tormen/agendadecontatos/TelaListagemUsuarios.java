package net.tormen.agendadecontatos;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal telaPrincipal;
    Button btanterior, btproximo, btfechar;
    TextView txtnome, txttelefone, txtendereco, txtstatus;
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
        btanterior = (Button) act.findViewById(R.id.btanterior);
        btproximo = (Button) act.findViewById(R.id.btproximo);
        btfechar = (Button) act.findViewById(R.id.btfechar);
        txtnome = (TextView) act.findViewById(R.id.txtnome);
        txtendereco = (TextView) act.findViewById(R.id.txtendereco);
        txttelefone = (TextView) act.findViewById(R.id.txttelefone);
        txtstatus = (TextView) act.findViewById(R.id.txtstatus);
        PreencheCampos(index);
        AtualizaStatus(index);
        btanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getContatos().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaPrincipal.CarregarTela();
            }
        });
    }

    private void PreencheCampos(int idx) {
        txtnome.setText(act.getContatos().get(idx).getNome());
        txttelefone.setText(act.getContatos().get(idx).getTelefone());
        txtendereco.setText(act.getContatos().get(idx).getEndereco());
    }

    private void AtualizaStatus(int idx) {
        int total = act.getContatos().size();
        txtstatus.setText("Registros : " + (idx + 1) + "/" + total);
    }
}
