/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.OpstiDomenskiObjekat;
import model.statistics.Maximum;
import model.statistics.Minimum;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "dateattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dateattribute.findAll", query = "SELECT d FROM Dateattribute d"),
    @NamedQuery(name = "Dateattribute.findByDataSetID", query = "SELECT d FROM Dateattribute d WHERE d.dateattributePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Dateattribute.findByIndexOfAttribute", query = "SELECT d FROM Dateattribute d WHERE d.dateattributePK.indexOfAttribute = :indexOfAttribute"),
    @NamedQuery(name = "Dateattribute.findByDatePattern", query = "SELECT d FROM Dateattribute d WHERE d.datePattern = :datePattern")})
public class Dateattribute  implements Serializable, OpstiDomenskiObjekat {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DateattributePK dateattributePK;
    @Basic(optional = false)
    @Column(name = "datePattern")
    private String datePattern;
    @JoinColumns({
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false),    
    @JoinColumn(name = "indexOfAttribute", referencedColumnName = "indexOfAttribute", insertable = false, updatable = false)    
    })
    @OneToOne(optional = false)
    private Attribute attribute;
    

    public Dateattribute() {
    }

    public Dateattribute(DateattributePK dateattributePK) {
        this.dateattributePK = dateattributePK;
    }

    public Dateattribute(DateattributePK dateattributePK, String datePattern) {
        this.dateattributePK = dateattributePK;
        this.datePattern = datePattern;
    }

    public Dateattribute(int dataSetID, int indexOfAttribute) {
        this.dateattributePK = new DateattributePK(dataSetID, indexOfAttribute);
    }

    public DateattributePK getDateattributePK() {
        return dateattributePK;
    }

    public void setDateattributePK(DateattributePK dateattributePK) {
        this.dateattributePK = dateattributePK;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
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
        hash += (dateattributePK != null ? dateattributePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dateattribute)) {
            return false;
        }
        Dateattribute other = (Dateattribute) object;
        if ((this.dateattributePK == null && other.dateattributePK != null) || (this.dateattributePK != null && !this.dateattributePK.equals(other.dateattributePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.attribute.Dateattribute[ dateattributePK=" + dateattributePK + " ]";
    }
    
    
    
    
        
    public boolean isNominal() {
       return false;
    }

    
    public boolean isNumerical() {
        return false;
    }

    
    public boolean isOrdinal() {
        return false;
    }

    
    public boolean isInterval() {
        return false;
    }

   
    public boolean isDate() {
        return true;
    }

    
    public Object getPossibleValues() {
        double minValue=attribute.getStatisticValue(Minimum.class.getSimpleName());
        double maxValue=attribute.getStatisticValue(Maximum.class.getSimpleName());
            return "["+getDateFromDouble(minValue)+" - " +getDateFromDouble(maxValue)  +"]";
    }

    
    public Date getDateFromDouble(double d){
        Long time= Math.round(d);
        Date date= new Date(time);
        return date;
    }

    
    @Override
    public String vratiImeKlase() {
        return "DateAttribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "attribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Dateattribute da= (Dateattribute) odo;
        da.setDateattributePK(dateattributePK);
        da.setAttribute(attribute);
        da.setDatePattern(datePattern);
    }

    @Override
    public Object vratiID() {
        return dateattributePK;
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
        return "new date attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "date attribute";
    }

    
    
}
