/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.Attributestatistic;
import model.OpstiDomenskiObjekat;
import model.Statistic;
import model.dataset.Dataset;

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
public class Attribute implements Serializable, OpstiDomenskiObjekat {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "attribute")
    private Numericalattribute numericalattribute;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "attribute")
    private Nominalattribute nominalattribute;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "attribute")
    private Dateattribute dateattribute;
    
    /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute1")
    private List<Attributestatistic> attributestatisticList1;
   */

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

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
//    private List<Possibleattributevalue> possibleattributevalueList;
//    
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
    private List<Attributestatistic> attributestatisticList;
    
    

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

    @XmlTransient
    public List<Attributestatistic> getAttributestatisticList() {
        return attributestatisticList;
    }

    public void setAttributestatisticList(List<Attributestatistic> attributestatisticList) {
        this.attributestatisticList = attributestatisticList;
    }
    
    public double getStatisticValue(String statisticName){
        for (int i = 0; i < attributestatisticList.size(); i++) {
            Attributestatistic get = attributestatisticList.get(i);
            if(get.getStatistic().getStatisticName().equals(statisticName)){
                return get.getStatisticValue();
            }
        }
        return Double.NaN;
    }
    
    
     public double getDataSetMetaAttributeValue(Statistic statistic){
        for (Attributestatistic attstat : attributestatisticList) {
            if(attstat.getStatistic().getStatisticID()==statistic.getStatisticID())
                return attstat.getStatisticValue();
        }
        return Double.NaN;
                
    }
    
    public void addAttributestatistic(Attributestatistic attStat) {
        attributestatisticList.add(attStat);
    }

//    @XmlTransient
//    public List<Attributestatistic> getAttributestatisticList1() {
//        return attributestatisticList1;
//    }
//
//    public void setAttributestatisticList1(List<Attributestatistic> attributestatisticList1) {
//        this.attributestatisticList1 = attributestatisticList1;
//    }
//    

//    @XmlTransient
//    public List<Possibleattributevalue> getPossibleattributevalueList() {
//        return possibleattributevalueList;
//    }
//
//    public void setPossibleattributevalueList(List<Possibleattributevalue> possibleattributevalueList) {
//        this.possibleattributevalueList = possibleattributevalueList;
//    }

//    public abstract boolean isNominal();
//    public abstract boolean isNumerical();
//    public abstract boolean isOrdinal();
//    public abstract boolean isInterval();
//    public abstract boolean isDate();

    /**
     * @return the numericalattribute
     */
    public Numericalattribute getNumericalattribute() {
        return numericalattribute;
    }

    /**
     * @param numericalattribute the numericalattribute to set
     */
    public void setNumericalattribute(Numericalattribute numericalattribute) {
        this.numericalattribute = numericalattribute;
    }

    /**
     * @return the nominalattribute
     */
    public Nominalattribute getNominalattribute() {
        return nominalattribute;
    }

    /**
     * @param nominalattribute the nominalattribute to set
     */
    public void setNominalattribute(Nominalattribute nominalattribute) {
        this.nominalattribute = nominalattribute;
    }

    /**
     * @return the dateattribute
     */
    public Dateattribute getDateattribute() {
        return dateattribute;
    }

    /**
     * @param dateattribute the dateattribute to set
     */
    public void setDateattribute(Dateattribute dateattribute) {
        this.dateattribute = dateattribute;
    }

    @Override
    public String vratiImeKlase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiNazivTabele() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object vratiID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiNazivNovogObjekta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiNazivObjekta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
    
}
