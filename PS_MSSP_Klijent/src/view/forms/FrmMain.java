/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.forms;


import java.awt.Panel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.guicontrollers.*;

import view.panels.PanelAllDataSets;
import view.panels.PanelExportDS;
import view.panels.PanelMetaAttribute;
import view.panels.PanelSimilarity;


/**
 *
 * @author Jelena
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
         /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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

        pnlMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mDataSet = new javax.swing.JMenu();
        miShowDataSets = new javax.swing.JMenuItem();
        miExportDS = new javax.swing.JMenuItem();
        mSimilarity = new javax.swing.JMenu();
        miSimilarity = new javax.swing.JMenuItem();
        mMetaAttribute = new javax.swing.JMenu();
        miMetaAttributes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        mDataSet.setText("DataSet");

        miShowDataSets.setText("Show all datasets");
        miShowDataSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miShowDataSetsActionPerformed(evt);
            }
        });
        mDataSet.add(miShowDataSets);

        miExportDS.setText(" Export dataset");
        miExportDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExportDSActionPerformed(evt);
            }
        });
        mDataSet.add(miExportDS);

        jMenuBar1.add(mDataSet);

        mSimilarity.setText("Similarity");

        miSimilarity.setText("Calculate similarity");
        miSimilarity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSimilarityActionPerformed(evt);
            }
        });
        mSimilarity.add(miSimilarity);

        jMenuBar1.add(mSimilarity);

        mMetaAttribute.setText(" MetaAttribute");

        miMetaAttributes.setText("Test Meta attribute");
        miMetaAttributes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMetaAttributesActionPerformed(evt);
            }
        });
        mMetaAttribute.add(miMetaAttributes);

        jMenuBar1.add(mMetaAttribute);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miShowDataSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miShowDataSetsActionPerformed
        try {
            PanelAllDataSets pads= new PanelAllDataSets();
            ControllerUI_AllDataSets allDataSets=new ControllerUI_AllDataSets(pads);
            //allDataSets.setPanelAllDS(pads);
            ControllerUI_Main.getInstance().setActivePanel(pads);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_miShowDataSetsActionPerformed

    private void miExportDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExportDSActionPerformed
        try {
            PanelExportDS panelExport = new PanelExportDS();
            ControllerUI_DSExport dsExport = new ControllerUI_DSExport(panelExport);
            panelExport.setControllerExport(dsExport);
            //dsExport.setPanelExportDS(panelExport);
            ControllerUI_Main.getInstance().setActivePanel(panelExport);
        } catch (IOException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miExportDSActionPerformed

    private void miMetaAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMetaAttributesActionPerformed
        try {
            PanelMetaAttribute pma= new PanelMetaAttribute();
            ControllerUI_MetaAttribute cuima= new ControllerUI_MetaAttribute();
            cuima.setOef(pma);
            ControllerUI_Main.getInstance().setActivePanel(pma);
            cuima.KonvertujDomenskiObjekatUGrafickiObjekat();
        } catch (IOException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_miMetaAttributesActionPerformed

    private void miSimilarityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSimilarityActionPerformed
        try {
            PanelSimilarity pansim = new PanelSimilarity();
            ControllerUI_Similarity contr = new ControllerUI_Similarity();
            pansim.setController(contr);
            contr.setOef(pansim);
            contr.setPanelSimilarity(pansim);
            contr.KonvertujDomenskiObjekatUGrafickiObjekat();
            ControllerUI_Main.getInstance().setActivePanel(pansim);
        } catch (IOException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miSimilarityActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mDataSet;
    private javax.swing.JMenu mMetaAttribute;
    private javax.swing.JMenu mSimilarity;
    private javax.swing.JMenuItem miExportDS;
    private javax.swing.JMenuItem miMetaAttributes;
    private javax.swing.JMenuItem miShowDataSets;
    private javax.swing.JMenuItem miSimilarity;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

private JPanel activePanel;
    
    public void setActivePanel(JPanel newPanel){
        if (activePanel!=null) this.remove(activePanel);

        activePanel = newPanel;
        getContentPane().add(activePanel,java.awt.BorderLayout.SOUTH); 
        activePanel.setVisible(true);
        validate();
        repaint();
        pack();
    }


}
