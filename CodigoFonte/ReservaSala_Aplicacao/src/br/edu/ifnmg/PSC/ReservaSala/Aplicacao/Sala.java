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
public class Sala {
    private int id;
    private String nome;
    private Tipo tipo;
    private int capacidade;

    public Sala() {
    }

    public Sala(int id, String nome, Tipo tipo, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ViolacaoRegraNegocioException {
        if(nome == null || nome.length() < 4)
            throw new ViolacaoRegraNegocioException("O nome da sala deve ter mais do que 3 caracteres!");
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) throws ViolacaoRegraNegocioException {
        if(capacidade < 5 )
            throw new ViolacaoRegraNegocioException("A capacidade mínima de uma sala deve ser igual a 5!");
        this.capacidade = capacidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.tipo);
        hash = 13 * hash + this.capacidade;
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
        final Sala other = (Sala) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipo.getDescricao() + " " + nome ;
    }
    
    
    
    
}
