/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import logic.SO.KreirajNovi;
import logic.SO.Obradi;
import logic.SO.Pretrazi;
import logic.SO.PretraziPoUslovu;
import logic.SO.VratiSve;
import logic.SO.Zapamti;
import model.Administrator;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
@Stateless
//@EJB(name="SeassionBeanAdministrator",beanInterface=SeassionBeanAdministratorLocal.class,beanName="SeassionBeanAdministrator")
public class SeassionBeanAdministrator implements SeassionBeanAdministratorLocal {

    @Override
    public Administrator getAdmin(Administrator admin) {
        System.out.println(Pretrazi.Pretrazi(admin));
        return admin;
    }

    @Override
    public void createAdmin(Administrator admin) {
        System.out.println(KreirajNovi.kreirajNovi(admin));
    }

    @Override
    public void saveAdmin(Administrator admin) {
        System.out.println(Zapamti.Zapamti(admin));
    }

    @Override
    public void updateAdmin(Administrator admin) {
        System.out.println(Obradi.Obradi(admin));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Administrator> getAllAdmins() {

        List<Administrator> alldsma = new ArrayList<Administrator>();
        List<OpstiDomenskiObjekat> allODO = new ArrayList<OpstiDomenskiObjekat>();
        Administrator dma = new Administrator();
        allODO.add(dma);
        String signal = "";
        allODO = VratiSve.VratiSve(allODO, signal);
        if (allODO != null) {
            for (int i = 0; i < allODO.size(); i++) {
                OpstiDomenskiObjekat opstiDomenskiObjekat = allODO.get(i);
                Administrator admin = (Administrator) opstiDomenskiObjekat;
                alldsma.add(admin);
            }
        }
        return alldsma;
    }

    @Override
    public Administrator login(Administrator admin) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username", admin.getUsername());
        map.put("password", admin.getPassword());
        String signal = "";
        List<OpstiDomenskiObjekat> Pretrazi = PretraziPoUslovu.Pretrazi(admin, signal, map);
        if (Pretrazi != null && !Pretrazi.isEmpty()) {

            for (OpstiDomenskiObjekat opstiDomenskiObjekat : Pretrazi) {
                Administrator administ = (Administrator) opstiDomenskiObjekat;

                return administ;
            }
        }

        return null;
    }
}
