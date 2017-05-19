/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservasala_apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ViolacaoRegraNegocioException;

/**
 *
 * @author petronio
 */
public class ReservaSala_Apresentacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sala s = new Sala();
        
        try {
        
            s.setNome("1234");
            
            s.setCapacidade(5);
            
        } catch(ViolacaoRegraNegocioException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
