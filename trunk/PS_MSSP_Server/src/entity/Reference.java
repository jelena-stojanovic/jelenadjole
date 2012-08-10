/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r"),
    @NamedQuery(name = "Reference.findByReferenceID", query = "SELECT r FROM Reference r WHERE r.referencePK.referenceID = :referenceID"),
    @NamedQuery(name = "Reference.findByDataSetID", query = "SELECT r FROM Reference r WHERE r.referencePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Reference.findByAuthor", query = "SELECT r FROM Reference r WHERE r.author = :author"),
    @NamedQuery(name = "Reference.findByTitle", query = "SELECT r FROM Reference r WHERE r.title = :title"),
    @NamedQuery(name = "Reference.findByReferenceDate", query = "SELECT r FROM Reference r WHERE r.referenceDate = :referenceDate"),
    @NamedQuery(name = "Reference.findByLocation", query = "SELECT r FROM Reference r WHERE r.location = :location"),
    @NamedQuery(name = "Reference.findByOtherInformation", query = "SELECT r FROM Reference r WHERE r.otherInformation = :otherInformation")})
public class Reference implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReferencePK referencePK;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "referenceDate")
    @Temporal(TemporalType.DATE)
    private Date referenceDate;
    @Column(name = "location")
    private String location;
    @Column(name = "otherInformation")
    private String otherInformation;
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dataset dataset;

    public Reference() {
    }

    public Reference(ReferencePK referencePK) {
        this.referencePK = referencePK;
    }

    public Reference(int referenceID, int dataSetID) {
        this.referencePK = new ReferencePK(referenceID, dataSetID);
    }

    public ReferencePK getReferencePK() {
        return referencePK;
    }

    public void setReferencePK(ReferencePK referencePK) {
        this.referencePK = referencePK;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
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
        hash += (referencePK != null ? referencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.referencePK == null && other.referencePK != null) || (this.referencePK != null && !this.referencePK.equals(other.referencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reference[ referencePK=" + referencePK + " ]";
    }
    
}
