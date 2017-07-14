/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Persistencia;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Reserva;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ReservaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class ReservaDAO extends DAOGenerico<Reserva> implements ReservaRepositorio {

    public ReservaDAO() throws ClassNotFoundException, SQLException {
        super();
        pessoas = new PessoaDAO();
        salas = new SalaDAO();
    }

    
    
    
    @Override
    protected String getConsultaInsert() {
        return "insert into reservas(inicio, termino, pessoa, sala) values(?,?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update reservas set inicio = ?, termino = ?, pessoa = ?, sala = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from reservas where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id, inicio, termino, pessoa, sala from reservas where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select id, inicio, termino, pessoa, sala from reservas ";
    }

    @Override
    protected void setBuscaFiltros(Reserva filtro) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        this.where = " not (inicio < '" + df.format(filtro.getInicio()) +"' and termino < '"+ df.format(filtro.getInicio())
                + "') and not ( inicio > '" + df.format(filtro.getTermino()) + "' and termino > '" + df.format(filtro.getTermino())
                + "') ";
        
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getPessoa() != null)
            this.adicionarFiltro("pessoa", filtro.getPessoa().getId());
        
        if(filtro.getSala() != null)
            this.adicionarFiltro("sala", filtro.getSala().getId());
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Reserva obj) {
        try {
            
            sql.setDate(1, new java.sql.Date( obj.getInicio().getTime() ));
            sql.setDate(2, new java.sql.Date( obj.getTermino().getTime()));
            sql.setInt(3, obj.getPessoa().getId());
            sql.setInt(4, obj.getSala().getId());
            
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    PessoaDAO pessoas;
    SalaDAO salas;

    @Override
    protected Reserva setDados(ResultSet resultado) {
        try {
            Reserva obj = new Reserva();
            obj.setId( resultado.getInt("id") );
            obj.setInicio( new Date( resultado.getDate("inicio").getTime() ) );
            obj.setTermino( new Date( resultado.getDate("termino").getTime() ) );
            obj.setPessoa( pessoas.Abrir( resultado.getInt("pessoa") ) );
            obj.setSala( salas.Abrir( resultado.getInt("sala") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
