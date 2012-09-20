/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import model.OpstiDomenskiObjekat;
import view.forms.OpstaEkranskaForma;
import view.guicontrollers.ControllerUI_DataSet;

/**
 *
 * @author Jelena
 */
public class FrmDataSet extends javax.swing.JDialog  implements OpstaEkranskaForma {

    
    
    

    ControllerUI_DataSet controllerDataSet; 
    
    /**
     * CreaJFrametes new form PanelDataSet
     */
    public FrmDataSet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFieldDataSetTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        tfCreator = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfDonor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfDateDS = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        listReferences = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DataSet");
        setBackground(new java.awt.Color(204, 204, 255));
        setBounds(new java.awt.Rectangle(100, 100, 700, 510));
        setFont(new java.awt.Font("Agency FB", 2, 10)); // NOI18N
        getContentPane().setLayout(null);

        jLabel2.setText("DataSet Title: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 14, 100, 14);

        jLabel3.setText("DataSet Description: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 60, 102, 14);
        getContentPane().add(txtFieldDataSetTitle);
        txtFieldDataSetTitle.setBounds(115, 11, 540, 30);

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescription);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 60, 539, 80);

        jLabel11.setText("Creator:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 154, 100, 20);
        getContentPane().add(tfCreator);
        tfCreator.setBounds(120, 150, 540, 30);

        jLabel12.setText("Donor:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 200, 100, 14);
        getContentPane().add(tfDonor);
        tfDonor.setBounds(120, 190, 540, 30);

        jLabel13.setText("Date (please insert date in format MM/dd/yyyy):");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 230, 346, 14);

        tfDateDS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDateDSFocusLost(evt);
            }
        });
        getContentPane().add(tfDateDS);
        tfDateDS.setBounds(380, 230, 281, 30);

        jScrollPane5.setViewportView(listReferences);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(5, 286, 650, 166);

        jLabel16.setText("References:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 260, 210, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void tfDateDSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDateDSFocusLost
        try {
            String dateS=getTfDateDS().getText().trim();
            Date date=null;
            if(dateS!=null && !dateS.equals("")){
                date = new SimpleDateFormat("MM/dd/yyyy").parse(dateS);
            }
        } catch (ParseException ex) {
            getTfDateDS().setBackground(Color.red);
        }

    }//GEN-LAST:event_tfDateDSFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList listReferences;
    private javax.swing.JTextField tfCreator;
    private javax.swing.JTextField tfDateDS;
    private javax.swing.JTextField tfDonor;
    private javax.swing.JTextArea txtAreaDescription;
    private javax.swing.JTextField txtFieldDataSetTitle;
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
        return null;
    }

    /**
     * @return the txtAreaDescription
     */
    public javax.swing.JTextArea getTxtAreaDescription() {
        return txtAreaDescription;
    }

    /**
     * @return the txtFieldDataSetTitle
     */
    public javax.swing.JTextField getTxtFieldDataSetTitle() {
        return txtFieldDataSetTitle;
    }

    /**
     * @return the listReferences
     */
    public javax.swing.JList getListReferences() {
        return listReferences;
    }


//    /**
//     * @return the tfAuthors
//     */
//    public javax.swing.JTextField getTfAuthors() {
//        return tfAuthors;
//    }

    /**
     * @return the tfCreator
     */
    public javax.swing.JTextField getTfCreator() {
        return tfCreator;
    }

//    /**
//     * @return the tfDate
//     */
//    public javax.swing.JTextField getTfDate() {
//        return tfDate;
//    }

    /**
     * @return the tfDateDS
     */
    public javax.swing.JTextField getTfDateDS() {
        return tfDateDS;
    }

    /**
     * @return the tfDonor
     */
    public javax.swing.JTextField getTfDonor() {
        return tfDonor;
    }

//    /**
//     * @return the tfLocation
//     */
//    public javax.swing.JTextField getTfLocation() {
//        return tfLocation;
//    }
//
//    /**
//     * @return the tfOtherInformation
//     */
//    public javax.swing.JTextArea getTfOtherInformation() {
//        return tfOtherInformation;
//    }

//    /**
//     * @return the tfTitle
//     */
//    public javax.swing.JTextField getTfTitle() {
//        return tfTitle;
//    }

    public void setControllerDataSet(ControllerUI_DataSet controllerDataSet) {
        this.controllerDataSet = controllerDataSet;
    }

//    public JButton getBtnUpdate() {
//        return btnUpdate;
//    }
//    
    
}
