/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.OpstiDomenskiObjekat;
import tools.KonverterTipova;

/**
 *
 * @author Jelena
 */
@Entity
//@Table(name = "source")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Source.findAll", query = "SELECT s FROM Source s"),
    @NamedQuery(name = "Source.findBySourceID", query = "SELECT s FROM Source s WHERE s.sourceID = :sourceID")})
public class Source implements OpstiDomenskiObjekat, Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "sourceID")
    private int sourceID;
    
    @Lob
    @Column(name = "creator")
    private String creator;
    
    @Lob
    @Column(name = "donor")
    private String donor;
    
    @Lob
    @Column(name = "sourceDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sourceDate;

    public Source() {
    }

    public Source(int sourceID, String creator, String donor, Date date) {
        this.sourceID = sourceID;
        this.creator = creator;
        this.donor = donor;
        this.sourceDate = date;
    }

    public Source(String creator, String donor, Date date) {
        this.creator = creator;
        this.donor = donor;
        this.sourceDate = date;
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
        return sourceDate;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.sourceDate = date;
    }

    @Override
    public String toString() {
        return  creator + ", " + donor + ", " + sourceDate ;
    }

    
    
    @Override
    public String vratiVrednostiAtributa() {
        java.sql.Date sqlDate = KonverterTipova.Konvertuj(sourceDate);
        return "" + sourceID + ", '" + creator + "', '" + donor + ", " + sqlDate;
    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date sqlDate = KonverterTipova.Konvertuj(sourceDate);
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
    public boolean Napuni(ResultSet RSslog) {
        try {
            sourceID = KonverterTipova.Konvertuj(RSslog, sourceID, "sourceID");
            creator = KonverterTipova.Konvertuj(RSslog, creator, "creator");
            donor = KonverterTipova.Konvertuj(RSslog, donor, "donor");
            sourceDate = KonverterTipova.Konvertuj(KonverterTipova.Konvertuj(RSslog, "date"));
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
        if (sourceDate.before(newDate)) {
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

    @Override
    public String vratiNazivTabele() {
        return "source";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        
        Source source = (Source) odo;
        source.setCreator(creator);
        source.setDonor(donor);
        source.setDate(sourceDate);
        
    }
@Override
    public int vratiID() {
        return sourceID;
    }

   private String atributPretrazivanja;
    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        atributPretrazivanja=atribut;
    }
    @Override
    public String vratiAtributPretrazivanja() {
        //return "dataSetID";
        return atributPretrazivanja;
    }    
    
}
