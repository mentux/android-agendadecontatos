package net.tormen.agendadecontatos;

import android.view.View;
import android.widget.Button;


public class TelaPrincipal {

    MainActivity act;
    Button btCadastrarUsuario;
    Button btListarUsuariosCadastrados;
    Button btListarUsuariosCadastradosListView;
    TelaCadastroUsuario telaCadastro;
    TelaListagemUsuarios telaListagem;
    TelaListagemUsuariosListView telaListagemListView;

    public TelaPrincipal(MainActivity act) {
        this.act = act;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.tela_principal);
        btCadastrarUsuario = (Button)
                act.findViewById(R.id.btcadastrar_usuario);
        btListarUsuariosCadastrados = (Button)
                act.findViewById(R.id.bt_listar_usuarios_cadastrados);

        btListarUsuariosCadastradosListView = (Button)
                act.findViewById(R.id.bt_listar_usuarios_cadastrados_list_view);
        btCadastrarUsuario.setOnClickListener(new
                                                       View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                               telaCadastro.CarregarTela();
                                                           }
                                                       });
        btListarUsuariosCadastrados.setOnClickListener(new
                                                                  View.OnClickListener() {
                                                                      @Override
                                                                      public void onClick(View view) {
                                                                          telaListagem.CarregarTela();
                                                                      }
                                                                  });
        btListarUsuariosCadastradosListView.setOnClickListener(new
                                                               View.OnClickListener() {
                                                                   @Override
                                                                   public void onClick(View view) {
                                                                       telaListagemListView.CarregarTela();
                                                                   }
                                                               });
    }

    public void setTelaCadastro(TelaCadastroUsuario tela_cadastro) {
        this.telaCadastro = tela_cadastro;
    }

    public void setTelaListagem(TelaListagemUsuarios tela_listagem) {
        this.telaListagem = tela_listagem;
    }

    public void setTelaListagemListView(TelaListagemUsuariosListView tela_listview) {
        this.telaListagemListView = tela_listview;
    }
}
