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
import java.sql.SQLException;
import java.util.List;

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
    
    protected abstract void setParametros(PreparedStatement sql, T obj);
    
    
    @Override
    public boolean Salvar(T obj) {
        try {
            // Objeto não está salvo no BD
            if(obj.getId() == 0){
                // Criar a consulta SQL de inserção
                PreparedStatement sql = conexao.prepareStatement(getConsultaInsert());
                
                setParametros(sql, obj);
                
                if (sql.executeUpdate() > 0) return true;
                else return false;
                
            } else {

            }
        } catch(Exception ex) {
             return false;
        }
        return false;
    }

    @Override
    public boolean Apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Abrir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> Buscar(T filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
