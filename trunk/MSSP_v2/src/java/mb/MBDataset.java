/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import model.attribute.Ontology;
import model.dataFormat.CSVFormat;
import model.dataset.Dataset;
import model.dataset.Source;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import to.DataSetTO;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "mbdataset")
@SessionScoped
public class MBDataset implements Serializable {

    Dataset selectedds;
    List<Dataset> allDatasets = new ArrayList<Dataset>();
    Dataset exportds;
    Dataset[] selecteddatasets;
    private StreamedContent file;
    Dataset newdataset;
    CSVFormat importcsv = new CSVFormat();

    /**
     * Creates a new instance of MBDataset
     */
    public MBDataset() {
        //    selectedds=new Dataset();
        newdataset = new Dataset();
        newdataset.setSource(new Source());
        importcsv = new CSVFormat();
        importcsv.setUseFirstRowAsAttributeNames(false);
        columnIdentifiers = new String[1];
        columnIdentifiers[0] = "File has not been uploaded yet.";
    }

    public Dataset getSelectedds() {
        return selectedds;
    }

    public void setSelectedds(Dataset selectedds) {
        this.selectedds = selectedds;
    }

    public Dataset[] getSelecteddatasets() {
        return selecteddatasets;
    }

    public void setSelecteddatasets(Dataset[] selecteddatasets) {
        this.selecteddatasets = selecteddatasets;
    }

    public void setAllDatasets(List<Dataset> allDatasets) {
        this.allDatasets = allDatasets;
    }

    public List<Dataset> getAllDatasets() {
        allDatasets = getDss();
        return allDatasets;

    }

    public Dataset getExportds() {
        return exportds;
    }

    public void setExportds(Dataset exportds) {
        this.exportds = exportds;
    }

    public Dataset getNewdataset() {
        return newdataset;
    }

    public void setNewdataset(Dataset newdataset) {
        this.newdataset = newdataset;
    }

    public List<Dataset> getDssTO() {
        List<Dataset> dslist = new ArrayList<Dataset>();
        List<DataSetTO> dslistTO = CallEJB.getInstance().getSBdataset().getAllDatasetsTO();
        for (DataSetTO dsto : dslistTO) {
            dslist.add(new Dataset(dsto));
        }
        return dslist;
    }

    public List<Dataset> getDss() {
        List<Dataset> dslist = CallEJB.getInstance().getSBdataset().getAllDatasets();
        return dslist;
    }

    public String update() {
        if (selectedds == null || (selectedds != null && selectedds.getTitle() == null)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have to select one dataset."));
        }
        return "./updateDataset.xhtml";
    }

    public String updateDataset() {
        if (selectedds != null && selectedds.getTitle() != null) {
            CallEJB.getInstance().getSBdataset().updateDataset(selectedds);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dataset " + selectedds.getTitle() + " has been successfully updated! :)"));
            selectedds = new Dataset();
        }

        return "./indexAdmin.xhtml";

    }

    public StreamedContent getFile() {

        if (exportds != null) {
            String filePath = exportds.getFilePath();
            File fileE = new File((filePath + ".csv"));
            if (!fileE.exists()) {
                CSVFormat csv = new CSVFormat();
                csv.setCsvFile(new File((filePath + ".csv")));
                CallEJB.getInstance().getSBdataset().exportDS(exportds, csv);
            }
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MBDataset.class.getName()).log(Level.SEVERE, null, ex);
            }

            file = new DefaultStreamedContent(fis, "csv", (exportds.getTitle() + ".csv"));
        }
//        else {
//            InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/images/optimusprime.jpg");
//            file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
//        }
        return file;
    }
    private UploadedFile importfile;
    String[] columnIdentifiers;
    String[] attributeType;
    String[] attributeRole;
    ArrayList<String[]> stringArrayList = new ArrayList<String[]>();

    public String[] getAttributeRole() {
        return attributeRole;
    }

    public String[] getAttributeType() {
        return attributeType;
    }

    public void setAttributeRole(String[] attributeRole) {
        this.attributeRole = attributeRole;
    }

    public void setAttributeType(String[] attributeType) {
        this.attributeType = attributeType;
    }

    public String[] getColumnIdentifiers() {
        return columnIdentifiers;
    }

    public ArrayList<String[]> getStringArrayList() {
        return stringArrayList;
    }

    public void setColumnIdentifiers(String[] columnIdentifiers) {
        this.columnIdentifiers = columnIdentifiers;
    }

    public void setStringArrayList(ArrayList<String[]> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    public UploadedFile getImportfile() {
        return importfile;
    }

    public void setImportfile(UploadedFile importfile) {
        File fileimp = (File) importfile;
        System.err.println("File je null, ne postavlja ga uopste.");
        System.out.println(fileimp);
        importcsv.setCsvFile(fileimp);
        this.importfile = importfile;
    }

    public void upload() {
        if (importfile != null) {
            FacesMessage msg = new FacesMessage("Succesful ", importfile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            System.out.println("File je različit od null");
        } else {
            System.err.println("File je null");
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("File", event.getFile().getFileName() + " is uploaded successfully.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("Null ili...:" + event.getFile().getFileName() + "?");
        importfile = event.getFile();
        try {
            stringArrayList = readCSV(importfile, ',');

        } catch (IOException ex) {
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unsuccesfull reading!", "Reading file was unsuddessfull.");
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        }

    }

    public void setImportcsv(CSVFormat importcsv) {
        this.importcsv = importcsv;
    }

    public CSVFormat getImportcsv() {
        return importcsv;
    }

    public void updatedsTable() {
        //if (stringArrayList.isEmpty()) {
            try {
                stringArrayList = readCSV(importfile, importcsv.getColumnSeparator());
            } catch (IOException ex) {
                Logger.getLogger(MBDataset.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        //}
        if (importcsv.isUseFirstRowAsAttributeNames()) {
            columnIdentifiers = stringArrayList.get(0);
            stringArrayList.remove(0);
        } else {
            columnIdentifiers = new String[stringArrayList.get(0).length];
            for (int i = 0; i < columnIdentifiers.length; i++) {
                columnIdentifiers[i] = "Att" + (i + 1);
            }
        }
        updateColumns();
        setDataTypeAndRole();


    }
    private List<ColumnModel> columns = new ArrayList<ColumnModel>();

    public List<ColumnModel> getColumns() {
        return columns;
    }
    ArrayList<String[]> metaAttributes = new ArrayList<String[]>();

    public ArrayList<String[]> getMetaAttributes() {
        return metaAttributes;
    }

    public void setMetaAttributes(ArrayList<String[]> metaAttributes) {
        this.metaAttributes = metaAttributes;
    }

    private void setDataTypeAndRole() {
        if(attributeRole==null||attributeType==null){
                attributeRole = new String[columnIdentifiers.length];
                attributeType = new String[columnIdentifiers.length];
        }
        for (int i = 0; i < columnIdentifiers.length; i++) {
            if (attributeRole[i] == null) {
                attributeRole[i] = "Attribute";
            }
            if (attributeType[i] == null) {

                String value = stringArrayList.get(1)[i];
                String value1 = stringArrayList.get(stringArrayList.size() - 1)[i];
                int index = Math.round((stringArrayList.size() - 1) / 2);
                String value3 = stringArrayList.get(index)[i];

                String guessed = guessValueType(value);
                String guessed2 = guessValueType(value1);
                String guessed3 = guessValueType(value3);
                String guessedReal = Ontology.NOMINAL_ATTRIBUTE;
                if (guessed.equals(guessed2) && guessed.equals(guessed3)) {
                    guessedReal = guessed;
                }
                attributeType[i] = guessedReal;
            }
        }
        if (metaAttributes.size() >= 3) {
            metaAttributes = new ArrayList<String[]>();
        }
        metaAttributes.add(0, columnIdentifiers);
        metaAttributes.add(1, attributeRole);
        metaAttributes.add(2, attributeType);
    }

    public ArrayList<String> getAttributeRoleList() {
        return Ontology.getAttributeRoles();
    }

    public ArrayList<String> getAttributeTypeList() {
        return Ontology.getAttributeTypesS();
    }

    public String savedsInfo() {

        System.out.println("Sacuvane informacije valjda");
        System.out.println(newdataset.getTitle());
       
        
        createDS();
        FacesMessage msg = new FacesMessage("Data set has been successfully created.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return "./indexAdmin.xhtml";
        
    }

    public String saveDS() {
        System.out.println("Sacuv ds");

        for (int i = 0; i < metaAttributes.size(); i++) {
            String[] bla = metaAttributes.get(i);
            for (int j = 0; j < bla.length; j++) {
                String string = bla[j];
                System.out.println(string);
            }
        }
        createDS();
        
        System.out.println(newdataset.getTitle());
        return "./indexAdmin.xhtml";
    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }

    public void updateColumns() {
        UIComponent table = FacesContext.getCurrentInstance().getViewRoot().findComponent(":formParse:atts");
        table.setValueExpression("sortBy", null);
        createDynamicColumns();
    }

    public void createDynamicColumns() {
        String[] columnKeys = columnIdentifiers;
        columns.clear();

        for (String columnKey : columnKeys) {
            columns.add(new ColumnModel(columnKey, columnKey));
        }
    }

    public void onEdit(RowEditEvent event) {
        if (event.getObject() != null) {
            System.out.println("niz je:");
            String[] niz = (String[]) event.getObject();
            for (int i = 0; i < niz.length; i++) {
                String string = niz[i];
                System.out.println(string);
            }

            FacesMessage msg = new FacesMessage("Row Edited", String.valueOf((String[]) event.getObject()));
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg1 = new FacesMessage("Row not edited", String.valueOf(event.getObject()));
            FacesContext.getCurrentInstance().addMessage(null, msg1);
        }
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Cancelled", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public ArrayList<String[]> readCSV(UploadedFile upl, char columnSeparator) throws IOException {
        if (upl == null) {
            return new ArrayList<String[]>();
        }
        BufferedReader bufRdr = new BufferedReader(new InputStreamReader(upl.getInputstream()));
        String line = null;
        ArrayList<String[]> datasetList = new ArrayList<String[]>();
        System.out.println("Pocinje citanje fajla");
        while ((line = bufRdr.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, String.valueOf(columnSeparator));
            int size = st.countTokens();
            String[] lineInDataset = new String[size];

            for (int i = 0; i < size; i++) {
                lineInDataset[i] = st.nextToken();
            }
            datasetList.add(lineInDataset);
        }
        bufRdr.close();
        System.out.println("Zavrsio citanje fajla");
        return datasetList;
    }

    public String guessValueType(String value) {
        try {
            Double.parseDouble(value);
            return Ontology.NUMERICAL_ATTRIBUTE;
        } catch (NumberFormatException ex) {
            if (value.contains("<") || value.contains(">") || value.contains("=")) {
                return Ontology.INTERVAL_ATTRIBUTE;
            } else if (value.contains("/") || value.contains("-") || value.contains(".")) {
                return Ontology.DATE_ATTRIBUTE;
            } else {
                return Ontology.NOMINAL_ATTRIBUTE;
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        private void createDS() {

            CallEJB.getInstance().getSBdataset().saveDataset(newdataset, metaAttributes,stringArrayList);
        }

}
