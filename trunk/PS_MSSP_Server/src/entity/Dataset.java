/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
public class Dataset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private Source source;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
    private List<Attribute> attributeList;
    
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dataset")
    private Metads metads;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
    private List<Datasetmetaattribute> datasetmetaattributeList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
    private List<Reference> referenceList;

    public Dataset() {
    }

    public Dataset(Integer dataSetID) {
        this.dataSetID = dataSetID;
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
    
}
