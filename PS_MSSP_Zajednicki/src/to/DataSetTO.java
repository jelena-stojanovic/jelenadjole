/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.attribute.Attribute;
import model.attribute.Possibleattributevalue;
import model.dataset.*;

/**
 *
 * @author Jelena
 */
public class DataSetTO implements OpstiDomenskiObjekat, Serializable {

    private Metads metadsID;
    private static final long serialVersionUID = 1L;
    private Integer dataSetID;
    private String title;
    private String dsDescription;
    private String filePath;
    private Source source;
    private List<Attribute> attributeList = new ArrayList<Attribute>();
    private Metads metads;
    private List<Datasetmetaattribute> datasetmetaattributeList = new ArrayList<Datasetmetaattribute>();
    private List<Reference> referenceList = new ArrayList<Reference>();

    //private DataTable dataTable;
    public DataSetTO() {
    }

    public DataSetTO(Metads metadsID, Integer dataSetID, String title, String dsDescription, String filePath, Source source, Metads metads) {
        this.metadsID = metadsID;
        this.dataSetID = dataSetID;
        this.title = title;
        this.dsDescription = dsDescription;
        this.filePath = filePath;
        this.source = source;
        this.metads = metads;
    }

    public DataSetTO(Integer dataSetID) {
        this.dataSetID = dataSetID;
    }

    public DataSetTO(Dataset ds) {
        this.metadsID = ds.getMetads();
        this.dataSetID = ds.getDataSetID();
        this.title = ds.getTitle();
        this.dsDescription = ds.getDsDescription();
        this.filePath = ds.getFilePath();
        this.source = ds.getSource();
        this.metads = ds.getMetads();
        ds.getAttributeList().size();
        this.attributeList = ds.getAttributeList();
        for (int i = 0; i < ds.getAttributeList().size(); i++) {
            Attribute attribute = ds.getAttributeList().get(i);
           
            attribute.getPossibleattributevalueList().size();;
            this.attributeList.get(i).setPossibleattributevalueList(attribute.getPossibleattributevalueList());
            
            attribute.getAttributestatisticList().size();
            this.attributeList.get(i).setAttributestatisticList(attribute.getAttributestatisticList());
        }
        
        ds.getDatasetmetaattributeList().size();
        this.datasetmetaattributeList = ds.getDatasetmetaattributeList();
        ds.getReferenceList().size();
        this.referenceList = ds.getReferenceList();

    }

    public Integer getDataSetID() {
        return dataSetID;
    }

    public void setDataSetID(Integer dataSetID) {
        this.dataSetID = dataSetID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDsDescription() {
        return dsDescription;
    }

    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public Metads getMetads() {
        return metads;
    }

    public void setMetads(Metads metads) {
        this.metads = metads;
    }

    public List<Datasetmetaattribute> getDatasetmetaattributeList() {
        return datasetmetaattributeList;
    }

    public void setDatasetmetaattributeList(List<Datasetmetaattribute> datasetmetaattributeList) {
        this.datasetmetaattributeList = datasetmetaattributeList;
    }

    public double getDataSetMetaAttributeValue(Dsmetaattribute dsma) {
        for (Datasetmetaattribute datasetmetaattribute : datasetmetaattributeList) {
            if (datasetmetaattribute.getDsmetaattribute().getDsmetaattributeID() == dsma.getDsmetaattributeID()) {
                return datasetmetaattribute.getValue();
            }
        }
        return Double.NaN;

    }

    public void addDatasetmetaattribute(Datasetmetaattribute datasetmetaattribute) {
        datasetmetaattributeList.add(datasetmetaattribute);
    }

    public List<Reference> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(List<Reference> referenceList) {
        this.referenceList = referenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataSetID != null ? dataSetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataSetTO)) {
            return false;
        }
        DataSetTO other = (DataSetTO) object;
        if ((this.dataSetID == null && other.dataSetID != null) || (this.dataSetID != null && !this.dataSetID.equals(other.dataSetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dataset[ dataSetID=" + dataSetID + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "Dataset";
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new dataset";
    }

    @Override
    public String vratiNazivObjekta() {
        return "dataset";
    }

    public static String[] vratiZaglavlje() {
        String[] s = new String[3];
        s[0] = "Data set ID";
        s[1] = "Title";
        s[2] = "Description";

        return s;
    }

    static Class[] vratiTipove() {
        return new Class[]{Integer.class, String.class, String.class};
    }

    static Object[] vratiPocetneVrednosti() {
        Object[] obj = new Object[3];
        obj[0] = new Integer(0);
        obj[1] = "";
        obj[2] = "";

        return obj;
    }

    public Object[] vratiVrednostiPolja() {
        Object[] o = new Object[3];
        o[0] = dataSetID;
        o[1] = title;
        o[2] = dsDescription;

        return o;
    }

    @Override
    public String vratiNazivTabele() {
        return "dataset";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Dataset ds = (Dataset) odo;
        ds.setTitle(this.title);
        ds.setAttributeList(attributeList);

        ds.setDsDescription(this.dsDescription);
        ds.setFilePath(this.filePath);
        ds.setSource(this.source);
        ds.setMetads(this.metads);
        ds.setMetadsID(this.metadsID);
        ds.setDatasetmetaattributeList(this.datasetmetaattributeList);
        ds.setReferenceList(this.referenceList);
        ds.setDataSetID(this.dataSetID);

    }

    @Override
    public Object vratiID() {
        return dataSetID;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "dataSetID";
    }

    public DataTable getDataTable() {
        DataTable dataTable = null;
        try {
            dataTable = deserializeDT();

        } catch (IOException ex) {
            Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataTable;
    }

    public void setDataTable(DataTable dt) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath + ".dt"));
            oos.writeObject(dt);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DataTable deserializeDT() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath + ".dt"));
        DataTable dt = (DataTable) ois.readObject();
        return dt;
    }

    /**
     * @return the metadsID
     */
    public Metads getMetadsID() {
        return metadsID;
    }

    /**
     * @param metadsID the metadsID to set
     */
    public void setMetadsID(Metads metadsID) {
        this.metadsID = metadsID;
    }

    public void writeObject(ObjectOutputStream oos) throws IOException {
        attributeList.size();
        datasetmetaattributeList.size();
        metads.getDsmetaattributeList().size();
        referenceList.size();

        oos.defaultWriteObject();
    }
//    public void instantiateLAZYrelationship() {
//        if (this.metads != null && this.metadsID != null) {
//            if (getAttributeList() != null) {
//                getAttributeList().size();
//            }
//            if (getDatasetmetaattributeList() != null) {
//                getDatasetmetaattributeList().size();
//            }
//            if (getMetads() != null) {
//                getMetads().getDsmetaattributeList().size();
//            }
//            if (getReferenceList() != null) {
//                getReferenceList().size();
//            }
//        }
//    }
//
//    public void createAllLazyEntityFields() {
//    }
}
