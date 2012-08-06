/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import tools.KonverterTipova;

/**
 *
 * @author Jelena
 */
public class Reference implements OpstiDomenskiObjekat {

    private int referenceID;
    private String author;
    private String title;
    private Date date;
    private String location;
    private String otherInformation;

    public Reference() {
    }

    public Reference(String author, String title, Date date, String location, String otherInformation) {
        this.author = author;
        this.title = title;
        this.date = date;
        this.location = location;
        this.otherInformation = otherInformation;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the otherInformation
     */
    public String getOtherInformation() {
        return otherInformation;
    }

    /**
     * @param otherInformation the otherInformation to set
     */
    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    @Override
    public String toString() {
        return  author + "; " + title + "; " + date + "; " + location + ". " + otherInformation ;
    }
    

    @Override
    public String vratiVrednostiAtributa() {
        java.sql.Date sqlDate = KonverterTipova.Konvertuj(date);
        return "" + referenceID + ", '" + author + "', '" + title + "', " + sqlDate + ", '" + location + "', '" + otherInformation + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date sqlDate = KonverterTipova.Konvertuj(date);
        return "reference ID = " + referenceID + ",author = '" + author + "', title ='" + title + "', date = "
                + sqlDate + ", location = '" + location + "', otherInformation = '" + otherInformation + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Reference";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return " referenceID = '" + referenceID + "'";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "referenceID";
    }

    @Override
    public boolean Napuni(ResultSet RSslog) {
        try {
            referenceID = KonverterTipova.Konvertuj(RSslog, referenceID, "referenceID");
            author = KonverterTipova.Konvertuj(RSslog, author, "author");
            title = KonverterTipova.Konvertuj(RSslog, title, "title");
            date = KonverterTipova.Konvertuj(KonverterTipova.Konvertuj(RSslog, "date"));
            location = KonverterTipova.Konvertuj(RSslog, location, "location");
            otherInformation = KonverterTipova.Konvertuj(RSslog, otherInformation, "otherInformation");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public int povecajBroj(ResultSet rs) {
        try {
            referenceID = KonverterTipova.Konvertuj(rs, referenceID, "referenceID");
            return ++referenceID;
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
        referenceID = 1;
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
        return "new reference";
    }

    @Override
    public String vratiNazivObjekta() {
        return "reference";
    }
}
