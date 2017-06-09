/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.ReservaSala.Apresentacao;

import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Entidade;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Sala;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.SalaRepositorio;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.Tipo;
import br.edu.ifnmg.PSC.ReservaSala.Aplicacao.ViolacaoRegraNegocioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author petronio
 */
public class SalaEditar extends javax.swing.JInternalFrame {

    SalaRepositorio repositorio;
    
    Sala entidade;

    public Sala getEntidade() {
        return entidade;
    }

    public void setEntidade(Sala entidade) {
        this.entidade = entidade;
        
        txtNome.setText( entidade.getNome() );
        cbxTipo.setSelectedItem( entidade.getTipo() );
        spnCapacidade.setValue( entidade.getCapacidade() );
    }
    
    
    
    /**
     * Creates new form SalaEditar
     */
    public SalaEditar() {
        initComponents();
        
        repositorio = Repositorios.getSalaRepositorio();
        
        entidade = new Sala();
        
        ComboBoxModel model = new DefaultComboBoxModel(Tipo.values());
        cbxTipo.setModel(model);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        spnCapacidade = new javax.swing.JSpinner();

        setClosable(true);
        setTitle("Editar Sala");
        setToolTipText("");

        lblNome.setText("Nome:");

        lblTipo.setText("Tipo:");

        jLabel1.setText("Capac.:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        spnCapacidade.setModel(new javax.swing.SpinnerNumberModel(5, 5, null, 1));
        spnCapacidade.setEditor(new javax.swing.JSpinner.NumberEditor(spnCapacidade, ""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblTipo)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spnCapacidade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addComponent(btnCancelar)
                        .addGap(64, 64, 64)
                        .addComponent(btnApagar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spnCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnApagar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(txtNome.getText().isEmpty() || cbxTipo.getSelectedItem() == null 
                || spnCapacidade.getValue() == null){
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são de preenchimento obrigatório!");
            return;
        }
            
        
        
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar o objeto?") == 0 ){

            try {

                entidade.setNome( txtNome.getText() );
                entidade.setCapacidade( Integer.parseInt(spnCapacidade.getValue().toString()) );
                entidade.setTipo( (Tipo) cbxTipo.getSelectedItem() );

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
        
        
            
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente apagar o registro?") == 0 ){
            if(repositorio.Apagar(entidade)){
                JOptionPane.showMessageDialog(rootPane, "Registro removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao remover o registro!");
            }
        }  else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada!");
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JSpinner spnCapacidade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
