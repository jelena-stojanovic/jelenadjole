/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.OpstiDomenskiObjekat;

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
public class OrdinalAttribute extends Attribute implements Serializable {

    public OrdinalAttribute() {
    }

    public OrdinalAttribute(AttributePK attributePK) {
        super(attributePK);
    }

    public OrdinalAttribute(int indexOfAttribute, int dataSetID) {
        super(indexOfAttribute, dataSetID);
    }
    

    
    @Override
    public boolean isNominal() {
        return false;
    }

    
    @Override
    public boolean isNumerical() {
         return false;
    }

    @Override
    public boolean isOrdinal() {
        return true;
    }

     @Override
    public boolean isInterval() {
        return false;
    }

    @Override
    public boolean isDate() {
        return false;
    }
    
//    @Override
//    public Object getPossibleValues() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    
//
//    @Override
//    public void setPossibleValues(Object object) {
//       throw new UnsupportedOperationException("Not supported yet.");
//    }

    
    @Override
    public String vratiImeKlase() {
        return "OrdinalAttribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "attribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        OrdinalAttribute oa= (OrdinalAttribute) odo;
        oa.setAttributePK(attributePK);
        oa.setAttributeRole(this.getAttributeRole());
        
    }

    @Override
    public Object vratiID() {
        return attributePK;
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
        return "new ordinal attribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "ordinal attribute";
    }


    
}
