/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import javax.persistence.Entity;
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

    public static DBBrokerEntity getInstance() {
        if (instance == null) {
            return new DBBrokerEntity();
        }
        return instance;
    }

    private DBBrokerEntity() {
        emf = Persistence.createEntityManagerFactory("PS_MSSP_ServerPU");

    }

    public List<OpstiDomenskiObjekat> vratiSveODO(OpstiDomenskiObjekat odo) {
        String namedQuery= odo.vratiImeKlase()+".findAll";
        //String tableName= odo.vratiNazivObjekta();
        EntityManager em = emf.createEntityManager();
        List<OpstiDomenskiObjekat> results=em.createNamedQuery(namedQuery).getResultList();
        //List<OpstiDomenskiObjekat> lista = em.createQuery("SELECT objd FROM "+tableName+" objd").getResultList();
        em.close();
        return results;
    }

    public OpstiDomenskiObjekat vratiODOpoUslovu(OpstiDomenskiObjekat odo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String namedQuery= odo.vratiImeKlase()+"..findBy"+odo.vratiAtributPretrazivanja();
        
        OpstiDomenskiObjekat trazeniODO= (OpstiDomenskiObjekat) em.createNamedQuery(namedQuery).getSingleResult();
        //OpstiDomenskiObjekat trazeniODO = em.find(odo.getClass(), odo.vratiAtributPretrazivanja());

        em.close();
        return trazeniODO;
        
    }
    
    public void sacuvajODO(OpstiDomenskiObjekat odo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(odo);
        
        em.close();
    }

    public void obrisiODO(OpstiDomenskiObjekat d) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        OpstiDomenskiObjekat resultODO = em.find(d.getClass(), d.vratiID());
        if (resultODO == null) {
            em.getTransaction().rollback();
            throw new Exception(d.vratiImeKlase()+" nije pronadjen");
        } else {
            em.remove(resultODO);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void izmeniODO(OpstiDomenskiObjekat d) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        OpstiDomenskiObjekat resultODO = em.find(d.getClass(), d.vratiID());
        if (resultODO == null) {
            em.getTransaction().rollback();
            throw new Exception(d.vratiImeKlase()+" nije pronadjen");
        } else {
            d.prekopirajVrednostiAtributa(resultODO);
        }
        em.getTransaction().commit();
        em.close();
    }
}
