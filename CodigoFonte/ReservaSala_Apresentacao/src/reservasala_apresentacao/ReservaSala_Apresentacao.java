/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasala_apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Pessoa;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.PessoaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Reserva;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ReservaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.PessoaDAO;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.ReservaDAO;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.SalaDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author petronio
 */
public class ReservaSala_Apresentacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try {
            SalaRepositorio salas = new SalaDAO();
            PessoaRepositorio pessoas = new PessoaDAO();
            ReservaRepositorio reservas = new ReservaDAO();
            /*
            Sala sala1 = salas.Abrir(1);
            Pessoa pessoa1 = pessoas.Abrir(1);
            
            Reserva reserva = new Reserva();
            reserva.setInicio(new Date());
            reserva.setTermino(new Date());
            reserva.setPessoa(pessoa1);
            reserva.setSala(sala1);
            */
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            try {
                Date inicio = df.parse("2017-07-13 13:00:00");
                Date termino = df.parse("2017-07-13 17:00:00");
                
                Reserva filtro = new Reserva();
                filtro.setInicio(inicio);
                filtro.setTermino(termino);
                
                for(Reserva r : reservas.Buscar(filtro))
                    System.out.print(r);
                
            } catch (ParseException ex) {
                Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
