/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels;

import javax.swing.JList;
import javax.swing.table.TableModel;
import model.OpstiDomenskiObjekat;
import model.dataset.Dsmetaattribute;
import view.forms.OpstaEkranskaForma;

/**
 *
 * @author Jelena
 */
public class PanelMetaAttribute extends javax.swing.JPanel implements OpstaEkranskaForma{

    /**
     * Creates new form PanelMetaAttribute
     */
    public PanelMetaAttribute() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listDsmetaattributes = new javax.swing.JList();

        listDsmetaattributes.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jScrollPane1.setViewportView(listDsmetaattributes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listDsmetaattributes;
    // End of variables declaration//GEN-END:variables

    @Override
    public TableModel vratiModel() {
        return null;
    }

    @Override
    public Object[] vratiPocetneVrednosti() {
       return null;
    }

    @Override
    public int vratiSelektovaniRed() {
        return -1;
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return new Dsmetaattribute();
    }

    public JList getListDsmetaattributes() {
        return listDsmetaattributes;
    }
    
    
}