/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logic.ControllerAL_DSImport;
import model.attribute.Attribute;
import model.dataFormat.CSVFormat;
import view.panels.importDSpanel.PanelImportDS;

/**
 *
 * @author Jelena
 */
public class ControllerUI_DSImport {

    KonverterTipova converter;
    ControllerAL_DSImport controllerAL_DSImport = ControllerAL_DSImport.getInstance();
    PanelImportDS panelImportDS;
    CSVFormat cSVFormat = new CSVFormat();
    String[] columnIdentifiers = null;
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

            ArrayList<String[]> stringArrayList = new ArrayList<String[]>();
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

    public void createAttributes(String[] columnIdentifiers) {

        List<Attribute> attributes = new ArrayList<Attribute>();
        for (int i = 0; i < columnIdentifiers.length; i++) {
            String string = columnIdentifiers[i];
            //       attributes.add(new Attribute() {});

        }
    }
}
