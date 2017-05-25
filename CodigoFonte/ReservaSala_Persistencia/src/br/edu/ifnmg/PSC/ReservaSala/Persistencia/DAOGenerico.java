/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Persistencia;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Entidade;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Repositorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public abstract class DAOGenerico<T extends Entidade> implements Repositorio<T> {
    
    private Connection conexao;

    public DAOGenerico() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReservaSalas","root","root");
    }

    protected abstract String getConsultaInsert();
    protected abstract String getConsultaUpdate();
    protected abstract String getConsultaAbrir();
    
    protected abstract void setParametros(PreparedStatement sql, T obj);
    protected abstract T setDados(ResultSet resultado);
    
    
    @Override
    public boolean Salvar(T obj) {
        try {
            PreparedStatement sql = null;
            
            // Objeto não está salvo no BD ---> INSERT
            if(obj.getId() == 0){
                // Criar a consulta SQL de inserção
                sql = conexao.prepareStatement(getConsultaInsert());
            
            // Objeto já está salvo no BD ---> UPDATE
            } else {
                // Criar a consulta SQL de inserção
                sql = conexao.prepareStatement(getConsultaUpdate());
            }    
            
            setParametros(sql, obj);

            if (sql.executeUpdate() > 0) 
                return true;
            else 
                return false;
            
        } catch(Exception ex) {
             return false;
        }
    }

    @Override
    public boolean Apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Abrir(int id) {
        try {
            PreparedStatement sql = conexao.prepareStatement(this.getConsultaAbrir());
            
            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();
            
            if(resultado.next())
                return this.setDados(resultado);
            else 
                return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<T> Buscar(T filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
