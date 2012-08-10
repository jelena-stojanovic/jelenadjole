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
@Table(name = "attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
    @NamedQuery(name = "Attribute.findByIndexOfAttribute", query = "SELECT a FROM Attribute a WHERE a.attributePK.indexOfAttribute = :indexOfAttribute"),
    @NamedQuery(name = "Attribute.findByDataSetID", query = "SELECT a FROM Attribute a WHERE a.attributePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Attribute.findByName", query = "SELECT a FROM Attribute a WHERE a.name = :name"),
    @NamedQuery(name = "Attribute.findByDescription", query = "SELECT a FROM Attribute a WHERE a.description = :description"),
    @NamedQuery(name = "Attribute.findByMissingValues", query = "SELECT a FROM Attribute a WHERE a.missingValues = :missingValues"),
    @NamedQuery(name = "Attribute.findByAttributeRole", query = "SELECT a FROM Attribute a WHERE a.attributeRole = :attributeRole")})
public class Attribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttributePK attributePK;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "missingValues")
    private Integer missingValues;
    @Column(name = "attributeRole")
    private String attributeRole;
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dataset dataset;

    public Attribute() {
    }

    public Attribute(AttributePK attributePK) {
        this.attributePK = attributePK;
    }

    public Attribute(int indexOfAttribute, int dataSetID) {
        this.attributePK = new AttributePK(indexOfAttribute, dataSetID);
    }

    public AttributePK getAttributePK() {
        return attributePK;
    }

    public void setAttributePK(AttributePK attributePK) {
        this.attributePK = attributePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMissingValues() {
        return missingValues;
    }

    public void setMissingValues(Integer missingValues) {
        this.missingValues = missingValues;
    }

    public String getAttributeRole() {
        return attributeRole;
    }

    public void setAttributeRole(String attributeRole) {
        this.attributeRole = attributeRole;
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
        hash += (attributePK != null ? attributePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute other = (Attribute) object;
        if ((this.attributePK == null && other.attributePK != null) || (this.attributePK != null && !this.attributePK.equals(other.attributePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Attribute[ attributePK=" + attributePK + " ]";
    }
    
}
