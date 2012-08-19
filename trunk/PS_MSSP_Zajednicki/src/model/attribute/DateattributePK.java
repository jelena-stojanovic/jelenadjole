/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jelena
 */
@Embeddable
public class DateattributePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "dataSetID")
    private int dataSetID;
    @Basic(optional = false)
    @Column(name = "indexOfAttribute")
    private int indexOfAttribute;

    public DateattributePK() {
    }

    public DateattributePK(int dataSetID, int indexOfAttribute) {
        this.dataSetID = dataSetID;
        this.indexOfAttribute = indexOfAttribute;
    }

    public int getDataSetID() {
        return dataSetID;
    }

    public void setDataSetID(int dataSetID) {
        this.dataSetID = dataSetID;
    }

    public int getIndexOfAttribute() {
        return indexOfAttribute;
    }

    public void setIndexOfAttribute(int indexOfAttribute) {
        this.indexOfAttribute = indexOfAttribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataSetID;
        hash += (int) indexOfAttribute;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DateattributePK)) {
            return false;
        }
        DateattributePK other = (DateattributePK) object;
        if (this.dataSetID != other.dataSetID) {
            return false;
        }
        if (this.indexOfAttribute != other.indexOfAttribute) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.attribute.DateattributePK[ dataSetID=" + dataSetID + ", indexOfAttribute=" + indexOfAttribute + " ]";
    }
    
}
