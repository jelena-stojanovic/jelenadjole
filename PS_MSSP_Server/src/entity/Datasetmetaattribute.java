/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "datasetmetaattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datasetmetaattribute.findAll", query = "SELECT d FROM Datasetmetaattribute d"),
    @NamedQuery(name = "Datasetmetaattribute.findByDataSetID", query = "SELECT d FROM Datasetmetaattribute d WHERE d.datasetmetaattributePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Datasetmetaattribute.findByDsmetaattributeID", query = "SELECT d FROM Datasetmetaattribute d WHERE d.datasetmetaattributePK.dsmetaattributeID = :dsmetaattributeID"),
    @NamedQuery(name = "Datasetmetaattribute.findByValue", query = "SELECT d FROM Datasetmetaattribute d WHERE d.value = :value")})
public class Datasetmetaattribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatasetmetaattributePK datasetmetaattributePK;
    
    @Column(name = "metaAttributeValue")
    private Integer metaAttributeValue;
    
    
    @JoinColumn(name = "dsmetaattributeID", referencedColumnName = "dsmetaattributeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dsmetaattribute dsmetaattribute;
    
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dataset dataset;

    public Datasetmetaattribute() {
    }

    public Datasetmetaattribute(DatasetmetaattributePK datasetmetaattributePK) {
        this.datasetmetaattributePK = datasetmetaattributePK;
    }

    public Datasetmetaattribute(int dataSetID, int dsmetaattributeID) {
        this.datasetmetaattributePK = new DatasetmetaattributePK(dataSetID, dsmetaattributeID);
    }

    public DatasetmetaattributePK getDatasetmetaattributePK() {
        return datasetmetaattributePK;
    }

    public void setDatasetmetaattributePK(DatasetmetaattributePK datasetmetaattributePK) {
        this.datasetmetaattributePK = datasetmetaattributePK;
    }

    public Integer getValue() {
        return metaAttributeValue;
    }

    public void setValue(Integer value) {
        this.metaAttributeValue = value;
    }

    public Dsmetaattribute getDsmetaattribute() {
        return dsmetaattribute;
    }

    public void setDsmetaattribute(Dsmetaattribute dsmetaattribute) {
        this.dsmetaattribute = dsmetaattribute;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datasetmetaattributePK != null ? datasetmetaattributePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datasetmetaattribute)) {
            return false;
        }
        Datasetmetaattribute other = (Datasetmetaattribute) object;
        if ((this.datasetmetaattributePK == null && other.datasetmetaattributePK != null) || (this.datasetmetaattributePK != null && !this.datasetmetaattributePK.equals(other.datasetmetaattributePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Datasetmetaattribute[ datasetmetaattributePK=" + datasetmetaattributePK + " ]";
    }
    
}
