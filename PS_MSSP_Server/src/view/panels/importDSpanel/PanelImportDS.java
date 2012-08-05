/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel;

import java.awt.Color;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        pnlDSInformation = new javax.swing.JPanel();
        btnNextFirstRow = new javax.swing.JButton();
        btnPrevioucFirstRow = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfDataSetTitle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDataSetDescription = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfCreator = new javax.swing.JTextField();
        tfDonor = new javax.swing.JTextField();
        tfDateDS = new javax.swing.JTextField();
        pnlAttributeTypes = new javax.swing.JPanel();
        btnPreviousDataTypes = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDataTypes = new javax.swing.JTable();

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

        pnlParseLine.setBorder(javax.swing.BorderFactory.createTitledBorder("Attribute name"));

        jLabel2.setText("<html><p>Now the name of attributes are \"att1\", \"att2\"... </br>\nShould we use the first row as attributes' names?</p></html>");

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
                    .addGroup(pnlParseLineLayout.createSequentialGroup()
                        .addComponent(checkBUseFirstRow)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        pnlParseLineLayout.setVerticalGroup(
            pnlParseLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParseLineLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
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

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("o");

        jLabel6.setText("Data set name:");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("o");

        jLabel8.setText("Data set description:");

        taDataSetDescription.setColumns(20);
        taDataSetDescription.setRows(5);
        jScrollPane2.setViewportView(taDataSetDescription);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("o   Data set source:"));

        jLabel11.setText("Creator:");

        jLabel12.setText("Donor:");

        jLabel13.setText("Date (please insert date in format MM/dd/yyyy):");

        tfDateDS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDateDSFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCreator))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfDateDS))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDonor)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfDonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfCreator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(tfDateDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDSInformationLayout = new javax.swing.GroupLayout(pnlDSInformation);
        pnlDSInformation.setLayout(pnlDSInformationLayout);
        pnlDSInformationLayout.setHorizontalGroup(
            pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDSInformationLayout.createSequentialGroup()
                .addGroup(pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDSInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDSInformationLayout.createSequentialGroup()
                        .addGap(0, 575, Short.MAX_VALUE)
                        .addComponent(btnPrevioucFirstRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextFirstRow))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDSInformationLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDSInformationLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDataSetTitle))
                            .addGroup(pnlDSInformationLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDSInformationLayout.setVerticalGroup(
            pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSInformationLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfDataSetTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(pnlDSInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextFirstRow)
                    .addComponent(btnPrevioucFirstRow))
                .addGap(19, 19, 19))
        );

        tpnlImportDS.addTab("Step 3: Data set information", pnlDSInformation);

        btnPreviousDataTypes.setText("<-- Previous");
        btnPreviousDataTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousDataTypesActionPerformed(evt);
            }
        });

        btnFinish.setText("Finish :)");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        tblDataTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblDataTypes);

        javax.swing.GroupLayout pnlAttributeTypesLayout = new javax.swing.GroupLayout(pnlAttributeTypes);
        pnlAttributeTypes.setLayout(pnlAttributeTypesLayout);
        pnlAttributeTypesLayout.setHorizontalGroup(
            pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAttributeTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnlAttributeTypesLayout.createSequentialGroup()
                        .addGap(0, 551, Short.MAX_VALUE)
                        .addComponent(btnPreviousDataTypes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAttributeTypesLayout.setVerticalGroup(
            pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttributeTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinish)
                    .addComponent(btnPreviousDataTypes))
                .addGap(21, 21, 21))
        );

        tpnlImportDS.addTab("Step 4: Data types of attributes", pnlAttributeTypes);

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

    private void rbSemicolonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSemicolonActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
    }//GEN-LAST:event_rbSemicolonActionPerformed

    private void rbCommaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCommaActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
    }//GEN-LAST:event_rbCommaActionPerformed

    private void rbSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSpaceActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
    }//GEN-LAST:event_rbSpaceActionPerformed

    private void rbTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTabActionPerformed
        ControllerUI_DSImport.getInstance().saveFildValues();
    }//GEN-LAST:event_rbTabActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed

        ControllerUI_DSImport.getInstance().saveFildValues();
        ControllerUI_DSImport.getInstance().finish();
    }//GEN-LAST:event_btnFinishActionPerformed

    private void tfDateDSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDateDSFocusLost
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            Date date= sdf.parse(tfDateDS.getText().trim());
        } catch (ParseException ex) {
            tfDateDS.setBackground(Color.red);
        }
        
        
    }//GEN-LAST:event_tfDateDSFocusLost

    private void checkBUseFirstRowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBUseFirstRowItemStateChanged
        ControllerUI_DSImport.getInstance().saveFildValues();
    }//GEN-LAST:event_checkBUseFirstRowItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnNextFirstRow;
    private javax.swing.JButton btnNextParse;
    private javax.swing.JButton btnPrevioucFirstRow;
    private javax.swing.JButton btnPreviousDataTypes;
    private javax.swing.JButton btnPreviousParse;
    private javax.swing.JCheckBox checkBUseFirstRow;
    private javax.swing.JCheckBox checkBUseQuotes;
    private javax.swing.JFileChooser fileChooserDS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlAttributeTypes;
    private javax.swing.JPanel pnlColumnSeparation;
    private javax.swing.JPanel pnlDSInformation;
    private javax.swing.JPanel pnlParseFile;
    private javax.swing.JPanel pnlParseLine;
    private javax.swing.JPanel pnlSelectFile;
    private javax.swing.JRadioButton rbComma;
    private javax.swing.JRadioButton rbSemicolon;
    private javax.swing.JRadioButton rbSpace;
    private javax.swing.JRadioButton rbTab;
    private javax.swing.ButtonGroup rbgColumnSeparator;
    private javax.swing.JTextArea taDataSetDescription;
    private javax.swing.JTable tblDataSetPreprocessing;
    private javax.swing.JTable tblDataTypes;
    private javax.swing.JTextField tfCreator;
    private javax.swing.JTextField tfDataSetTitle;
    private javax.swing.JTextField tfDateDS;
    private javax.swing.JTextField tfDonor;
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
     * @return the btnFinish
     */
    public javax.swing.JButton getBtnFinish() {
        return btnFinish;
    }

    /**
     * @return the btnPreviousDataTypes
     */
    public javax.swing.JButton getBtnPreviousDataTypes() {
        return btnPreviousDataTypes;
    }

    /**
     * @return the jScrollPane3
     */
    public javax.swing.JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    /**
     * @return the pnlAttributeTypes
     */
    public javax.swing.JPanel getPnlAttributeTypes() {
        return pnlAttributeTypes;
    }

    /**
     * @return the pnlTableAndFieldAttributes
     */
    
    
}
