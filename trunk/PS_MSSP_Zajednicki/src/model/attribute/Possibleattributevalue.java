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
@Table(name = "possibleattributevalue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possibleattributevalue.findAll", query = "SELECT p FROM Possibleattributevalue p"),
    @NamedQuery(name = "Possibleattributevalue.findByIndexOfAttribute", query = "SELECT p FROM Possibleattributevalue p WHERE p.possibleattributevaluePK.indexOfAttribute = :indexOfAttribute"),
    @NamedQuery(name = "Possibleattributevalue.findByDatasetID", query = "SELECT p FROM Possibleattributevalue p WHERE p.possibleattributevaluePK.datasetID = :datasetID"),
    @NamedQuery(name = "Possibleattributevalue.findByIndexOfValue", query = "SELECT p FROM Possibleattributevalue p WHERE p.possibleattributevaluePK.indexOfValue = :indexOfValue"),
    @NamedQuery(name = "Possibleattributevalue.findByPossibleValue", query = "SELECT p FROM Possibleattributevalue p WHERE p.possibleValue = :possibleValue")})
public class Possibleattributevalue implements Serializable, OpstiDomenskiObjekat {
    
    
    @JoinColumns({
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false),    
    @JoinColumn(name = "indexOfAttribute", referencedColumnName = "indexOfAttribute", insertable = false, updatable = false)    
    })
    @ManyToOne(optional = false)
    private Nominalattribute nominalattribute;
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossibleattributevaluePK possibleattributevaluePK;
    @Basic(optional = false)
    @Column(name = "possibleValue")
    private String possibleValue;
    
    public Possibleattributevalue() {
    }

    public Possibleattributevalue(PossibleattributevaluePK possibleattributevaluePK) {
        this.possibleattributevaluePK = possibleattributevaluePK;
    }

    public Possibleattributevalue(PossibleattributevaluePK possibleattributevaluePK, String possibleValue) {
        this.possibleattributevaluePK = possibleattributevaluePK;
        this.possibleValue = possibleValue;
    }

    public Possibleattributevalue(int indexOfAttribute, int datasetID, double indexOfValue) {
        this.possibleattributevaluePK = new PossibleattributevaluePK(indexOfAttribute, datasetID, indexOfValue);
    }

    public PossibleattributevaluePK getPossibleattributevaluePK() {
        return possibleattributevaluePK;
    }

    public void setPossibleattributevaluePK(PossibleattributevaluePK possibleattributevaluePK) {
        this.possibleattributevaluePK = possibleattributevaluePK;
    }

    public String getPossibleValue() {
        return possibleValue;
    }

    public void setPossibleValue(String possibleValue) {
        this.possibleValue = possibleValue;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possibleattributevaluePK != null ? possibleattributevaluePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possibleattributevalue)) {
            return false;
        }
        Possibleattributevalue other = (Possibleattributevalue) object;
        if ((this.possibleattributevaluePK == null && other.possibleattributevaluePK != null) || (this.possibleattributevaluePK != null && !this.possibleattributevaluePK.equals(other.possibleattributevaluePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.attribute.Possibleattributevalue[ possibleattributevaluePK=" + possibleattributevaluePK + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "Possibleattributevalue";
    }

    @Override
    public String vratiNazivTabele() {
        return "possibleattributevalue";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Possibleattributevalue pav= (Possibleattributevalue)odo;
        pav.setNominalattribute(nominalattribute);
        pav.setPossibleValue(possibleValue);
        pav.setPossibleattributevaluePK(possibleattributevaluePK);
    }

    @Override
    public Object vratiID() {
        return possibleattributevaluePK;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "PossibleValue";
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new possibleattributevalue";
    }

    @Override
    public String vratiNazivObjekta() {
        return "possibleattributevalue";
    }

    public Nominalattribute getNominalattribute() {
        return nominalattribute;
    }

    public void setNominalattribute(Nominalattribute nominalattribute) {
        this.nominalattribute = nominalattribute;
    }
    
}
