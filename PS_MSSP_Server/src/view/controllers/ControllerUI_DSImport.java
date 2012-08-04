/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import import_csv.GuessValueTypesClass;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.TableView;
import javax.swing.text.TableView.TableCell;
import javax.swing.text.TableView.TableRow;
import logic.ControllerAL_DSImport;
import model.attribute.Attribute;
import model.attribute.Ontology;
import model.dataFormat.CSVFormat;
import view.panels.importDSpanel.PanelImportDS;
import view.panels.importDSpanel.model.TableDataTypes;
import view.panels.importDSpanel.model.TableModelDataTypes;

/**
 *
 * @author Jelena
 */
public class ControllerUI_DSImport {

    KonverterTipova converter;
    ControllerAL_DSImport controllerAL_DSImport = ControllerAL_DSImport.getInstance();
    PanelImportDS panelImportDS;
    CSVFormat cSVFormat = new CSVFormat();
    /*
     * --local--
     */
    String[] columnIdentifiers = null;
    ArrayList<String[]> stringArrayList = new ArrayList<String[]>();
    ArrayList<JTextField> textFields = new ArrayList<JTextField>();
    ArrayList<JComboBox> attributesRole = new ArrayList<JComboBox>();
    ArrayList<JComboBox> attributesType = new ArrayList<JComboBox>();
    /*
     * ---- csv format fields -----
     */
    File file = null;
    boolean trimLines = false;
    boolean skipComments = false;
    char commentsChar = '#';
    char columnSeparation = ',';
    boolean useFirstROwAsAttributeName = false;
    boolean useQuotesForNominal = true;
    /*
     * ----end of csv format fields -----
     */

    private ControllerUI_DSImport() {
    }

    public static ControllerUI_DSImport getInstance() {
        return ControllerUI_DSImportHolder.INSTANCE;
    }

    public void saveFildValues() {
        trimLines = KonverterTipova.Konvertuj(panelImportDS.getCheckbTrimLines(), trimLines);
        cSVFormat.setTrimLines(trimLines);

        skipComments = KonverterTipova.Konvertuj(panelImportDS.getChexkBSkipComments(), skipComments);
        cSVFormat.setSkipComments(skipComments);

        commentsChar = panelImportDS.getTfCommentChar().getText().trim().charAt(0);
        cSVFormat.setCommentCharacter(commentsChar);

        columnSeparation = getSelectedColumnSeparator();
        cSVFormat.setColumnSeparator(columnSeparation);

        useFirstROwAsAttributeName = KonverterTipova.Konvertuj(panelImportDS.getCheckBUseFirstRow(), useFirstROwAsAttributeName);
        cSVFormat.setUseFirstRowAsAttributeNames(useFirstROwAsAttributeName);

        useQuotesForNominal = KonverterTipova.Konvertuj(panelImportDS.getCheckBUseQuotes(), useQuotesForNominal);
        cSVFormat.setUseQuotesForNominal(useQuotesForNominal);

        fillTblDataSetPreprocessing();
        setValuesToGUI();
    }

    private static class ControllerUI_DSImportHolder {

        private static final ControllerUI_DSImport INSTANCE = new ControllerUI_DSImport();
    }

    public void setPanelImportDS(PanelImportDS panelImportDS) {
        this.panelImportDS = panelImportDS;
    }

    public void disableAllExcept(int numberOfPane) {
        for (int i = 0; i < 4; i++) {
            panelImportDS.getTpnlImportDS().setEnabledAt(i, false);
        }
        panelImportDS.getTpnlImportDS().setEnabledAt(numberOfPane, true);
        panelImportDS.getTpnlImportDS().setSelectedIndex(numberOfPane);
    }

    public void chooseFile() {
        file = panelImportDS.getFileChooserDS().getSelectedFile();
        cSVFormat.setCsvFile(file);
        disableAllExcept(1);
        fillTblDataSetPreprocessing();
        fillTblDataTypes();
    }

    public void setValuesToGUI() {
        KonverterTipova.Konvertuj(trimLines, panelImportDS.getCheckbTrimLines());

        KonverterTipova.Konvertuj(skipComments, panelImportDS.getChexkBSkipComments());

        panelImportDS.getTfCommentChar().setText(String.valueOf(commentsChar));

        getSelectedRBColumnSeparator().setSelected(true);

        KonverterTipova.Konvertuj(useFirstROwAsAttributeName, panelImportDS.getCheckBUseFirstRow());

        KonverterTipova.Konvertuj(useQuotesForNominal, panelImportDS.getCheckBUseQuotes());

        if (file != null) {
            fillTblDataSetPreprocessing();
            fillTblDataTypes();
        }
    }

    public JRadioButton getSelectedRBColumnSeparator() {
        char character = columnSeparation;
        if (character == ',') {
            return panelImportDS.getRbComma();
        } else if (character == ';') {
            return panelImportDS.getRbSemicolon();
        } else if (character == ' ') {
            return panelImportDS.getRbSpace();
        } else if (character == '\t') {
            return panelImportDS.getRbTab();
        }
        return panelImportDS.getRbComma();
    }

    private char getSelectedColumnSeparator() {
        char character = 0;
        ButtonGroup gbr = panelImportDS.getRbgColumnSeparator();
        for (Enumeration e = gbr.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == gbr.getSelection()) {
                String selectedAvatar = b.getText();
                if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(panelImportDS.getRbComma().getText())) {
                    character = ',';
                } else if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(panelImportDS.getRbSemicolon().getText())) {
                    character = ';';
                } else if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(panelImportDS.getRbSpace().getText())) {
                    character = ' ';
                } else if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(panelImportDS.getRbTab().getText())) {
                    character = '\t';
                }
            }
        }
        return character;
    }

    public void fillTblDataSetPreprocessing() {
        try {
            JTable table = panelImportDS.getTblDataSetPreprocessing();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();

            stringArrayList = controllerAL_DSImport.readCSV(cSVFormat.getCsvFile().getPath(), columnSeparation);
            if (useFirstROwAsAttributeName) {
                columnIdentifiers = stringArrayList.get(0);
                stringArrayList.remove(0);
            } else {
                columnIdentifiers = new String[stringArrayList.get(0).length];
                for (int i = 0; i < columnIdentifiers.length; i++) {
                    columnIdentifiers[i] = "Att" + (i + 1);
                }
            }

            String[][] matrix = new String[stringArrayList.size()][stringArrayList.get(0).length];
            matrix = controllerAL_DSImport.convert(stringArrayList, matrix);
            dtm.setDataVector(matrix, columnIdentifiers);
        } catch (IOException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillTblDataTypes() {
        if(columnIdentifiers!=null){
            TableDataTypes tblDatatypes=new TableDataTypes(panelImportDS.getPnlAttributeTypes(), panelImportDS.getjScrollPane3(), panelImportDS.getBtnPreviousDataTypes(), panelImportDS.getBtnFinish(), columnIdentifiers, stringArrayList);
            TableModelDataTypes tmdt= new TableModelDataTypes(stringArrayList, columnIdentifiers);
            tblDatatypes.setModel(tmdt);
            
        }
        /*JTable table = panelImportDS.getTblDataTypes();
        TableModelDataTypes tmdt= new TableModelDataTypes(stringArrayList, columnIdentifiers);
        table.setModel(tmdt);
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < tmdt.getColumnCount(); j++) {
                TableCellEditor cellEditor=tmdt.getCellEditor(i, j);
                table.setCellEditor(cellEditor);
                //table.firepro
                        
                        
                 
            }
            
        }*/
                /*List<String> lm = Ontology.getAttributeRoles();

        JComboBox jc = new JComboBox();
        for (String string : lm) {
            jc.addItem(string);
        }

        TableColumnModel tcm = table.getColumnModel();
        TableColumn tc=  tcm.getColumn(3);

        tc.setCellEditor(new DefaultCellEditor(jc));
        table.setCellEditor(new DefaultCellEditor(jc));*/
        
        
//        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
       // dtm= new DefaultTableModel();
        
        
   /*     if (columnIdentifiers != null) {
            dtm.setColumnCount(columnIdentifiers.length);
            dtm.setRowCount(columnIdentifiers.length);
            JComboBox[] comboBoxsAttributeRole = new JComboBox[columnIdentifiers.length];
            JComboBox[] comboBoxsAttributeType = new JComboBox[columnIdentifiers.length];
            
            for (int i = 0; i < columnIdentifiers.length; i++) {
                comboBoxsAttributeRole[i]= new JComboBox();
                comboBoxsAttributeType[i]= new JComboBox();
            }

            

            fillCBs(comboBoxsAttributeRole, comboBoxsAttributeType);
            
            for (int i = 0; i < columnIdentifiers.length; i++) {
                
                comboBoxsAttributeRole[i].setSelectedItem("Attribute");
                comboBoxsAttributeType[i].setSelectedItem(GuessValueTypesClass.guessValueType(stringArrayList.get(1)[i]));
                
            }
            
            JComboBox jc = new JComboBox();
            //jc.setModel(new DefaultComboBoxModel(Ontology.getAttributeRoles().toArray()));

            for (String string : Ontology.getAttributeRoles()) {
                jc.addItem(string);
            }
            
            TableColumnModel tcm = table.getColumnModel();
            TableColumn tc=  tcm.getColumn(0);

            tc.setCellEditor(new DefaultCellEditor(jc));
*/
            //TableCellEditor tce=new DefaultCellEditor(jc);
            
            //table.setCellEditor(tce);
            
            /*dtm.addRow(columnIdentifiers);
            
            dtm.addRow(comboBoxsAttributeType);
            
            dtm.addRow(comboBoxsAttributeRole);
            
            for (int i = 0; i < columnIdentifiers.length; i++) {
                for (int j = 0; j < 3; j++) {
                    dtm.isCellEditable(j, i);
                }
                
            }
            
            for (int i = 0; i < stringArrayList.size(); i++) {
            String[] strings = stringArrayList.get(i);
            dtm.addRow(strings);
            
            }
            
            table.setModel(dtm);*/
        

//        String[][] matrix = new String[stringArrayList.size()][stringArrayList.get(0).length];
//        matrix = controllerAL_DSImport.convert(stringArrayList, matrix);
//        dtm.
//                setDataVector(matrix, columnIdentifiers);
//
//
//        createTfAndCBs();
    
        
    }
    public void createAttributes(String[] columnIdentifiers) {

        List<Attribute> attributes = new ArrayList<Attribute>();
        for (int i = 0; i < columnIdentifiers.length; i++) {
            String string = columnIdentifiers[i];
            //       attributes.add(new Attribute() {});

        }

    }

    public void fillCBs(JComboBox[] comboBoxsAttributeRole, JComboBox[] comboBoxsAttributeType) {

        for (int i = 0; i < comboBoxsAttributeRole.length; i++) {
            JComboBox jComboBox = comboBoxsAttributeRole[i];
            for (String string : Ontology.getAttributeRoles()) {
                jComboBox.addItem(string);
            }
        }

        for (int i = 0; i < comboBoxsAttributeType.length; i++) {
            JComboBox jComboBox = comboBoxsAttributeType[i];
            for (String string : Ontology.getAttributeTypes()) {
                jComboBox.addItem(string);
            }
        }
            /*
             * panelImportDS.getCbAttributeRole().removeAllItems();
             * panelImportDS.getCbAttributeType().removeAllItems(); for (String
             * string : Ontology.getAttributeTypes()) {
             * panelImportDS.getCbAttributeType().addItem(string); } for (String
             * string : Ontology.getAttributeRoles()) {
             * panelImportDS.getCbAttributeRole().addItem(string); }
             */
        }

    

    /*public void createTfAndCBs() {
        for (int i = 0; i < columnIdentifiers.length; i++) {
            JTextField jtf = new JTextField();
            jtf.setText(columnIdentifiers[i]);
            jtf.setSize(panelImportDS.getTfAttributeName().getSize());

            int x = (int) ((1 + i) * panelImportDS.getTfAttributeName().getSize().getWidth() + panelImportDS.getTfAttributeName().getLocation().getX());
            int y = (int) panelImportDS.getTfAttributeName().getLocation().getY();
            jtf.setLocation(x, y);
            panelImportDS.getPnlTableAndFieldAttributes().add(jtf);
            textFields.add(jtf);



        }
    }*/
}
