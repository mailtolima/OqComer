package br.ufc.virtual.smd.oqcomer.vo;

import java.io.Serializable;

/**
 * Created by leoomoreira on 14/06/2015.
 */
public class Usuario implements Serializable {

    private int id;
    private String email;
    private String nome;
    private String usuario;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
