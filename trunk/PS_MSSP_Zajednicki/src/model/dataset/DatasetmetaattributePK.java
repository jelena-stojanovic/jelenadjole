/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jelena
 */
@Embeddable
public class DatasetmetaattributePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "dataSetID")
    private int dataSetID;
    @Basic(optional = false)
    @Column(name = "dsmetaattributeID")
    private int dsmetaattributeID;

    public DatasetmetaattributePK() {
    }

    public DatasetmetaattributePK(int dataSetID, int dsmetaattributeID) {
        this.dataSetID = dataSetID;
        this.dsmetaattributeID = dsmetaattributeID;
    }

    public int getDataSetID() {
        return dataSetID;
    }

    public void setDataSetID(int dataSetID) {
        this.dataSetID = dataSetID;
    }

    public int getDsmetaattributeID() {
        return dsmetaattributeID;
    }

    public void setDsmetaattributeID(int dsmetaattributeID) {
        this.dsmetaattributeID = dsmetaattributeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataSetID;
        hash += (int) dsmetaattributeID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatasetmetaattributePK)) {
            return false;
        }
        DatasetmetaattributePK other = (DatasetmetaattributePK) object;
        if (this.dataSetID != other.dataSetID) {
            return false;
        }
        if (this.dsmetaattributeID != other.dsmetaattributeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DatasetmetaattributePK[ dataSetID=" + dataSetID + ", dsmetaattributeID=" + dsmetaattributeID + " ]";
    }
    
}
