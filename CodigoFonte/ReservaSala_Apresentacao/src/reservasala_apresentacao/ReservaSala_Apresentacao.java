/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasala_apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Persistencia.SalaDAO;
import java.sql.SQLException;
import java.util.List;
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
            
            /*
            for(int i = 4; i < 16; i++){
                Sala s = new Sala(0, "Sala nº " + Integer.toString(i), Tipo.AULA, i + 4);
                dao.Salvar(s);
            }*/
            
            List<Sala> resultado = dao.Buscar(new Sala(0,null,null,12));
            
            for(Sala s : resultado)
                System.out.println(s);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReservaSala_Apresentacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
