package net.tormen.agendadecontatos.model;

import java.io.Serializable;

/**
 * Created by tormen on 04/10/16.
 */

public class Contato implements Serializable {

    private String nome;
    private String endereco;
    private String telefone;

    public Contato() {

    }

    public Contato(String nome, String endereco, String telefone) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
