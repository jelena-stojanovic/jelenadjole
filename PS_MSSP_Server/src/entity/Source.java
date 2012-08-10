/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "source")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Source.findAll", query = "SELECT s FROM Source s"),
    @NamedQuery(name = "Source.findBySourceID", query = "SELECT s FROM Source s WHERE s.sourceID = :sourceID"),
    @NamedQuery(name = "Source.findByCreator", query = "SELECT s FROM Source s WHERE s.creator = :creator"),
    @NamedQuery(name = "Source.findByDonor", query = "SELECT s FROM Source s WHERE s.donor = :donor"),
    @NamedQuery(name = "Source.findBySourceDate", query = "SELECT s FROM Source s WHERE s.sourceDate = :sourceDate")})
public class Source implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sourceID")
    private Integer sourceID;
    @Column(name = "creator")
    private String creator;
    @Column(name = "donor")
    private String donor;
    @Column(name = "sourceDate")
    @Temporal(TemporalType.DATE)
    private Date sourceDate;
    @OneToMany(mappedBy = "source")
    private List<Dataset> datasetList;

    public Source() {
    }

    public Source(Integer sourceID) {
        this.sourceID = sourceID;
    }

    public Integer getSourceID() {
        return sourceID;
    }

    public void setSourceID(Integer sourceID) {
        this.sourceID = sourceID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public Date getSourceDate() {
        return sourceDate;
    }

    public void setSourceDate(Date sourceDate) {
        this.sourceDate = sourceDate;
    }

    @XmlTransient
    public List<Dataset> getDatasetList() {
        return datasetList;
    }

    public void setDatasetList(List<Dataset> datasetList) {
        this.datasetList = datasetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sourceID != null ? sourceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Source)) {
            return false;
        }
        Source other = (Source) object;
        if ((this.sourceID == null && other.sourceID != null) || (this.sourceID != null && !this.sourceID.equals(other.sourceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Source[ sourceID=" + sourceID + " ]";
    }
    
}
