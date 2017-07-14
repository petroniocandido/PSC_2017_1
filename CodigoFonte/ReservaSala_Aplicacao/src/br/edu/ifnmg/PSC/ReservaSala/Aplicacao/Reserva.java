/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author petronio
 */
public class Reserva implements Entidade {

    private int id;
    private Date inicio;
    private Date termino;
    private Pessoa pessoa;
    private Sala sala;

    public Reserva() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.inicio);
        hash = 97 * hash + Objects.hashCode(this.termino);
        hash = 97 * hash + Objects.hashCode(this.pessoa);
        hash = 97 * hash + Objects.hashCode(this.sala);
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
        final Reserva other = (Reserva) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.termino, other.termino)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        return true;
    }
    
    
    
}
