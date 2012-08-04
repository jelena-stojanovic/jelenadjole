/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.sql.ResultSet;
import java.util.Date;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
public class Source implements OpstiDomenskiObjekat{
    
    private int sourceID;
    private String creator;
    private String donor;
    private Date date;
    
    

    /**
     * @return the sourceID
     */
    public int getSourceID() {
        return sourceID;
    }

    /**
     * @param sourceID the sourceID to set
     */
    public void setSourceID(int sourceID) {
        this.sourceID = sourceID;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the donor
     */
    public String getDonor() {
        return donor;
    }

    /**
     * @param donor the donor to set
     */
    public void setDonor(String donor) {
        this.donor = donor;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiImeKlase() {
        return "Source";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "sourceID";
    }

    @Override
    public boolean Napuni(ResultSet RSslog) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int povecajBroj(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postaviPocetniBroj() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean vrednosnaOgranicenja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Obradi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Storniraj() {
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
