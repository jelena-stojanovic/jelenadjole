/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OpstiDomenskiObjekat;
import tools.KonverterTipova;

/**
 *
 * @author Jelena
 */
public class Source implements OpstiDomenskiObjekat {

    private int sourceID;
    private String creator;
    private String donor;
    private Date date;

    public Source() {
    }

    public Source(int sourceID, String creator, String donor, Date date) {
        this.sourceID = sourceID;
        this.creator = creator;
        this.donor = donor;
        this.date = date;
    }

    public Source(String creator, String donor, Date date) {
        this.creator = creator;
        this.donor = donor;
        this.date = date;
    }

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
        java.sql.Date sqlDate = KonverterTipova.Konvertuj(date);
        return "" + sourceID + ", '" + creator + "', '" + donor + ", " + sqlDate;
    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date sqlDate = KonverterTipova.Konvertuj(date);
        return "sourceID = " + sourceID + ", creator ='" + creator + "', donor ='" + donor + "', date = "
                + sqlDate;
    }

    @Override
    public String vratiImeKlase() {
        return "Source";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return " sourceID = '" + sourceID + "'";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "sourceID";
    }

    @Override
    public boolean Napuni(ResultSet RSslog) {
        try {
            sourceID = KonverterTipova.Konvertuj(RSslog, sourceID, "sourceID");
            creator = KonverterTipova.Konvertuj(RSslog, creator, "creator");
            donor = KonverterTipova.Konvertuj(RSslog, donor, "donor");
            date = KonverterTipova.Konvertuj(KonverterTipova.Konvertuj(RSslog, "date"));
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public int povecajBroj(ResultSet rs) {
        try {
            sourceID = KonverterTipova.Konvertuj(rs, sourceID, "sourceID");
            return ++sourceID;
        } catch (Exception e) {
            System.out.println("Izuzetak kod generisanja novog broja racuna: " + e);
            return 0;
        }
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
        return null;
    }

    @Override
    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return -1;
    }

    @Override
    public void postaviPocetniBroj() {
        sourceID = 1;
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
        return null;
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
        return -1;
    }

    @Override
    public boolean vrednosnaOgranicenja() {
        Date newDate = new Date();
        if (date.before(newDate)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Obradi() {
    }

    @Override
    public void Storniraj() {
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new source";
    }

    @Override
    public String vratiNazivObjekta() {
        return "source";
    }
}
