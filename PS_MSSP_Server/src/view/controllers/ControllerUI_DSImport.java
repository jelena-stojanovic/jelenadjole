/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.*;
import logic.ControllerAL_DSImport;
import model.Reference;
import model.attribute.Attribute;
import model.attribute.AttributePK;
import model.dataFormat.CSVFormat;
import model.dataset.Dataset;
import model.dataset.Source;
import view.panels.importDSpanel.PanelImportDS;
import view.panels.importDSpanel.PanelWelcome;
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
    TableDataTypes tblDatatypes;
    ArrayList<Reference> references = new ArrayList<Reference>();
    /*
     * ---- csv format fields -----
     */
    File file = null;
    //boolean trimLines = false;
    // boolean skipComments = false;
    //char commentsChar = '#';
    char columnSeparation = ',';
    boolean useFirstROwAsAttributeName = false;
    boolean useQuotesForNominal = true;
    /*
     * ----end of csv format fields -----
     */

    public ControllerUI_DSImport() {
    }

//    public static ControllerUI_DSImport getInstance() {
//        return ControllerUI_DSImportHolder.INSTANCE;
//    }

    public void saveFildValues() {
//        trimLines = KonverterTipova.Konvertuj(panelImportDS.getCheckbTrimLines(), trimLines);
//        cSVFormat.setTrimLines(trimLines);
//
//        skipComments = KonverterTipova.Konvertuj(panelImportDS.getChexkBSkipComments(), skipComments);
//        cSVFormat.setSkipComments(skipComments);
//
//        commentsChar = panelImportDS.getTfCommentChar().getText().trim().charAt(0);
//        cSVFormat.setCommentCharacter(commentsChar);

        columnSeparation = getSelectedColumnSeparator();
        cSVFormat.setColumnSeparator(columnSeparation);

        useFirstROwAsAttributeName = KonverterTipova.Konvertuj(panelImportDS.getCheckBUseFirstRow(), useFirstROwAsAttributeName);
        cSVFormat.setUseFirstRowAsAttributeNames(useFirstROwAsAttributeName);

        useQuotesForNominal = KonverterTipova.Konvertuj(panelImportDS.getCheckBUseQuotes(), useQuotesForNominal);
        cSVFormat.setUseQuotesForNominal(useQuotesForNominal);

        setValuesToGUI();
    }

    public void addReference() {
        try {
            String author = null;
            author=KonverterTipova.Konvertuj(panelImportDS.getTfAuthors(), author);
            String title = null;
            title=KonverterTipova.Konvertuj(panelImportDS.getTfTitle(), title);
            String location = null;
            location=KonverterTipova.Konvertuj(panelImportDS.getTfLocation(), location);
            Date date = null;
            date= KonverterTipova.Konvertuj(panelImportDS.getTfDate(), date);
            String otherInformation = null;
            otherInformation=KonverterTipova.Konvertuj(panelImportDS.getTfOtherInformation(), otherInformation);
            Reference ref = new Reference(author, title, date, location, otherInformation);
            references.add(ref);
            DefaultListModel dlm = new DefaultListModel();
            for (Reference refer : references) {
                dlm.addElement(refer);
            }
            panelImportDS.getListReferences().setModel(dlm);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(panelImportDS, "Unesite datum u \"MM/dd/yyyy\"  formatu.");
            panelImportDS.getTfDate().setBorder(new EtchedBorder(Color.red, Color.black));
        }

    }

//    private static class ControllerUI_DSImportHolder {
//
//        private static final ControllerUI_DSImport INSTANCE = new ControllerUI_DSImport();
//    }

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
//        KonverterTipova.Konvertuj(trimLines, panelImportDS.getCheckbTrimLines());
//
//        KonverterTipova.Konvertuj(skipComments, panelImportDS.getChexkBSkipComments());
//
//        panelImportDS.getTfCommentChar().setText(String.valueOf(commentsChar));

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
            //if (tblDatatypes == null || ((TableModelDataTypes) tblDatatypes.getModel()).getAttributeName(0) == null) {

            //}
            String[][] matrix = new String[stringArrayList.size()][stringArrayList.get(0).length];
            matrix = controllerAL_DSImport.convert(stringArrayList, matrix);
            dtm.setDataVector(matrix, columnIdentifiers);
        } catch (IOException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillTblDataTypes() {
        if (columnIdentifiers != null) {
            if (tblDatatypes == null) {
                tblDatatypes = new TableDataTypes(panelImportDS.getPnlAttributeTypes(), panelImportDS.getjScrollPane3(), panelImportDS.getBtnPreviousDataTypes(), panelImportDS.getBtnFinish(), columnIdentifiers, stringArrayList);
                TableModelDataTypes tmdt = new TableModelDataTypes(stringArrayList, columnIdentifiers);
                tblDatatypes.setModel(tmdt);
            } else {
                TableModelDataTypes tmdt = (TableModelDataTypes) tblDatatypes.getModel();
                tmdt.setColumnIdentifiers(columnIdentifiers);
                tmdt.setArrayListString(stringArrayList);
            }
        }
    }

    
    private Dataset createDS() {

        Dataset ds = new Dataset();
        controllerAL_DSImport.creatNewODO(ds);
        TableModelDataTypes tmdt = (TableModelDataTypes) tblDatatypes.getModel();
        try {
            List<Attribute> attributes = AttributeFactory.createAttributes(ds,tmdt);
            ds.setAttributeList(attributes);

            String title = panelImportDS.getTfDataSetTitle().getText().trim();
            if (title == null|| title.equals("")) {
                title = file.getName().substring(0, file.getName().length() - 4);
            }
            
            ds.setTitle(title);

            String dsDescr=null;
            dsDescr=KonverterTipova.Konvertuj(panelImportDS.getTaDataSetDescription(), dsDescr);
            ds.setDsDescription(dsDescr);

            
            /*** REFERENCEs***/
            
            ds.setReferenceList(references);
            /***end CREATE REFERENCEs***/
            
            /*** SOURCE***/
            Source source = new Source();
            
            String creator=null;
            creator= KonverterTipova.Konvertuj(panelImportDS.getTfCreator(),creator );
            source.setCreator(creator);
            
            String donor=null;
            donor= KonverterTipova.Konvertuj(panelImportDS.getTfDonor(),donor );
            source.setDonor(donor);
            
            Date date = null;
            date= KonverterTipova.Konvertuj(panelImportDS.getTfDateDS(), date);
            source.setSourceDate(date);
            controllerAL_DSImport.creatNewODO(source);
            ds.setSource(source);
            /***end SOURCE***/
            
        } catch (InstantiationException ex) {
           JOptionPane.showMessageDialog(panelImportDS, "Attribute " + tmdt.getAttributeName(0) + "(mozda i ne prvi) couldn't be saved. " + ex);
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(panelImportDS, "E ovo ne bi trebalo da prodje :)");
        }
        return ds;
    }

    public void finish() {
        try {
            controllerAL_DSImport.createDataSet(createDS(),stringArrayList );
            JOptionPane.showMessageDialog(panelImportDS, "Data set has been successfully created!", "success", JOptionPane.INFORMATION_MESSAGE);
            ControllerUI_Main.getInstance().setActivePanel(new PanelWelcome());
        } catch (Exception ex) {
            Logger.getLogger(ControllerUI_DSImport.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
