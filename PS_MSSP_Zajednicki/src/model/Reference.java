/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r"),
    @NamedQuery(name = "Reference.findByReferenceID", query = "SELECT r FROM Reference r WHERE r.referencePK.referenceID = :referenceID"),
    @NamedQuery(name = "Reference.findByDataSetID", query = "SELECT r FROM Reference r WHERE r.referencePK.dataSetID = :dataSetID"),
    @NamedQuery(name = "Reference.findByAuthor", query = "SELECT r FROM Reference r WHERE r.author = :author"),
    @NamedQuery(name = "Reference.findByTitle", query = "SELECT r FROM Reference r WHERE r.title = :title"),
    @NamedQuery(name = "Reference.findByReferenceDate", query = "SELECT r FROM Reference r WHERE r.referenceDate = :referenceDate"),
    @NamedQuery(name = "Reference.findByLocation", query = "SELECT r FROM Reference r WHERE r.location = :location"),
    @NamedQuery(name = "Reference.findByOtherInformation", query = "SELECT r FROM Reference r WHERE r.otherInformation = :otherInformation")})
public class Reference implements OpstiDomenskiObjekat  , Serializable {
   private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReferencePK referencePK;
    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "referenceDate")
    @Temporal(TemporalType.DATE)
    private Date referenceDate;
    @Column(name = "location")
    private String location;
    @Column(name = "otherInformation")
    private String otherInformation;
    @JoinColumn(name = "dataSetID", referencedColumnName = "dataSetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dataset dataset;

    public Reference() {
    }

    public Reference(ReferencePK referencePK) {
        this.referencePK = referencePK;
    }

    public Reference(int referenceID, int dataSetID) {
        this.referencePK = new ReferencePK(referenceID, dataSetID);
    }

    public ReferencePK getReferencePK() {
        return referencePK;
    }

    public void setReferencePK(ReferencePK referencePK) {
        this.referencePK = referencePK;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
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
        hash += (referencePK != null ? referencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.referencePK == null && other.referencePK != null) || (this.referencePK != null && !this.referencePK.equals(other.referencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   author + "; " + title + "; " + referenceDate + "; " + location + ". " + otherInformation;
    }

    
    
    
    public Reference(String author, String title, Date date, String location, String otherInformation) {
        this.author = author;
        this.title = title;
        this.referenceDate = date;
        this.location = location;
        this.otherInformation = otherInformation;
    }

   
  
//    @Override
//    public String vratiVrednostiAtributa() {
//        java.sql.Date sqlDate = KonverterTipova.Konvertuj(referenceDate);
//        return "" + referencePK + ", '" + author + "', '" + title + "', " + sqlDate + ", '" + location + "', '" + otherInformation + "'";
//    }
//
//    @Override
//    public String postaviVrednostiAtributa() {
//        java.sql.Date sqlDate = KonverterTipova.Konvertuj(referenceDate);
//        return "reference ID = " + referenceID + ",author = '" + author + "', title ='" + title + "', date = "
//                + sqlDate + ", location = '" + location + "', otherInformation = '" + otherInformation + "'";
//    }
//
    @Override
    public String vratiImeKlase() {
        return "Reference";
    }
//
//    @Override
//    public String vratiUslovZaNadjiSlog() {
//        return " referenceID = '" + referenceID + "'";
//    }
//
//    @Override
//    public String vratiUslovZaNadjiSlogove() {
//        return "";
//    }

    @Override
    public String vratiAtributPretrazivanja() {
        //return "referenceID";
        return "ReferenceID";
    }

//    @Override
//    public boolean Napuni(ResultSet RSslog) {
//        try {
//            referenceID = KonverterTipova.Konvertuj(RSslog, referenceID, "referenceID");
//            author = KonverterTipova.Konvertuj(RSslog, author, "author");
//            title = KonverterTipova.Konvertuj(RSslog, title, "title");
//            referenceDate = KonverterTipova.Konvertuj(KonverterTipova.Konvertuj(RSslog, "date"));
//            location = KonverterTipova.Konvertuj(RSslog, location, "location");
//            otherInformation = KonverterTipova.Konvertuj(RSslog, otherInformation, "otherInformation");
//        } catch (Exception e) {
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int povecajBroj(ResultSet rs) {
//        try {
//            referenceID = KonverterTipova.Konvertuj(rs, referenceID, "referenceID");
//            return ++referenceID;
//        } catch (Exception e) {
//            System.out.println("Izuzetak kod generisanja novog broja racuna: " + e);
//            return 0;
//        }
//    }
//
//    @Override
//    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta) {
//        return null;
//    }
//
//    @Override
//    public void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta) {
//    }
//
//    @Override
//    public void kreirajVezaniObjekat(int brojStavkiVezanogObjekta, int brojVezanogObjekta) {
//    }
//
//    @Override
//    public int vratiBrojVezanihObjekata() {
//        return -1;
//    }
//
//    @Override
//    public void postaviPocetniBroj() {
//        referenceID = 1;
//    }
//
//    @Override
//    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta, int brojSloga) {
//        return null;
//    }
//
//    @Override
//    public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta) {
//        return -1;
//    }
//
//    @Override
//    public boolean vrednosnaOgranicenja() {
//        Date newDate = new Date();
//        if (referenceDate.before(newDate) && referenceID>=0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public void Obradi() {
//    }
//
//    @Override
//    public void Storniraj() {
//    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "new reference";
    }

    @Override
    public String vratiNazivObjekta() {
        return "reference";
    }

    @Override
    public String vratiNazivTabele() {
        return "reference";
    }

    @Override
    public void prekopirajVrednostiAtributa(OpstiDomenskiObjekat odo) {
        Reference ref = (Reference)odo;
        ref.setTitle(title) ;
        ref.setReferenceDate(referenceDate);
        ref.setLocation(location);
        ref.setOtherInformation(otherInformation);
        ref.setAuthor(author);
        ref.setDataset(dataset);
        ref.setReferencePK(referencePK);
        

    }

    @Override
    public Object vratiID() {
        return referencePK;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {

    }

    
    
}
