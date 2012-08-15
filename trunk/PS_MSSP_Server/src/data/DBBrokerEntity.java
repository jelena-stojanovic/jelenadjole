/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
public class DBBrokerEntity {

    private static DBBrokerEntity instance;
    private EntityManagerFactory emf;
    private EntityManager em;
    private static String porukaMetode;

    public static DBBrokerEntity getInstance() {
        if (instance == null) {
            return new DBBrokerEntity();
        }
        return instance;
    }

    private DBBrokerEntity() {
        emf = Persistence.createEntityManagerFactory("PS_MSSP_ServerPU");
    }

    public boolean vratiSveODO(List<OpstiDomenskiObjekat> odoList) {
        if(odoList==null){
            odoList = new ArrayList<OpstiDomenskiObjekat>();
        }
        String namedQuery = odoList.get(0).vratiImeKlase() + ".findAll";
        
        try {
            odoList = em.createNamedQuery(namedQuery).getResultList();
            porukaMetode = porukaMetode + "\n Uspesno vraćanje svih " + odoList.get(0).vratiNazivNovogObjekta() + "a iz baze.";
            //List<OpstiDomenskiObjekat> lista = em.createQuery("SELECT objd FROM "+tableName+" objd").getResultList();
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska u upitu. Neuspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + " iz baze.";
            return false;
        }
        
    }

    public boolean vratiODOpoUslovu(OpstiDomenskiObjekat odo) {
        String namedQuery = odo.vratiImeKlase() + ".findBy" + odo.vratiAtributPretrazivanja();

        try {
            OpstiDomenskiObjekat trazeni = (OpstiDomenskiObjekat) em.createNamedQuery(namedQuery).getSingleResult();
            trazeni.prekopirajVrednostiAtributa(odo);
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska u upitu. Neuspesno vraćanje " + odo.getClass().getSimpleName() + " iz baze.";
            return false;
        }
        return true;

        //OpstiDomenskiObjekat trazeniODO = em.find(odo.getClass(), odo.vratiAtributPretrazivanja());

        //return trazeniODO;

    }

    public boolean kreirajNovi(OpstiDomenskiObjekat odo) {
        try {
            System.out.println("Usao u kreiraj novi");
            em.persist(odo);
            System.out.println("Prosao persist");
            em.flush();
            System.out.println("Prosao flush");
            em.refresh(odo);
            System.out.println("Prosao refresh");
            System.out.println(odo.vratiID());
            porukaMetode = porukaMetode + "\n Uspesno kreiran " + odo.vratiNazivObjekta();
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska prilikom kreiranja " + odo.vratiNazivObjekta();
            return false;
        }
    }

    
    public boolean sacuvajODO(OpstiDomenskiObjekat odo) {
        try {
            em.persist(odo);
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Objekat " + odo.getClass().getSimpleName() + " nije sačuvan.";
            return false;
        }
    }

    public boolean obrisiODO(OpstiDomenskiObjekat d) {
        OpstiDomenskiObjekat resultODO = em.find(d.getClass(), d.vratiID());
        if (resultODO == null) {
            //em.getTransaction().rollback();
            porukaMetode = porukaMetode + "\n " + d.vratiImeKlase() + " nije pronadjen";
            return false;
        } else {
            em.remove(resultODO);
            porukaMetode = porukaMetode + "\n " + d.vratiImeKlase() + " uspešno izbrisan.";
            return true;
        }
    }

    public boolean izmeniODO(OpstiDomenskiObjekat d) {

        OpstiDomenskiObjekat resultODO = em.find(d.getClass(), d.vratiID());
        if (resultODO == null) {
            //em.getTransaction().rollback();
            porukaMetode = porukaMetode + "\n " + d.vratiImeKlase() + " nije pronadjen";
            return false;
        } else {
            d.prekopirajVrednostiAtributa(resultODO);
            return true;
        }
    }

    public boolean beginTransaction() {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            porukaMetode = porukaMetode + "\n Otvorena je baza.";
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska pri otvaranju baze.";
            return false;
        }
    }

    public boolean closeTransaction() {
        try {
            em.close();
            porukaMetode = porukaMetode + "\n Zatvorena je baza.";
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska pri zatvaranju baze.";
            return false;
        }
    }

    public boolean commitTransaction() {
        try {
            em.getTransaction().commit();
            porukaMetode = porukaMetode + "\n Commit transakcije.";
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska prilikom commit-a tramsakcije.";
            return false;
        }
    }

    public boolean rollbackTransaction() {
        try {
            em.getTransaction().rollback();
            porukaMetode = porukaMetode + "\n Rollback transakcije.";
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska prilikom rllback-a tramsakcije.";
            return false;
        }

    }

    
    // ***koristi se***//
    public String vratiPorukuMetode() {
        return porukaMetode;
    }

// ***koristi se***//
    public void isprazniPoruku() {
        porukaMetode = "";
    }

// ***koristi se***//
    public void dodajPorukuMetode(String poruka) {
        porukaMetode = "\n" + poruka + porukaMetode;
    }
}
