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
@Table(name = "metads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metads.findAll", query = "SELECT m FROM Metads m"),
    @NamedQuery(name = "Metads.findByMetadsID", query = "SELECT m FROM Metads m WHERE m.metadsID = :metadsID")})
public class Metads implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "metadsID")
    private Integer metadsID;
    
    
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

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @XmlTransient
    public List<Dsmetaattribute> getDsmetaattributeList() {
        return dsmetaattributeList;
    }

    public void setDsmetaattributeList(List<Dsmetaattribute> dsmetaattributeList) {
        this.dsmetaattributeList = dsmetaattributeList;
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
        return "entity.Metads[ metadsID=" + metadsID + " ]";
    }
    
}
