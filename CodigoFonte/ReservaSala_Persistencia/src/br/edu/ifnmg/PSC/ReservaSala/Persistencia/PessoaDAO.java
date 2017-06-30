/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Persistencia;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Pessoa;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.PessoaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class PessoaDAO extends DAOGenerico<Pessoa> implements PessoaRepositorio {

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    
    
    @Override
    protected String getConsultaInsert() {
        return "insert into pessoas(nome, login, senha) values(?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pessoas set nome = ?, login = ?, senha = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from pessoas where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id, nome, login, senha from pessoas where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select id, nome, login, senha from pessoas ";
    }

    @Override
    protected void setBuscaFiltros(Pessoa filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
        
        if(filtro.getLogin() != null && !filtro.getLogin().isEmpty())
            this.adicionarFiltro("login", filtro.getLogin());
        
        if(filtro.getSenha() != null && !filtro.getSenha().isEmpty())
            this.adicionarFiltro("senha", filtro.getSenha());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Pessoa obj) {
        try {
            
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getLogin());
            sql.setString(3, obj.getSenha());
            
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Pessoa setDados(ResultSet resultado) {
        try {
            Pessoa obj = new Pessoa();
            obj.setId( resultado.getInt("id") );
            obj.setNome( resultado.getString("nome") );
            obj.setLogin( resultado.getString("login") );
            obj.setSenha( resultado.getString("senha") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
