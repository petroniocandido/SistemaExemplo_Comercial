/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Apresentacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.RepositorioFactory;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.UsuarioRepositorio;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author petronio
 */
public class UsuarioBuscar extends javax.swing.JInternalFrame {
    
    UsuarioRepositorio repositorio;
    Usuario usuario;

    /**
     * Creates new form UsuarioBuscar
     */
    public UsuarioBuscar() {
        
        repositorio = RepositorioFactory.getUsuarioRepositorio();
        
        usuario = new Usuario();
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar Usuários");

        txtLogin.setToolTipText("Coloque aqui o nome do usuário que deseja buscar");

        jLabel1.setText("Login:");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Clica para efetuar uma busca");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo Usuário");
        btnNovo.setToolTipText("Clique para adicionar um novo usuário");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Clique para limpar os filtros de busca");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.getTableHeader().setReorderingAllowed(false);
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultado);
        if (tblResultado.getColumnModel().getColumnCount() > 0) {
            tblResultado.getColumnModel().getColumn(0).setResizable(false);
            tblResultado.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnBuscar)
                        .addGap(56, 56, 56)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        // Peguei os dados do componente e coloquei no objeto filtro (usuario)
        usuario.setLogin( txtLogin.getText() );
        
        // Fiz a busca no repositório passando o filtro
        List<Usuario> resultado = repositorio.Buscar(usuario);
        
        // Criei o modelo de dados para a jTable
        DefaultTableModel modelo = new DefaultTableModel();

        // Adicionei às colunas do modelo/tabela
        modelo.addColumn("ID");
        modelo.addColumn("Login");
        
        // Adiciona as linhas do modelo/tabela
        for(Usuario u : resultado){
            Vector linha = new Vector();
            linha.add(u.getId());
            linha.add(u.getLogin());
            
            modelo.addRow(linha);
        }
        
        // Passa o modelo para o jTable
        tblResultado.setModel(modelo);
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente limpar a busca?", "Confirmação", JOptionPane.YES_NO_OPTION) 
                == JOptionPane.YES_OPTION) {

            txtLogin.setText("");

            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("ID");
            modelo.addColumn("Login");

            tblResultado.setModel(modelo);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        UsuarioEditar tela = new UsuarioEditar((new Usuario()));
        this.getParent().add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        int linha = tblResultado.getSelectedRow();
        
        Long id = Long.parseLong(tblResultado.getValueAt(linha, 0).toString() );
        
        Usuario u = repositorio.Abrir(id);
        
        UsuarioEditar tela = new UsuarioEditar(u);
        this.getParent().add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_tblResultadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
