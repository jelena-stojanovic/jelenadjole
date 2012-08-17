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
public class PossibleattributevaluePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "indexOfAttribute")
    private int indexOfAttribute;
    @Basic(optional = false)
    @Column(name = "datasetID")
    private int datasetID;
    @Basic(optional = false)
    @Column(name = "indexOfValue")
    private double indexOfValue;

    public PossibleattributevaluePK() {
    }

    public PossibleattributevaluePK(int indexOfAttribute, int datasetID, double indexOfValue) {
        this.indexOfAttribute = indexOfAttribute;
        this.datasetID = datasetID;
        this.indexOfValue = indexOfValue;
    }

    public int getIndexOfAttribute() {
        return indexOfAttribute;
    }

    public void setIndexOfAttribute(int indexOfAttribute) {
        this.indexOfAttribute = indexOfAttribute;
    }

    public int getDatasetID() {
        return datasetID;
    }

    public void setDatasetID(int datasetID) {
        this.datasetID = datasetID;
    }

    public double getIndexOfValue() {
        return indexOfValue;
    }

    public void setIndexOfValue(double indexOfValue) {
        this.indexOfValue = indexOfValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) indexOfAttribute;
        hash += (int) datasetID;
        hash += (int) indexOfValue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossibleattributevaluePK)) {
            return false;
        }
        PossibleattributevaluePK other = (PossibleattributevaluePK) object;
        if (this.indexOfAttribute != other.indexOfAttribute) {
            return false;
        }
        if (this.datasetID != other.datasetID) {
            return false;
        }
        if (this.indexOfValue != other.indexOfValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.attribute.PossibleattributevaluePK[ indexOfAttribute=" + indexOfAttribute + ", datasetID=" + datasetID + ", indexOfValue=" + indexOfValue + " ]";
    }
    
}
