/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logic.ControllerAL_DSExport;
import model.dataFormat.CSVFormat;
import model.dataFormat.DataFormat;
import model.dataset.DataSet;
import view.panels.importDSpanel.PanelAllDataSets;
import view.panels.importDSpanel.PanelExportDS;
import view.panels.importDSpanel.PanelWelcome;
import view.panels.importDSpanel.model.TableModelDataSets;

/**
 *
 * @author Djordje
 */
public class ControllerUI_DSExport {

    ControllerAL_DSExport controllerAL_DSExport = ControllerAL_DSExport.getInstance();
    private PanelExportDS panelExportDS;
    CSVFormat cSVFormat = new CSVFormat();
    boolean saveCSV = false;
    boolean saveAML = false;
    boolean saveText = false;
    String fileName = null;
    String directoryPath = null;
    List<DataFormat> dataFormatList = new ArrayList<DataFormat>();
    /*
     * --local--
     */
    /*
     * ---- csv format fields -----
     */
    private File file = null;
    private DataSet dataset = null;
    private char columnSeparation = ',';
    private boolean writeAttributeNames = false;
    private boolean useQuotesForNominal = true;
    private String datePattern = null;
    /*
     * ----end of csv format fields -----
     */

    public ControllerUI_DSExport() {
    }

    public void saveFildValues() {
        columnSeparation = getSelectedColumnSeparator();
        writeAttributeNames = KonverterTipova.Konvertuj(getPanelExportDS().getCheckBUseFirstRow(), writeAttributeNames);
        useQuotesForNominal = KonverterTipova.Konvertuj(getPanelExportDS().getCheckBUseQuotes(), useQuotesForNominal);
        datePattern = KonverterTipova.Konvertuj(getPanelExportDS().getTxtFieldDateFormat(), datePattern);


        cSVFormat.setColumnSeparator(columnSeparation);
        cSVFormat.setUseFirstRowAsAttributeNames(writeAttributeNames);
        cSVFormat.setUseQuotesForNominal(useQuotesForNominal);
        cSVFormat.setDatePattern(datePattern);

        fileName = panelExportDS.getTxtFieldFileName().getText().trim();
//        panelExportDS.getFileChooserDS().get

        
        checkSaveTypes();
        setSelectedDataSet();
        setValuesToGUI();
    }

    public void lastStep() {
        directoryPath = panelExportDS.getFileChooserDS().getCurrentDirectory().getPath().trim();
        System.out.println(directoryPath);
        fileName = panelExportDS.getTxtFieldFileName().getText().trim();
        if (fileName == null || fileName.equals("")) {
            fileName = dataset.getTitle() + ".csv";
        }
        String filepath = directoryPath + "\\" + fileName;

        File dsFile = new File(filepath);
        System.out.println(dsFile);
        cSVFormat.setCsvFile(dsFile);

        saveFildValues();
        try {
            saveDataSet();
            JOptionPane.showMessageDialog(panelExportDS, "Data set has been successfully exported", "success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(ControllerUI_DSExport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        ControllerUI_Main.getInstance().setActivePanel(new PanelWelcome());
    }

    public void setValuesToGUI() {
        getSelectedRBColumnSeparator().setSelected(true);

        KonverterTipova.Konvertuj(writeAttributeNames, getPanelExportDS().getCheckBUseFirstRow());

        KonverterTipova.Konvertuj(useQuotesForNominal, getPanelExportDS().getCheckBUseQuotes());

//        if (file != null) {
//            fillTblDataSetPreprocessing();
//            fillTblDataTypes();
//        }
        fillTblDataPreview();
    }

    public void disableAllExcept(int numberOfPane) {
        for (int i = 0; i < 4; i++) {
            panelExportDS.getTpnlExportDS().setEnabledAt(i, false);
        }
        panelExportDS.getTpnlExportDS().setEnabledAt(numberOfPane, true);
        panelExportDS.getTpnlExportDS().setSelectedIndex(numberOfPane);
    }

    public JRadioButton getSelectedRBColumnSeparator() {
        char character = columnSeparation;
        if (character == ',') {
            return getPanelExportDS().getRbComma();
        } else if (character == ';') {
            return getPanelExportDS().getRbSemicolon();
        } else if (character == ' ') {
            return getPanelExportDS().getRbSpace();
        } else if (character == '\t') {
            return getPanelExportDS().getRbTab();
        }
        return getPanelExportDS().getRbComma();
    }

    private char getSelectedColumnSeparator() {
        char character = 0;
        ButtonGroup gbr = getPanelExportDS().getRbgColumnSeparator();
        for (Enumeration e = gbr.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == gbr.getSelection()) {
                String selectedAvatar = b.getText();
                if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(getPanelExportDS().getRbComma().getText())) {
                    character = ',';
                } else if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(getPanelExportDS().getRbSemicolon().getText())) {
                    character = ';';
                } else if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(getPanelExportDS().getRbSpace().getText())) {
                    character = ' ';
                } else if (selectedAvatar != null && selectedAvatar.equalsIgnoreCase(getPanelExportDS().getRbTab().getText())) {
                    character = '\t';
                }
            }
        }
        return character;
    }

    /**
     * @return the panelExportDS
     */
    public PanelExportDS getPanelExportDS() {
        return panelExportDS;
    }

    /**
     * @param panelExportDS the panelExportDS to set
     */
    public void setPanelExportDS(PanelExportDS panelExportDS) {
        this.panelExportDS = panelExportDS;

        for (int i = 0; i < 4; i++) {
            panelExportDS.getTpnlExportDS().setEnabledAt(i, false);
        }
        panelExportDS.getTpnlExportDS().setEnabledAt(0, true);
        panelExportDS.getTpnlExportDS().setSelectedIndex(0);
    }

    private void checkSaveTypes() {
        if (panelExportDS.getCheckBAML().isSelected()) {
            saveAML = true;
            //TODO .add(AMLFormat)
        }
        if (panelExportDS.getCheckBCSV().isSelected()) {
            saveCSV = true;
            dataFormatList.add(cSVFormat);
        }
        if (panelExportDS.getChechBText().isSelected()) {
            saveAML = true;
            //TODO .add(TextFormat)
        }
    }

    public void setSelectedDataSet() {
        if (panelExportDS.getPnlAllDataSets() != null) {
            int index = panelExportDS.getPanelAllDataSets().getTblDatasets().getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(panelExportDS,"You must select a data set to export");
                disableAllExcept(0);
                
            } else {
               dataset = ((TableModelDataSets) (panelExportDS.getPanelAllDataSets().getTblDatasets().getModel())).getDataSet(index);
            }
        }
    }

    public void saveDataSet() throws Exception {
        if (dataset != null) {
            for (DataFormat dataFormat : dataFormatList) {
                controllerAL_DSExport.exportDS(dataFormat, dataset);
            }
        }
    }

    public void fillTblDataPreview() {
        JTable table = panelExportDS.getTblDataSetPreprocessing();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        if (dataset != null) {
            String[] columIdentifiers = new String[dataset.getAttributes().size()];
            for (int i = 0; i < dataset.getAttributes().size(); i++) {
                columIdentifiers[i] = dataset.getAttributes().get(i).getName();
            }
            String[][] datasetMatrix = new String[dataset.getDataTable().getDoubleMatrix().length][dataset.getDataTable().getDoubleMatrix()[0].length];
            for (int i = 0; i < dataset.getDataTable().getDoubleMatrix().length; i++) {
                for (int j = 0; j < dataset.getDataTable().getDoubleMatrix()[i].length; j++) {
                    datasetMatrix[i][j] = String.valueOf(dataset.getDataTable().getDoubleMatrix()[i][j]);
                }
            }
            dtm.setDataVector(datasetMatrix, columIdentifiers);
        }
    }
}
