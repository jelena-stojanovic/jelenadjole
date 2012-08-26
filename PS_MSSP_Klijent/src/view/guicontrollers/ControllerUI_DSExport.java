/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.guicontrollers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dataFormat.CSVFormat;
import model.dataFormat.DataFormat;
import model.dataset.Dataset;

import view.panels.PanelExportDS;
import view.panels.PanelWelcome;
import view.panels.tablemodels.TableModelDataSets;

/**
 *
 * @author Djordje
 */
public class ControllerUI_DSExport extends OpstiKontrolerKI{

    //ControllerAL_DSExport controllerAL_DSExport = ControllerAL_DSExport.getInstance();
    private PanelExportDS panelExportDS;
    CSVFormat cSVFormat = new CSVFormat();
    boolean saveCSV = false;
    boolean saveAML = false;
    boolean saveText = false;
    String fileName = null;
    String directoryPath = null;
    List<DataFormat> dataFormatList = new ArrayList<DataFormat>();
    ControllerUI_AllDataSets controllerUI_AllDataSets;
    /*
     * --local--
     */
    /*
     * ---- csv format fields -----
     */
    private File file = null;
    private Dataset dataset = null;
    private char columnSeparation = ',';
    private boolean writeAttributeNames = true;
    private boolean useQuotesForNominal = true;
    private String datePattern = "MM/dd/yyyy";
    
    /*
     * ----end of csv format fields -----
     */

//    public ControllerUI_DSExport() {
//    }

    public ControllerUI_DSExport() throws IOException {
        super();
    }

    public ControllerUI_DSExport(PanelExportDS panelExportDS) throws IOException {
        super();
        this.panelExportDS = panelExportDS;
        oef=panelExportDS;
        controllerUI_AllDataSets= new ControllerUI_AllDataSets(panelExportDS.getPanelAllDataSets());
    }
    

    public void saveFildValues() {

        cSVFormat.setUseFirstRowAsAttributeNames(writeAttributeNames);
        cSVFormat.setUseQuotesForNominal(useQuotesForNominal);
        cSVFormat.setDatePattern(datePattern);

        fileName = panelExportDS.getTxtFieldFileName().getText().trim();
//        panelExportDS.getFileChooserDS().get

        
        checkSaveTypes();
        setSelectedDataSet();
    }

    public void lastStep() {
        directoryPath = panelExportDS.getFileChooserDS().getSelectedFile().getPath();
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(panelExportDS, ex.getMessage(), "Data set export error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ControllerUI_DSExport.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        JOptionPane.showMessageDialog(panelExportDS, "Data set has been exported successfull! \n On path: "+filepath, "Export data set", JOptionPane.INFORMATION_MESSAGE);
        ControllerUI_Main.getInstance().setActivePanel(new PanelWelcome());
    }


    public void disableAllExcept(int numberOfPane) {
        for (int i = 0; i < 3; i++) {
            panelExportDS.getTpnlExportDS().setEnabledAt(i, false);
        }
        panelExportDS.getTpnlExportDS().setEnabledAt(numberOfPane, true);
        panelExportDS.getTpnlExportDS().setSelectedIndex(numberOfPane);
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
                SOExport(dataFormat);
                
            }
        }
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        
    }
}
