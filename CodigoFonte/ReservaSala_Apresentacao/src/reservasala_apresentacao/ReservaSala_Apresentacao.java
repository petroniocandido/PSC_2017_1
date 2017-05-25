/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasala_apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Tipo;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ViolacaoRegraNegocioException;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.DAOGenerico;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.SalaDAO;
import java.sql.SQLException;
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
            SalaRepositorio dao = new SalaDAO();
            
            Sala s = dao.Abrir(1);
            
            System.out.println(s.getNome());
            
            s.setNome("Paraná do biteco");
            
            dao.Salvar(s);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
