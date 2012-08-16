/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attribute;

import java.io.Serializable;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
public class OrdinalAttribute extends Attribute implements Serializable {

    public OrdinalAttribute() {
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
    
    @Override
    public Object getPossibleValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    @Override
    public void setPossibleValues(Object object) {
       throw new UnsupportedOperationException("Not supported yet.");
    }

    
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
