/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Persistencia;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class SalaDAO extends DAOGenerico<Sala> implements SalaRepositorio {

    public SalaDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    
    
    @Override
    protected String getConsultaInsert() {
        return "insert into salas(nome, tipo, capacidade) values(?,?,?)";
    }

    @Override
    protected void setParametros(PreparedStatement sql, Sala obj) {
        try {
            
            sql.setString(1, obj.getNome());
            sql.setInt(2, obj.getTipo().getId());
            sql.setInt(3, obj.getCapacidade());
            
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
