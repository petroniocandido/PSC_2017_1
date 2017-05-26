/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Persistencia;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    protected String getConsultaUpdate() {
        return "update salas set nome = ?, tipo = ?, capacidade = ? where id = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from salas where id = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select id, nome, tipo, capacidade from salas where id = ?";
    }
    

    @Override
    protected void setParametros(PreparedStatement sql, Sala obj) {
        try {
            
            sql.setString(1, obj.getNome());
            sql.setInt(2, obj.getTipo().getId());
            sql.setInt(3, obj.getCapacidade());
            
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Sala setDados(ResultSet resultado) {
        try {
            Sala obj = new Sala();
            obj.setId( resultado.getInt("id") );
            obj.setNome( resultado.getString("nome") );
            obj.setTipo(Tipo.Abrir( resultado.getInt("tipo") ));
            obj.setCapacidade( resultado.getInt("capacidade") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    protected String getConsultaBuscar() {
        return "select id, nome, tipo, capacidade from salas ";
    }

    @Override
    protected void setBuscaFiltros(Sala filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
        
        if(filtro.getCapacidade() > 4)
            this.adicionarFiltro("capacidade", filtro.getCapacidade());
        
        if(filtro.getTipo() != null)
            this.adicionarFiltro("tipo", filtro.getTipo().getId());
    }

    
}
