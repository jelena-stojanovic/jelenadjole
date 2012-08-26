/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel;

import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Administrator;
import model.OpstiDomenskiObjekat;
import view.controllers.ControllerUI_Administrator;
import view.forms.FrmAdministrator;
import view.forms.OpstaEkranskaForma;
import view.panels.importDSpanel.model.TableModelAdministrator;

/**
 *
 * @author Jelena
 */
public class PanelAllAdmins extends javax.swing.JPanel implements OpstaEkranskaForma{

    /**
     * Creates new form PanelAllAdmins
     */
    public PanelAllAdmins() {
        initComponents();
        tblAllAdmins.setComponentPopupMenu(postaviPopupmenu());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllAdmins = new javax.swing.JTable();
        btnAddNewAdmin = new javax.swing.JButton();

        tblAllAdmins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAllAdmins);

        btnAddNewAdmin.setText("Add new administrator");
        btnAddNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 342, Short.MAX_VALUE)
                .addComponent(btnAddNewAdmin))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddNewAdmin)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewAdminActionPerformed
                FrmAdministrator frmAdministrator= new FrmAdministrator();
                frmAdministrator.setCtrlAdmin(controllerUI_Administrator);
                controllerUI_Administrator.setOdo(new Administrator());
                controllerUI_Administrator.setOef(frmAdministrator);
                frmAdministrator.getBtnRegisterAdmin().setVisible(true);
                frmAdministrator.getBtnUpdateAdmin().setVisible(false);
                frmAdministrator.setVisible(true);
    }//GEN-LAST:event_btnAddNewAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewAdmin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAllAdmins;
    // End of variables declaration//GEN-END:variables

    @Override
    public TableModel vratiModel() {
        return tblAllAdmins.getModel();
    }

    @Override
    public Object[] vratiPocetneVrednosti() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vratiSelektovaniRed() {
        return tblAllAdmins.getSelectedRow();
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public JTable getTblAllAdmins() {
        return tblAllAdmins;
    }
     private JPopupMenu postaviPopupmenu() {
        JPopupMenu jpm = new JPopupMenu("Administrator");
        JMenuItem jmiDetalji = new JMenuItem();
        jmiDetalji.setText("View details about administrator");
        jmiDetalji.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDetaljiActionPerformed(evt);
            }

            private void jmiDetaljiActionPerformed(ActionEvent evt) {
                int red = tblAllAdmins.getSelectedRow();
                Administrator administrator=((TableModelAdministrator)vratiModel()).getAdmin(red);
                FrmAdministrator frmAdministrator= new FrmAdministrator();
                frmAdministrator.setCtrlAdmin(controllerUI_Administrator);
                controllerUI_Administrator.setOdo(administrator);
                controllerUI_Administrator.setOef(frmAdministrator);
                frmAdministrator.getBtnRegisterAdmin().setVisible(false);
                frmAdministrator.getBtnUpdateAdmin().setVisible(false);
                frmAdministrator.setVisible(true);
            }
        });
        jpm.add(jmiDetalji);
        
        
        JMenuItem jmiIzmeni = new JMenuItem();
        jmiIzmeni.setText("Edit administrator");
        jmiIzmeni.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIzmeniActionPerformed(evt);
            }

            private void jmiIzmeniActionPerformed(ActionEvent evt) {
                int red = tblAllAdmins.getSelectedRow();
                Administrator administrator=((TableModelAdministrator)vratiModel()).getAdmin(red);
                FrmAdministrator frmAdministrator= new FrmAdministrator();
                frmAdministrator.setCtrlAdmin(controllerUI_Administrator);
                controllerUI_Administrator.setOdo(administrator);
                controllerUI_Administrator.setOef(frmAdministrator);
                frmAdministrator.getBtnRegisterAdmin().setVisible(false);
                frmAdministrator.getBtnUpdateAdmin().setVisible(true);
                frmAdministrator.setVisible(true);
            }
        });
        jpm.add(jmiIzmeni);
        
//        JMenuItem jmiSacuvaj = new JMenuItem();
//        jmiSacuvaj.setText("Save administratora");
//        jmiSacuvaj.addActionListener(new java.awt.event.ActionListener() {
//
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jmiSacuvajActionPerformed(evt);
//            }
//
//            private void jmiSacuvajActionPerformed(ActionEvent evt) {
//                throw new UnsupportedOperationException("Not yet implemented");
//            }
//        });
//        jpm.add(jmiSacuvaj);
//        
        return jpm;
}

     
     ControllerUI_Administrator controllerUI_Administrator;

    public void setControllerUI_Administrator(ControllerUI_Administrator controllerUI_Administrator) {
        this.controllerUI_Administrator = controllerUI_Administrator;
    }
}
