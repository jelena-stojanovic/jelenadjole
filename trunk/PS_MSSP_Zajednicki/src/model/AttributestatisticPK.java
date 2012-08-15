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
public class AttributestatisticPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "indexOfAttribute")
    private int indexOfAttribute;
    @Basic(optional = false)
    @Column(name = "dataSetID")
    private int dataSetID;
    @Basic(optional = false)
    @Column(name = "statisticID")
    private int statisticID;

    public AttributestatisticPK() {
    }

    public AttributestatisticPK(int indexOfAttribute, int dataSetID, int statisticID) {
        this.indexOfAttribute = indexOfAttribute;
        this.dataSetID = dataSetID;
        this.statisticID = statisticID;
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

    public int getStatisticID() {
        return statisticID;
    }

    public void setStatisticID(int statisticID) {
        this.statisticID = statisticID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) indexOfAttribute;
        hash += (int) dataSetID;
        hash += (int) statisticID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributestatisticPK)) {
            return false;
        }
        AttributestatisticPK other = (AttributestatisticPK) object;
        if (this.indexOfAttribute != other.indexOfAttribute) {
            return false;
        }
        if (this.dataSetID != other.dataSetID) {
            return false;
        }
        if (this.statisticID != other.statisticID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AttributestatisticPK[ indexOfAttribute=" + indexOfAttribute + ", dataSetID=" + dataSetID + ", statisticID=" + statisticID + " ]";
    }
    
}
