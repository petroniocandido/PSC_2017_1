/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Aplicacao;

import java.util.Objects;

/**
 *
 * @author petronio
 */
public class Pessoa implements Entidade {
    
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ViolacaoRegraNegocioException {
        if(nome.length() < 4)
            throw new ViolacaoRegraNegocioException("O nome deve ser maior do que 4 caracteres!");
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws ViolacaoRegraNegocioException {
        if(login.length() < 4)
            throw new ViolacaoRegraNegocioException("O login deve ser maior do que 4 caracteres!");
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws ViolacaoRegraNegocioException {
        if(senha.length() < 5)
            throw new ViolacaoRegraNegocioException("O senha deve ser maior do que 5 caracteres!");
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }
    
}
