/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "numericalattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numericalattribute.findAll", query = "SELECT n FROM Numericalattribute n"),
    @NamedQuery(name = "Numericalattribute.findByDataSetID", query = "SELECT n FROM Numericalattribute n WHERE n.numericalattributePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Numericalattribute.findByIndexOfAttribute", query = "SELECT n FROM Numericalattribute n WHERE n.numericalattributePK.indexOfAttribute = :indexOfAttribute"),
    @NamedQuery(name = "Numericalattribute.findByMinValue", query = "SELECT n FROM Numericalattribute n WHERE n.minValue = :minValue"),
    @NamedQuery(name = "Numericalattribute.findByMaxValue", query = "SELECT n FROM Numericalattribute n WHERE n.maxValue = :maxValue")})
public class Numericalattribute implements Serializable, OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumericalattributePK numericalattributePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "minValue")
    private Double minValue;
    @Column(name = "maxValue")
    private Double maxValue;
    
    @JoinColumns({
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false),    
    @JoinColumn(name = "indexOfAttribute", referencedColumnName = "indexOfAttribute", insertable = false, updatable = false)    
    })
    @OneToOne(optional = false)
    private Attribute attribute;
    
    public Numericalattribute() {
    }

    public Numericalattribute(NumericalattributePK numericalattributePK) {
        this.numericalattributePK = numericalattributePK;
    }

    public Numericalattribute(int dataSetID, int indexOfAttribute) {
        this.numericalattributePK = new NumericalattributePK(dataSetID, indexOfAttribute);
    }

    public NumericalattributePK getNumericalattributePK() {
        return numericalattributePK;
    }

    public void setNumericalattributePK(NumericalattributePK numericalattributePK) {
        this.numericalattributePK = numericalattributePK;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numericalattributePK != null ? numericalattributePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Numericalattribute)) {
            return false;
        }
        Numericalattribute other = (Numericalattribute) object;
        if ((this.numericalattributePK == null && other.numericalattributePK != null) || (this.numericalattributePK != null && !this.numericalattributePK.equals(other.numericalattributePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.attribute.Numericalattribute[ numericalattributePK=" + numericalattributePK + " ]";
    }
    

    
    
    
    
    
    public boolean isNominal() {
         return false;
    }

    
    public boolean isNumerical() {
         return true;
    }

    
    public boolean isOrdinal() {
         return false;
    }

    public Object getPossibleValues() {
//        double minValue=0;
//        double maxValue=0;
//            
//        for (int i = 0; i < getAttributestatisticList().size(); i++) {
//            Attributestatistic as = getAttributestatisticList().get(i);
//            if(as.getStatistic().getStatisticName().equals("Minimum"))
//                minValue=as.getStatisticValue();
//            if(as.getStatistic().getStatisticName().equals("Maximum"))
//                maxValue=as.getStatisticValue();
//        }
            
            return "["+minValue+" - " +maxValue +"]";
        
    }

    
    public boolean isInterval() {
        return false;
    }

    
    public boolean isDate() {
        return false;
    }

  

    @Override
    public String vratiImeKlase() {
        return "NumericalAttribute";
    }


    @Override
    public String vratiNazivTabele() {
        return "attribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Numericalattribute na= (Numericalattribute) odo;
        na.setNumericalattributePK(numericalattributePK);
        na.setMaxValue(maxValue);
        na.setMinValue(minValue);
        
    }

    @Override
    public Object vratiID() {
        return numericalattributePK;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "IndexOfAttribute";
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new numerical attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "numerical attribute";
    }





}
