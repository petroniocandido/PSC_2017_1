/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasala_apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ViolacaoRegraNegocioException;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.DAOGenerico;
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
    public static void main(String[] args) {
       
        try {
            DAOGenerico<Sala> teste = new DAOGenerico<>();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
