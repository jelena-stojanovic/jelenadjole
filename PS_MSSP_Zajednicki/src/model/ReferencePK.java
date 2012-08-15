/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jelena
 */
@Embeddable
public class ReferencePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "referenceID")
    private int referenceID;
    @Basic(optional = false)
    @Column(name = "dataSetID")
    private int dataSetID;

    public ReferencePK() {
    }

    public ReferencePK(int referenceID, int dataSetID) {
        this.referenceID = referenceID;
        this.dataSetID = dataSetID;
    }

    public int getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
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
        hash += (int) referenceID;
        hash += (int) dataSetID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferencePK)) {
            return false;
        }
        ReferencePK other = (ReferencePK) object;
        if (this.referenceID != other.referenceID) {
            return false;
        }
        if (this.dataSetID != other.dataSetID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReferencePK[ referenceID=" + referenceID + ", dataSetID=" + dataSetID + " ]";
    }
    
}
