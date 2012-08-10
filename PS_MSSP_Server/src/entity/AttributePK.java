/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jelena
 */
@Embeddable
public class AttributePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "indexOfAttribute")
    private int indexOfAttribute;
    @Basic(optional = false)
    @Column(name = "dataSetID")
    private int dataSetID;

    public AttributePK() {
    }

    public AttributePK(int indexOfAttribute, int dataSetID) {
        this.indexOfAttribute = indexOfAttribute;
        this.dataSetID = dataSetID;
    }

    public int getIndexOfAttribute() {
        return indexOfAttribute;
    }

    public void setIndexOfAttribute(int indexOfAttribute) {
        this.indexOfAttribute = indexOfAttribute;
    }

    public int getDataSetID() {
        return dataSetID;
    }

    public void setDataSetID(int dataSetID) {
        this.dataSetID = dataSetID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) indexOfAttribute;
        hash += (int) dataSetID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributePK)) {
            return false;
        }
        AttributePK other = (AttributePK) object;
        if (this.indexOfAttribute != other.indexOfAttribute) {
            return false;
        }
        if (this.dataSetID != other.dataSetID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AttributePK[ indexOfAttribute=" + indexOfAttribute + ", dataSetID=" + dataSetID + " ]";
    }
    
}
