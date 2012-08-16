/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "metads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metads.findAll", query = "SELECT m FROM Metads m"),
    @NamedQuery(name = "Metads.findByMetadsID", query = "SELECT m FROM Metads m WHERE m.metadsID = :metadsID")})
public class Metads implements Serializable, OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "metadsID")
    private Integer metadsID;
    
    @OneToMany(mappedBy = "metadsID")
    private List<Dataset> datasetList;
    
    @JoinColumn(name = "metadsID", referencedColumnName = "dataSetID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Dataset dataset;

    @OneToMany(mappedBy = "metadsID")
    private List<Dsmetaattribute> dsmetaattributeList;
    
    public Metads() {
    }

    public Metads(Integer metadsID) {
        this.metadsID = metadsID;
    }

    public Integer getMetadsID() {
        return metadsID;
    }

    public void setMetadsID(Integer metadsID) {
        this.metadsID = metadsID;
    }

    @XmlTransient
    public List<Dataset> getDatasetList() {
        return datasetList;
    }

    public void setDatasetList(List<Dataset> datasetList) {
        this.datasetList = datasetList;
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
        hash += (metadsID != null ? metadsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metads)) {
            return false;
        }
        Metads other = (Metads) object;
        if ((this.metadsID == null && other.metadsID != null) || (this.metadsID != null && !this.metadsID.equals(other.metadsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dataset.Metads[ metadsID=" + metadsID + " ]";
    }

    /**
     * @return the dsmetaattributeList
     */
    public List<Dsmetaattribute> getDsmetaattributeList() {
        return dsmetaattributeList;
    }

    /**
     * @param dsmetaattributeList the dsmetaattributeList to set
     */
    public void setDsmetaattributeList(List<Dsmetaattribute> dsmetaattributeList) {
        this.dsmetaattributeList = dsmetaattributeList;
    }

    @Override
    public String vratiImeKlase() {
        return "Metads";
    }

    @Override
    public String vratiNazivTabele() {
        return "metads";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Metads mds= (Metads) odo;
        mds.setDataset(dataset);
        mds.setDatasetList(datasetList);
        mds.setMetadsID(metadsID);
        mds.setDsmetaattributeList(dsmetaattributeList);
    }

    @Override
    public Object vratiID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new metads";
    }

    @Override
    public String vratiNazivObjekta() {
        return "metads";
    }
    
}
