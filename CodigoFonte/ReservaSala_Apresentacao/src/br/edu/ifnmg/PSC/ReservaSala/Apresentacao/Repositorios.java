/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.PessoaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.PessoaDAO;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.SalaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class Repositorios {
    
    static SalaRepositorio salaDAO = null;
    
    public static SalaRepositorio getSalaRepositorio(){
        if(salaDAO == null)
            try {
                salaDAO = new SalaDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return salaDAO;
    }
    
    static PessoaRepositorio pessoaDAO = null;
    
    public static PessoaRepositorio getPessoaRepositorio(){
        if(pessoaDAO == null)
            try {
                pessoaDAO = new PessoaDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return pessoaDAO;
    }
    
}
