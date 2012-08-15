/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.OpstiDomenskiObjekat;

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
    @NamedQuery(name = "Datasetmetaattribute.findByMetaAttributeValue", query = "SELECT d FROM Datasetmetaattribute d WHERE d.metaAttributeValue = :metaAttributeValue")})
public class Datasetmetaattribute implements Serializable, OpstiDomenskiObjekat {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatasetmetaattributePK datasetmetaattributePK;
    @Column(name = "metaAttributeValue")
    private Double metaAttributeValue;
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

    public Double getValue() {
        return metaAttributeValue;
    }

    public void setValue(Double value) {
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

    @Override
    public String vratiImeKlase() {
        return "Datasetmetaattribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "datasetmetaattribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Datasetmetaattribute d = (Datasetmetaattribute) odo;
        d.setDatasetmetaattributePK(datasetmetaattributePK);
        d.setDataset(dataset);
        d.setDsmetaattribute(dsmetaattribute);
        d.setValue(metaAttributeValue);
    }

    @Override
    public int vratiID() {
        return datasetmetaattributePK.getDsmetaattributeID();
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "DsmetaattributeID";
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new dataset metaattribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "dataset metaattribute";
    }
}
