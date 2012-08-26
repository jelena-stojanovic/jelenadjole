/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel;

import java.awt.Container;
import view.controllers.ControllerUI_DSExport;

/**
 *
 * @author Jelena
 */
public class PanelExportDS extends javax.swing.JPanel {

    private ControllerUI_DSExport controllerExport;

    /**
     * Creates new form PanelImportDS
     */
    public PanelExportDS() {
        initComponents();
        setActivePanel(new PanelAllDataSets());
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
        tpnlExportDS = new javax.swing.JTabbedPane();
        pnlSelectDS = new javax.swing.JPanel();
        btnNextSelect = new javax.swing.JButton();
        pnlAllDataSets = new javax.swing.JPanel();
        pnlSelectFormat = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        checkBCSV = new javax.swing.JCheckBox();
        checkBAML = new javax.swing.JCheckBox();
        chechBText = new javax.swing.JCheckBox();
        btnNextFormat = new javax.swing.JButton();
        btnPreviousFormat = new javax.swing.JButton();
        pnlParseFile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlParseLine = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        checkBUseFirstRow = new javax.swing.JCheckBox();
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
        pnlDateFormat = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtFieldDateFormat = new javax.swing.JTextField();
        pnlSelectFile = new javax.swing.JPanel();
        fileChooserDS = new javax.swing.JFileChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFieldFileName = new javax.swing.JTextField();

        pnlSelectDS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNextSelect.setText("Next -->");
        btnNextSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextSelectActionPerformed(evt);
            }
        });
        pnlSelectDS.add(btnNextSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 546, -1, -1));

        pnlAllDataSets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlSelectDS.add(pnlAllDataSets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 780, 500));

        tpnlExportDS.addTab("Step 1: Select DataSet to save", pnlSelectDS);

        jLabel4.setText("Select format you want to export this data set:");

        checkBCSV.setText("CSV");

        checkBAML.setText("AML");
        checkBAML.setEnabled(false);

        chechBText.setText("Text");
        chechBText.setEnabled(false);

        btnNextFormat.setText("Next -->");
        btnNextFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextFormatActionPerformed(evt);
            }
        });

        btnPreviousFormat.setText("<-- Prevoius");
        btnPreviousFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousFormatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelectFormatLayout = new javax.swing.GroupLayout(pnlSelectFormat);
        pnlSelectFormat.setLayout(pnlSelectFormatLayout);
        pnlSelectFormatLayout.setHorizontalGroup(
            pnlSelectFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectFormatLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addGap(33, 33, 33)
                .addGroup(pnlSelectFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chechBText)
                    .addComponent(checkBAML)
                    .addComponent(checkBCSV))
                .addContainerGap(454, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectFormatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPreviousFormat)
                .addGap(18, 18, 18)
                .addComponent(btnNextFormat)
                .addGap(23, 23, 23))
        );
        pnlSelectFormatLayout.setVerticalGroup(
            pnlSelectFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectFormatLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlSelectFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(checkBCSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBAML)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chechBText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                .addGroup(pnlSelectFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextFormat)
                    .addComponent(btnPreviousFormat))
                .addGap(19, 19, 19))
        );

        tpnlExportDS.addTab("Step 2: Select format", pnlSelectFormat);

        jLabel1.setText("Please specify how the file should be parsed and how columns are separated.");

        pnlParseLine.setBorder(javax.swing.BorderFactory.createTitledBorder("Attribute name"));

        jLabel2.setText("<html><p>Would you like to write attribute names to your dataset file?</p></html>");

        checkBUseFirstRow.setText("Use first row as attribute name.");
        checkBUseFirstRow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBUseFirstRowItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlParseLineLayout = new javax.swing.GroupLayout(pnlParseLine);
        pnlParseLine.setLayout(pnlParseLineLayout);
        pnlParseLineLayout.setHorizontalGroup(
            pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseLineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addGroup(pnlParseLineLayout.createSequentialGroup()
                        .addComponent(checkBUseFirstRow)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlParseLineLayout.setVerticalGroup(
            pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseLineLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBUseFirstRow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlColumnSeparation.setBorder(javax.swing.BorderFactory.createTitledBorder("Column separation"));

        rbgColumnSeparator.add(rbComma);
        rbComma.setText("Comma \",\"");
        rbComma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCommaActionPerformed(evt);
            }
        });

        rbgColumnSeparator.add(rbSemicolon);
        rbSemicolon.setText("Semicolon \";\"");
        rbSemicolon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSemicolonActionPerformed(evt);
            }
        });

        rbgColumnSeparator.add(rbSpace);
        rbSpace.setText("Space");
        rbSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSpaceActionPerformed(evt);
            }
        });

        rbgColumnSeparator.add(rbTab);
        rbTab.setText("Tab");
        rbTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTabActionPerformed(evt);
            }
        });

        checkBUseQuotes.setText("Use quotes");

        javax.swing.GroupLayout pnlColumnSeparationLayout = new javax.swing.GroupLayout(pnlColumnSeparation);
        pnlColumnSeparation.setLayout(pnlColumnSeparationLayout);
        pnlColumnSeparationLayout.setHorizontalGroup(
            pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColumnSeparationLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlColumnSeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbComma)
                    .addComponent(rbSpace)
                    .addComponent(rbTab)
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
                .addContainerGap(13, Short.MAX_VALUE))
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

        pnlDateFormat.setBorder(javax.swing.BorderFactory.createTitledBorder("Date Format"));

        jLabel6.setText("Type desired date format: ");

        javax.swing.GroupLayout pnlDateFormatLayout = new javax.swing.GroupLayout(pnlDateFormat);
        pnlDateFormat.setLayout(pnlDateFormatLayout);
        pnlDateFormatLayout.setHorizontalGroup(
            pnlDateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDateFormatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFieldDateFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDateFormatLayout.setVerticalGroup(
            pnlDateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDateFormatLayout.createSequentialGroup()
                .addGroup(pnlDateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(txtFieldDateFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout pnlParseFileLayout = new javax.swing.GroupLayout(pnlParseFile);
        pnlParseFile.setLayout(pnlParseFileLayout);
        pnlParseFileLayout.setHorizontalGroup(
            pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParseFileLayout.createSequentialGroup()
                        .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlParseLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDateFormat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(pnlColumnSeparation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParseFileLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPreviousParse)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextParse)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlParseFileLayout.setVerticalGroup(
            pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlColumnSeparation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlParseFileLayout.createSequentialGroup()
                        .addComponent(pnlParseLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDateFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlParseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextParse)
                    .addComponent(btnPreviousParse))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tpnlExportDS.addTab("Step 3: Specify how the file should be parsed ", pnlParseFile);

        fileChooserDS.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooserDS.setCurrentDirectory(new java.io.File("C:\\Users\\Djordje\\Desktop"));
        fileChooserDS.setDialogTitle("Please select the location where the file should be exported.");
        fileChooserDS.setFileFilter(null);
        fileChooserDS.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooserDS.setName("Directory chooser"); // NOI18N
        fileChooserDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserDSActionPerformed(evt);
            }
        });

        jLabel3.setText("Please select the file that should be imported.");

        jLabel5.setText("File name: ");

        javax.swing.GroupLayout pnlSelectFileLayout = new javax.swing.GroupLayout(pnlSelectFile);
        pnlSelectFile.setLayout(pnlSelectFileLayout);
        pnlSelectFileLayout.setHorizontalGroup(
            pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileChooserDS, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSelectFileLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSelectFileLayout.setVerticalGroup(
            pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(pnlSelectFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(fileChooserDS, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpnlExportDS.addTab("Step 4:Select save location", pnlSelectFile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnlExportDS))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnlExportDS))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousParseActionPerformed
        controllerExport.saveFildValues();
        controllerExport.disableAllExcept(1);
    }//GEN-LAST:event_btnPreviousParseActionPerformed

    private void btnNextParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextParseActionPerformed
        controllerExport.saveFildValues();
        controllerExport.disableAllExcept(3);
    }//GEN-LAST:event_btnNextParseActionPerformed

    private void rbTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTabActionPerformed
        controllerExport.saveFildValues();
    }//GEN-LAST:event_rbTabActionPerformed

    private void rbSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSpaceActionPerformed
        controllerExport.saveFildValues();
    }//GEN-LAST:event_rbSpaceActionPerformed

    private void rbSemicolonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSemicolonActionPerformed
        controllerExport.saveFildValues();
    }//GEN-LAST:event_rbSemicolonActionPerformed

    private void rbCommaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCommaActionPerformed
        controllerExport.saveFildValues();
    }//GEN-LAST:event_rbCommaActionPerformed

    private void checkBUseFirstRowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBUseFirstRowItemStateChanged
        controllerExport.saveFildValues();
    }//GEN-LAST:event_checkBUseFirstRowItemStateChanged

    private void fileChooserDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserDSActionPerformed
        controllerExport.lastStep();
    }//GEN-LAST:event_fileChooserDSActionPerformed

    private void btnNextSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextSelectActionPerformed
        controllerExport.disableAllExcept(1);
        controllerExport.saveFildValues();

    }//GEN-LAST:event_btnNextSelectActionPerformed

    private void btnPreviousFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousFormatActionPerformed
        controllerExport.saveFildValues();
        controllerExport.disableAllExcept(0);
    }//GEN-LAST:event_btnPreviousFormatActionPerformed

    private void btnNextFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextFormatActionPerformed
        controllerExport.saveFildValues();
        controllerExport.disableAllExcept(2);
    }//GEN-LAST:event_btnNextFormatActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextFormat;
    private javax.swing.JButton btnNextParse;
    private javax.swing.JButton btnNextSelect;
    private javax.swing.JButton btnPreviousFormat;
    private javax.swing.JButton btnPreviousParse;
    private javax.swing.JCheckBox chechBText;
    private javax.swing.JCheckBox checkBAML;
    private javax.swing.JCheckBox checkBCSV;
    private javax.swing.JCheckBox checkBUseFirstRow;
    private javax.swing.JCheckBox checkBUseQuotes;
    private javax.swing.JFileChooser fileChooserDS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAllDataSets;
    private javax.swing.JPanel pnlColumnSeparation;
    private javax.swing.JPanel pnlDateFormat;
    private javax.swing.JPanel pnlParseFile;
    private javax.swing.JPanel pnlParseLine;
    private javax.swing.JPanel pnlSelectDS;
    private javax.swing.JPanel pnlSelectFile;
    private javax.swing.JPanel pnlSelectFormat;
    private javax.swing.JRadioButton rbComma;
    private javax.swing.JRadioButton rbSemicolon;
    private javax.swing.JRadioButton rbSpace;
    private javax.swing.JRadioButton rbTab;
    private javax.swing.ButtonGroup rbgColumnSeparator;
    private javax.swing.JTable tblDataSetPreprocessing;
    private javax.swing.JTabbedPane tpnlExportDS;
    private javax.swing.JTextField txtFieldDateFormat;
    private javax.swing.JTextField txtFieldFileName;
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
     * @return the btnNextFormat
     */
    public javax.swing.JButton getBtnNextFormat() {
        return btnNextFormat;
    }

    /**
     * @return the btnNextParse
     */
    public javax.swing.JButton getBtnNextParse() {
        return btnNextParse;
    }

    /**
     * @return the btnNextSelect
     */
    public javax.swing.JButton getBtnNextSelect() {
        return btnNextSelect;
    }

    /**
     * @return the btnPreviousFormat
     */
    public javax.swing.JButton getBtnPreviousFormat() {
        return btnPreviousFormat;
    }

    /**
     * @return the btnPreviousParse
     */
    public javax.swing.JButton getBtnPreviousParse() {
        return btnPreviousParse;
    }

    /**
     * @return the chechBText
     */
    public javax.swing.JCheckBox getChechBText() {
        return chechBText;
    }

    /**
     * @return the checkBAML
     */
    public javax.swing.JCheckBox getCheckBAML() {
        return checkBAML;
    }

    /**
     * @return the checkBCSV
     */
    public javax.swing.JCheckBox getCheckBCSV() {
        return checkBCSV;
    }

    /**
     * @return the tpnlExportDS
     */
    public javax.swing.JTabbedPane getTpnlExportDS() {
        return tpnlExportDS;
    }

    /**
     * @return the txtFieldFileName
     */
    public javax.swing.JTextField getTxtFieldFileName() {
        return txtFieldFileName;
    }

    /**
     * @return the txtFieldDateFormat
     */
    public javax.swing.JTextField getTxtFieldDateFormat() {
        return txtFieldDateFormat;
    }

    /**
     * @return the controllerExport
     */
    public ControllerUI_DSExport getControllerExport() {
        return controllerExport;
    }

    /**
     * @param controllerExport the controllerExport to set
     */
    public void setControllerExport(ControllerUI_DSExport controllerExport) {
        this.controllerExport = controllerExport;
    }

    /**
     * @return the pnlTableAndFieldAttributes
     */
    public void setActivePanel(PanelAllDataSets newPanel) {
        if (panelAllDataSets != null) {
            this.remove(panelAllDataSets);
        }

        
        panelAllDataSets = newPanel;
        panelAllDataSets.setSize(getPnlAllDataSets().getSize());
        panelAllDataSets.setLocation(getPnlAllDataSets().getLocation());
        getPnlAllDataSets().add(panelAllDataSets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 780, 500));
        //getPnlAllDataSets().add(panelAllDataSets);
        panelAllDataSets.setVisible(true);
        validate();
        repaint();
        
    }
    
    public void pack(){
        Container parent = this.getParent();
        if (parent != null && parent.getPeer() == null) {
            parent.addNotify();
        }
        if (getPeer() == null) {
            addNotify();
        }
        
       
    
    }
    
    PanelAllDataSets panelAllDataSets;

    /**
     * @return the pnlAllDataSets
     */
    public javax.swing.JPanel getPnlAllDataSets() {
        return pnlAllDataSets;
    }
    
    public PanelAllDataSets getPanelAllDataSets() {
        return panelAllDataSets;
    }
    
    
}
