/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Aplicacao;

/**
 *
 * @author petronio
 */
public class Aplicacao {
    
    private static Pessoa usuario;

    public static Pessoa getUsuario() {
        return usuario;
    }

    public static void setUsuario(Pessoa usuario) {
        Aplicacao.usuario = usuario;
    }
    
    
    public static boolean isLogged() {
        return usuario != null;
    }
    
}
