/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.attribute.Attribute;
import to.DataSetTO;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "dataset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataset.findAll", query = "SELECT d FROM Dataset d"),
    @NamedQuery(name = "Dataset.findByDataSetID", query = "SELECT d FROM Dataset d WHERE d.dataSetID = :dataSetID"),
    @NamedQuery(name = "Dataset.findByTitle", query = "SELECT d FROM Dataset d WHERE d.title = :title"),
    @NamedQuery(name = "Dataset.findByDsDescription", query = "SELECT d FROM Dataset d WHERE d.dsDescription = :dsDescription"),
    @NamedQuery(name = "Dataset.findByFilePath", query = "SELECT d FROM Dataset d WHERE d.filePath = :filePath")})
public class Dataset implements OpstiDomenskiObjekat, Serializable {

    @JoinColumn(name = "metadsID", referencedColumnName = "metadsID")
    @ManyToOne
    private Metads metadsID;
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Basic(optional = false)
    @Column(name = "dataSetID")
    private Integer dataSetID;
    @Column(name = "title")
    private String title;
    @Column(name = "dsDescription")
    private String dsDescription;
    @Column(name = "filePath")
    private String filePath;
    @JoinColumn(name = "source", referencedColumnName = "sourceID")
    @OneToOne
    private Source source;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
    private List<Attribute> attributeList = new ArrayList<Attribute>();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dataset")
    private Metads metads;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
    private List<Datasetmetaattribute> datasetmetaattributeList = new ArrayList<Datasetmetaattribute>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
    private List<Reference> referenceList = new ArrayList<Reference>();

    //private DataTable dataTable;
    public Dataset() {
    }

    public Dataset(Integer dataSetID) {
        this.dataSetID = dataSetID;
    }

    public Dataset(DataSetTO ds) {
        this.metadsID = ds.getMetads();
        this.dataSetID = ds.getDataSetID();
        this.title = ds.getTitle();
        this.dsDescription = ds.getDsDescription();
        this.filePath = ds.getFilePath();
        this.source = ds.getSource();
        this.metads = ds.getMetads();
        this.attributeList = ds.getAttributeList();
        this.datasetmetaattributeList = ds.getDatasetmetaattributeList();
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

    @XmlTransient
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

    @XmlTransient
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

    @XmlTransient
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
        if (!(object instanceof Dataset)) {
            return false;
        }
        Dataset other = (Dataset) object;
        if ((this.dataSetID == null && other.dataSetID != null) || (this.dataSetID != null && !this.dataSetID.equals(other.dataSetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dataset[ dataSetID=" + dataSetID + " ]";
    }

//    
//    /**
//     * @return the dataTable
//     */
//    public DataTable getDataTable() {
//        return dataTable;
//    }
//
//    /**
//     * @param dataTable the dataTable to set
//     */
//    public void setDataTable(DataTable dataTable) {
//        this.dataTable = dataTable;
//    }
//
//    @Override
//    public String vratiVrednostiAtributa() {
//       return  dataSetID + ", '" + title + "', '" +  dsDescription + "' ";
//    }
//
//    @Override
//    public String postaviVrednostiAtributa() {
//        return "dataSetID = "+ dataSetID + ", title ='" + title +
//           "', dsDescription ='" + dsDescription + "'";
//    }
    @Override
    public String vratiImeKlase() {
        return "Dataset";
    }

//    @Override
//    public String vratiUslovZaNadjiSlog() {
//        return "dataSetID = "+ dataSetID ;
//    }
//
//    @Override
//    public String vratiUslovZaNadjiSlogove() {
//        return "";
//    }
//
//    @Override
//    public boolean Napuni(ResultSet RSslog) {
//        try{
//        dataSetID= KonverterTipova.Konvertuj(RSslog, dataSetID, "dataSetID");
//        dsDescription=KonverterTipova.Konvertuj(RSslog, dsDescription,"dsDescription");
//        title= KonverterTipova.Konvertuj(RSslog, title, "title");
//        }catch(Exception e){
//            System.out.println(e);
//            return false;
//        }
//          return true;     
//    }
//
//    @Override
//    public int povecajBroj(ResultSet rs) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public int vratiBrojVezanihObjekata() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void postaviPocetniBroj() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public boolean vrednosnaOgranicenja() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void Obradi() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void Storniraj() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
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

//        ds.setDataTable(dataTable);
    }

    @Override
    public Object vratiID() {
        return dataSetID;
    }

    // private String atributPretrazivanja;
    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        //  atributPretrazivanja=atribut;
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "dataSetID";
        //return atributPretrazivanja;
    }

//    /***RAZLIKA***/
//    private DataTable dataTable;
    /**
     * @return the dataTable
     */
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

    public void instantiateLAZYrelationship() {
        if (this.metads != null && this.metadsID != null) {
            if (getAttributeList() != null) {
                getAttributeList().size();
            }
            if (getDatasetmetaattributeList() != null) {
                getDatasetmetaattributeList().size();
            }
            if (getMetads() != null) {
                getMetads().getDsmetaattributeList().size();
            }
            if (getReferenceList() != null) {
                getReferenceList().size();
            }
        }
    }

    public void createAllLazyEntityFields() {
    }
}
