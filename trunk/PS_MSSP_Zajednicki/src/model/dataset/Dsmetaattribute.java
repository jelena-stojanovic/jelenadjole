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

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "dsmetaattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dsmetaattribute.findAll", query = "SELECT d FROM Dsmetaattribute d"),
    @NamedQuery(name = "Dsmetaattribute.findByDsmetaattributeID", query = "SELECT d FROM Dsmetaattribute d WHERE d.dsmetaattributeID = :dsmetaattributeID"),
    @NamedQuery(name = "Dsmetaattribute.findByDsmetaattributeName", query = "SELECT d FROM Dsmetaattribute d WHERE d.dsmetaattributeName = :dsmetaattributeName"),
    @NamedQuery(name = "Dsmetaattribute.findByDsmetaattributeDescription", query = "SELECT d FROM Dsmetaattribute d WHERE d.dsmetaattributeDescription = :dsmetaattributeDescription")})
public class Dsmetaattribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="seq", sequenceName="seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Column(name = "dsmetaattributeID")
    private Integer dsmetaattributeID;
   
    @Column(name = "dsmetaattributeName")
    private String dsmetaattributeName;
    
    @Column(name = "dsmetaattributeDescription")
    private String dsmetaattributeDescription;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dsmetaattribute")
    private List<Datasetmetaattribute> datasetmetaattributeList;
    
    
    @JoinColumn(name = "metadsID", referencedColumnName = "metadsID")
    @ManyToOne
    private Metads metadsID;

    public Dsmetaattribute() {
    }

    public Dsmetaattribute(Integer dsmetaattributeID) {
        this.dsmetaattributeID = dsmetaattributeID;
    }

    public Integer getDsmetaattributeID() {
        return dsmetaattributeID;
    }

    public void setDsmetaattributeID(Integer dsmetaattributeID) {
        this.dsmetaattributeID = dsmetaattributeID;
    }

    public String getDsmetaattributeName() {
        return dsmetaattributeName;
    }

    public void setDsmetaattributeName(String dsmetaattributeName) {
        this.dsmetaattributeName = dsmetaattributeName;
    }

    public String getDsmetaattributeDescription() {
        return dsmetaattributeDescription;
    }

    public void setDsmetaattributeDescription(String dsmetaattributeDescription) {
        this.dsmetaattributeDescription = dsmetaattributeDescription;
    }

    @XmlTransient
    public List<Datasetmetaattribute> getDatasetmetaattributeList() {
        return datasetmetaattributeList;
    }

    public void setDatasetmetaattributeList(List<Datasetmetaattribute> datasetmetaattributeList) {
        this.datasetmetaattributeList = datasetmetaattributeList;
    }

    public Metads getMetadsID() {
        return metadsID;
    }

    public void setMetadsID(Metads metadsID) {
        this.metadsID = metadsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dsmetaattributeID != null ? dsmetaattributeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dsmetaattribute)) {
            return false;
        }
        Dsmetaattribute other = (Dsmetaattribute) object;
        if ((this.dsmetaattributeID == null && other.dsmetaattributeID != null) || (this.dsmetaattributeID != null && !this.dsmetaattributeID.equals(other.dsmetaattributeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dsmetaattribute[ dsmetaattributeID=" + dsmetaattributeID + " ]";
    }
    
}
