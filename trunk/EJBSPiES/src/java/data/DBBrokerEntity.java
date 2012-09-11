/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import model.OpstiDomenskiObjekat;
import model.dataset.Dataset;
import model.dataset.Source;

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
        emf = Persistence.createEntityManagerFactory("PS_MSSP_ZajednickiPU");
    }

    public List<OpstiDomenskiObjekat> vratiSveODO(List<OpstiDomenskiObjekat> odoList) {
        if (odoList == null) {
            odoList = new ArrayList<OpstiDomenskiObjekat>();
        }
        String namedQuery = odoList.get(0).vratiImeKlase() + ".findAll";
        try {
            odoList = em.createNamedQuery(namedQuery).getResultList();

            porukaMetode = porukaMetode + "\n Uspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + "a iz baze.";
            //List<OpstiDomenskiObjekat> lista = em.createQuery("SELECT objd FROM "+tableName+" objd").getResultList();
            //return true;
            return odoList;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska u upitu. Neuspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + " iz baze.";
            return null;
            //return false;
        }

    }

    public boolean vratiODOpoUslovu(OpstiDomenskiObjekat odo) {
        //String namedQuery = odo.vratiImeKlase() + ".findBy" + odo.vratiAtributPretrazivanja();


        try {
            //  OpstiDomenskiObjekat trazeni = (OpstiDomenskiObjekat) em.createNamedQuery(namedQuery).getSingleResult();
            OpstiDomenskiObjekat resultODO = em.find(odo.getClass(), odo.vratiID());
            resultODO.prekopirajVrednostiAtributa(odo);
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska u upitu. Neuspesno vraćanje " + odo.getClass().getSimpleName() + " iz baze.";
            Logger.getLogger(DBBrokerEntity.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;



    }

    public List<OpstiDomenskiObjekat> vratiODOpoUslovu(OpstiDomenskiObjekat odo, HashMap<String, Object> mapFieldValue) {
        String query = "SELECT objd FROM " + odo.vratiImeKlase() + " objd where ";
        //Query createQuery = em.createQuery("SELECT objd FROM "+odo.vratiImeKlase()+" objd where ");

        for (Map.Entry<String, Object> entry : mapFieldValue.entrySet()) {
            query += "objd.";
            String string = entry.getKey();
            Object object = entry.getValue();
            query += string + "='" + object + "' AND ";


            //  createQuery = createQuery.setParameter(string, object);
        }
        String newq = query.substring(0, query.length() - 4);
        newq += ";";
        System.out.println(newq);
        try {
            //List<OpstiDomenskiObjekat> lista = createQuery.getResultList();
            List<OpstiDomenskiObjekat> lista = em.createQuery(newq).getResultList();


            return lista;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Greska u upitu. Neuspesno vraćanje " + odo.getClass().getSimpleName() + "po uslovu iz baze.";
            Logger.getLogger(DBBrokerEntity.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }




    }

    public boolean kreirajNovi(OpstiDomenskiObjekat odo) {
        try {
            System.out.println("Usao u kreiraj novi");
            em.persist(odo);
            System.out.println("Prosao persist");
            if (odo instanceof Dataset || odo instanceof Source) {
                em.flush();
                System.out.println("Prosao flush");
                em.refresh(odo);
                System.out.println("Prosao refresh");
            }
            System.out.println("kreiran novi " + odo.vratiID() + " " + odo.vratiNazivNovogObjekta());

            porukaMetode = porukaMetode + "\n Uspesno kreiran " + odo.vratiNazivObjekta();
            return true;
        } catch (Exception e) {

            porukaMetode = porukaMetode + "\n Greska prilikom kreiranja " + odo.vratiNazivObjekta();
            Logger.getLogger(DBBrokerEntity.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean sacuvajODO(OpstiDomenskiObjekat odo) {
        try {
            OpstiDomenskiObjekat resultodo = em.find(odo.getClass(), odo.vratiID());
            if (resultodo == null) {
                em.persist(odo);
            } else {
                em.merge(odo);
            }
            return true;
        } catch (Exception e) {
            porukaMetode = porukaMetode + "\n Objekat " + odo.getClass().getSimpleName() + " nije sačuvan.";
            Logger.getLogger(DBBrokerEntity.class.getName()).log(Level.SEVERE, porukaMetode, e);
            return false;
        }
    }

    public boolean obrisiODO(OpstiDomenskiObjekat d) {
        OpstiDomenskiObjekat resultODO = em.find(d.getClass(), d.vratiID());
        System.out.println("U obrisi je getid() klase:" + d.vratiID().getClass() + ", a d.getClass() je klase:" + d.getClass());
        if (resultODO == null) {
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
            porukaMetode = porukaMetode + "\n " + d.vratiImeKlase() + " nije pronadjen";
            Logger.getLogger(DBBrokerEntity.class.getName()).log(Level.SEVERE, porukaMetode);
            return false;
        } else {
            d.prekopirajVrednostiAtributa(resultODO);

            em.merge(d);
//            em.persist(resultODO);
//            em.flush();
//           // em.refresh(resultODO);
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
