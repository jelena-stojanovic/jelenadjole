/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel;

import java.io.File;
import view.controllers.ControllerUI_DSImport;

/**
 *
 * @author Jelena
 */
public class PanelImportDS extends javax.swing.JPanel {

    /**
     * Creates new form PanelImportDS
     */
    public PanelImportDS() {
        initComponents();
        ControllerUI_DSImport.getInstance().setPanelImportDS(this);
        ControllerUI_DSImport.getInstance().disableAllExcept(0);
        ControllerUI_DSImport.getInstance().setValuesToGUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgColumnSeparator = new javax.swing.ButtonGroup();
        tpnlImportDS = new javax.swing.JTabbedPane();
        pnlSelectFile = new javax.swing.JPanel();
        fileChooserDS = new javax.swing.JFileChooser();
        jLabel3 = new javax.swing.JLabel();
        pnlParseFile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlParseLine = new javax.swing.JPanel();
        checkbTrimLines = new javax.swing.JCheckBox();
        chexkBSkipComments = new javax.swing.JCheckBox();
        lblCommentChar = new javax.swing.JLabel();
        tfCommentChar = new javax.swing.JTextField();
        pnlColumnSeparation = new javax.swing.JPanel();
        rbComma = new javax.swing.JRadioButton();
        rbSemicolon = new javax.swing.JRadioButton();
        rbSpace = new javax.swing.JRadioButton();
        rbTab = new javax.swing.JRadioButton();
        checkBUseQuotes = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataSetPreprocessing = new javax.swing.JTable();
        btnNextParse = new javax.swing.JButton();
        btnPreviousParse = new javax.swing.JButton();
        pnlNameOfAtt = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        checkBUseFirstRow = new javax.swing.JCheckBox();
        btnNextFirstRow = new javax.swing.JButton();
        btnPrevioucFirstRow = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDataTypes = new javax.swing.JTable();
        btnPreviousDataTypes = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();

        fileChooserDS.setCurrentDirectory(new java.io.File("C:\\Users\\Jelena\\Desktop"));
        fileChooserDS.setDialogTitle("Please select the file that should be imported.");
        fileChooserDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserDSActionPerformed(evt);
            }
        });

        jLabel3.setText("Please select the file that should be imported.");

        javax.swing.GroupLayout pnlSelectFileLayout = new javax.swing.GroupLayout(pnlSelectFile);
        pnlSelectFile.setLayout(pnlSelectFileLayout);
        pnlSelectFileLayout.setHorizontalGroup(
            pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileChooserDS, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSelectFileLayout.setVerticalGroup(
            pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileChooserDS, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpnlImportDS.addTab("Step 1: Select file", pnlSelectFile);

        jLabel1.setText("Please specify how the file should be parsed and how columns are separated.");

        pnlParseLine.setBorder(javax.swing.BorderFactory.createTitledBorder("Parse file"));

        checkbTrimLines.setText("Trim lines");

        chexkBSkipComments.setText("Skip Comments");

        lblCommentChar.setText("Comment character:");

        javax.swing.GroupLayout pnlParseLineLayout = new javax.swing.GroupLayout(pnlParseLine);
        pnlParseLine.setLayout(pnlParseLineLayout);
        pnlParseLineLayout.setHorizontalGroup(
            pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseLineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbTrimLines)
                    .addComponent(chexkBSkipComments)
                    .addComponent(lblCommentChar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tfCommentChar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlParseLineLayout.setVerticalGroup(
            pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseLineLayout.createSequentialGroup()
                .addComponent(checkbTrimLines)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chexkBSkipComments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommentChar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCommentChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlColumnSeparation.setBorder(javax.swing.BorderFactory.createTitledBorder("Column separation"));

        rbgColumnSeparator.add(rbComma);
        rbComma.setText("Comma \",\"");

        rbgColumnSeparator.add(rbSemicolon);
        rbSemicolon.setText("Semicolon \";\"");

        rbgColumnSeparator.add(rbSpace);
        rbSpace.setText("Space");

        rbgColumnSeparator.add(rbTab);
        rbTab.setText("Tab");

        checkBUseQuotes.setText("Use quotes");

        javax.swing.GroupLayout pnlColumnSeparationLayout = new javax.swing.GroupLayout(pnlColumnSeparation);
        pnlColumnSeparation.setLayout(pnlColumnSeparationLayout);
        pnlColumnSeparationLayout.setHorizontalGroup(
            pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColumnSeparationLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColumnSeparationLayout.createSequentialGroup()
                        .addGroup(pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbComma)
                            .addComponent(rbSpace)
                            .addComponent(rbTab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbSemicolon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(checkBUseQuotes)
                .addGap(28, 28, 28))
        );
        pnlColumnSeparationLayout.setVerticalGroup(
            pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColumnSeparationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbComma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSemicolon)
                    .addComponent(checkBUseQuotes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSpace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbTab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDataSetPreprocessing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDataSetPreprocessing);

        btnNextParse.setText("Next -->");
        btnNextParse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextParseActionPerformed(evt);
            }
        });

        btnPreviousParse.setText("<-- Previous");
        btnPreviousParse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousParseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlParseFileLayout = new javax.swing.GroupLayout(pnlParseFile);
        pnlParseFile.setLayout(pnlParseFileLayout);
        pnlParseFileLayout.setHorizontalGroup(
            pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParseFileLayout.createSequentialGroup()
                        .addComponent(pnlParseLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlColumnSeparation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParseFileLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPreviousParse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextParse)))
                .addContainerGap())
        );
        pnlParseFileLayout.setVerticalGroup(
            pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlColumnSeparation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlParseLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextParse)
                    .addComponent(btnPreviousParse))
                .addContainerGap())
        );

        tpnlImportDS.addTab("Step 2: Specify how the file should be parsed ", pnlParseFile);

        jLabel2.setText("Now the name of attributes are \"att1\", \"att2\"... Should we use the first row as attributes' names?");

        checkBUseFirstRow.setText("Use first row as attribute name.");

        btnNextFirstRow.setText("Next -->");
        btnNextFirstRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextFirstRowActionPerformed(evt);
            }
        });

        btnPrevioucFirstRow.setText("<-- Previous");
        btnPrevioucFirstRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevioucFirstRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNameOfAttLayout = new javax.swing.GroupLayout(pnlNameOfAtt);
        pnlNameOfAtt.setLayout(pnlNameOfAttLayout);
        pnlNameOfAttLayout.setHorizontalGroup(
            pnlNameOfAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNameOfAttLayout.createSequentialGroup()
                .addGroup(pnlNameOfAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNameOfAttLayout.createSequentialGroup()
                        .addGroup(pnlNameOfAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNameOfAttLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2))
                            .addGroup(pnlNameOfAttLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(checkBUseFirstRow)))
                        .addGap(0, 249, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNameOfAttLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrevioucFirstRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextFirstRow)))
                .addContainerGap())
        );
        pnlNameOfAttLayout.setVerticalGroup(
            pnlNameOfAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNameOfAttLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(checkBUseFirstRow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addGroup(pnlNameOfAttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextFirstRow)
                    .addComponent(btnPrevioucFirstRow))
                .addGap(19, 19, 19))
        );

        tpnlImportDS.addTab("Step 3: The first row as name", pnlNameOfAtt);

        tblDataTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblDataTypes);

        btnPreviousDataTypes.setText("<-- Previous");
        btnPreviousDataTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousDataTypesActionPerformed(evt);
            }
        });

        btnFinish.setText("Finish :)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPreviousDataTypes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish)
                    .addComponent(btnPreviousDataTypes))
                .addGap(21, 21, 21))
        );

        tpnlImportDS.addTab("Step 4: Data types of attributes", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnlImportDS))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnlImportDS)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fileChooserDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserDSActionPerformed
        ControllerUI_DSImport.getInstance().chooseFile();
        
    }//GEN-LAST:event_fileChooserDSActionPerformed

    private void btnPreviousParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousParseActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
        ControllerUI_DSImport.getInstance().disableAllExcept(0);
    }//GEN-LAST:event_btnPreviousParseActionPerformed

    private void btnNextParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextParseActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
        ControllerUI_DSImport.getInstance().disableAllExcept(2);
    }//GEN-LAST:event_btnNextParseActionPerformed

    private void btnPrevioucFirstRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevioucFirstRowActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
        ControllerUI_DSImport.getInstance().disableAllExcept(1);
    }//GEN-LAST:event_btnPrevioucFirstRowActionPerformed

    private void btnNextFirstRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextFirstRowActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
        ControllerUI_DSImport.getInstance().disableAllExcept(3);
    }//GEN-LAST:event_btnNextFirstRowActionPerformed

    private void btnPreviousDataTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousDataTypesActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
        ControllerUI_DSImport.getInstance().disableAllExcept(2);
    }//GEN-LAST:event_btnPreviousDataTypesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnNextFirstRow;
    private javax.swing.JButton btnNextParse;
    private javax.swing.JButton btnPrevioucFirstRow;
    private javax.swing.JButton btnPreviousDataTypes;
    private javax.swing.JButton btnPreviousParse;
    private javax.swing.JCheckBox checkBUseFirstRow;
    private javax.swing.JCheckBox checkBUseQuotes;
    private javax.swing.JCheckBox checkbTrimLines;
    private javax.swing.JCheckBox chexkBSkipComments;
    private javax.swing.JFileChooser fileChooserDS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCommentChar;
    private javax.swing.JPanel pnlColumnSeparation;
    private javax.swing.JPanel pnlNameOfAtt;
    private javax.swing.JPanel pnlParseFile;
    private javax.swing.JPanel pnlParseLine;
    private javax.swing.JPanel pnlSelectFile;
    private javax.swing.JRadioButton rbComma;
    private javax.swing.JRadioButton rbSemicolon;
    private javax.swing.JRadioButton rbSpace;
    private javax.swing.JRadioButton rbTab;
    private javax.swing.ButtonGroup rbgColumnSeparator;
    private javax.swing.JTable tblDataSetPreprocessing;
    private javax.swing.JTable tblDataTypes;
    private javax.swing.JTextField tfCommentChar;
    private javax.swing.JTabbedPane tpnlImportDS;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the checkBUseFirstRow
     */
    public javax.swing.JCheckBox getCheckBUseFirstRow() {
        return checkBUseFirstRow;
    }

    /**
     * @return the checkBUseQuotes
     */
    public javax.swing.JCheckBox getCheckBUseQuotes() {
        return checkBUseQuotes;
    }

    /**
     * @return the checkbTrimLines
     */
    public javax.swing.JCheckBox getCheckbTrimLines() {
        return checkbTrimLines;
    }

    /**
     * @return the chexkBSkipComments
     */
    public javax.swing.JCheckBox getChexkBSkipComments() {
        return chexkBSkipComments;
    }

    /**
     * @return the fileChooserDS
     */
    public javax.swing.JFileChooser getFileChooserDS() {
        return fileChooserDS;
    }

    /**
     * @return the rbComma
     */
    public javax.swing.JRadioButton getRbComma() {
        return rbComma;
    }

    /**
     * @return the rbSemicolon
     */
    public javax.swing.JRadioButton getRbSemicolon() {
        return rbSemicolon;
    }

    /**
     * @return the rbSpace
     */
    public javax.swing.JRadioButton getRbSpace() {
        return rbSpace;
    }

    /**
     * @return the rbTab
     */
    public javax.swing.JRadioButton getRbTab() {
        return rbTab;
    }

    /**
     * @return the rbgColumnSeparator
     */
    public javax.swing.ButtonGroup getRbgColumnSeparator() {
        return rbgColumnSeparator;
    }

    /**
     * @return the tblDataSetPreprocessing
     */
    public javax.swing.JTable getTblDataSetPreprocessing() {
        return tblDataSetPreprocessing;
    }

    /**
     * @return the tblDataTypes
     */
    public javax.swing.JTable getTblDataTypes() {
        return tblDataTypes;
    }

    /**
     * @return the tpnlImportDS
     */
    public javax.swing.JTabbedPane getTpnlImportDS() {
        return tpnlImportDS;
    }

    /**
     * @return the tfCommentChar
     */
    public javax.swing.JTextField getTfCommentChar() {
        return tfCommentChar;
    }

    
}
