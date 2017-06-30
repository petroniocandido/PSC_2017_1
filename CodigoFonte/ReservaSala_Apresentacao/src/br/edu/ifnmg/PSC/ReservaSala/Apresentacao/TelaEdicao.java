/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Entidade;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Repositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ViolacaoRegraNegocioException;
import javax.swing.JOptionPane;

/**
 *
 * @author petronio
 */
public abstract class TelaEdicao<T extends Entidade> extends javax.swing.JInternalFrame {
    Repositorio<T> repositorio;
    T entidade;
    
    TelaBusca<T> busca;

    public TelaEdicao() {
        
    }
   
    
    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
        
        carregaCampos();
    }

    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }

    public TelaBusca<T> getBusca() {
        return busca;
    }

    public void setBusca(TelaBusca<T> busca) {
        this.busca = busca;
    }
    
    
    
    public abstract void carregaCampos();
    public abstract void carregaObjeto() throws ViolacaoRegraNegocioException;
    public abstract boolean verificarCamposObrigatorios();
    
    public void salvar(){
        if(!verificarCamposObrigatorios()){
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são de preenchimento obrigatório!");
            return;
        }
            
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar o objeto?") == 0 ){

            try {
                carregaObjeto();
                
            } catch (ViolacaoRegraNegocioException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                return; 
            }
            
            if(repositorio.Salvar(entidade)){
                JOptionPane.showMessageDialog(rootPane, "Registro salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao salvar o registro!");
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada!");
        }
    }
    
    public void apagar(){
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente apagar o registro?") == 0 ){
            if(repositorio.Apagar(entidade)){
                JOptionPane.showMessageDialog(rootPane, "Registro removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao remover o registro!");
            }
        }  else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada!");
        }
        
        cancelar();
        
    }
    
    public void cancelar(){
        busca.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    
}
