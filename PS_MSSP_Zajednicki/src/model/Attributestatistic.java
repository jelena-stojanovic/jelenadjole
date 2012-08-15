/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.attribute.Attribute;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "attributestatistic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributestatistic.findAll", query = "SELECT a FROM Attributestatistic a"),
    @NamedQuery(name = "Attributestatistic.findByIndexOfAttribute", query = "SELECT a FROM Attributestatistic a WHERE a.attributestatisticPK.indexOfAttribute = :indexOfAttribute"),
    @NamedQuery(name = "Attributestatistic.findByDataSetID", query = "SELECT a FROM Attributestatistic a WHERE a.attributestatisticPK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Attributestatistic.findByStatisticID", query = "SELECT a FROM Attributestatistic a WHERE a.attributestatisticPK.statisticID = :statisticID"),
    @NamedQuery(name = "Attributestatistic.findByStatisticValue", query = "SELECT a FROM Attributestatistic a WHERE a.statisticValue = :statisticValue")})
public class Attributestatistic implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttributestatisticPK attributestatisticPK;
    @Basic(optional = false)
    @Column(name = "statisticValue")
    private double statisticValue;
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute;
    @JoinColumn(name = "indexOfAttribute", referencedColumnName = "indexOfAttribute", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute1;
    @JoinColumn(name = "statisticID", referencedColumnName = "statisticID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Statistic statistic;

    public Attributestatistic() {
    }

    public Attributestatistic(AttributestatisticPK attributestatisticPK) {
        this.attributestatisticPK = attributestatisticPK;
    }

    public Attributestatistic(AttributestatisticPK attributestatisticPK, double statisticValue) {
        this.attributestatisticPK = attributestatisticPK;
        this.statisticValue = statisticValue;
    }

    public Attributestatistic(int indexOfAttribute, int dataSetID, int statisticID) {
        this.attributestatisticPK = new AttributestatisticPK(indexOfAttribute, dataSetID, statisticID);
    }

    public AttributestatisticPK getAttributestatisticPK() {
        return attributestatisticPK;
    }

    public void setAttributestatisticPK(AttributestatisticPK attributestatisticPK) {
        this.attributestatisticPK = attributestatisticPK;
    }

    public double getStatisticValue() {
        return statisticValue;
    }

    public void setStatisticValue(double statisticValue) {
        this.statisticValue = statisticValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Attribute getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(Attribute attribute1) {
        this.attribute1 = attribute1;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributestatisticPK != null ? attributestatisticPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attributestatistic)) {
            return false;
        }
        Attributestatistic other = (Attributestatistic) object;
        if ((this.attributestatisticPK == null && other.attributestatisticPK != null) || (this.attributestatisticPK != null && !this.attributestatisticPK.equals(other.attributestatisticPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Attributestatistic[ attributestatisticPK=" + attributestatisticPK + " ]";
    }
    
}
