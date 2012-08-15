/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO;

import data.DBBrokerEntity;
import java.util.List;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
public class VratiSve extends OpstaSO {

    public static String VratiSve(List<OpstiDomenskiObjekat> odoList) {
        VratiSve vs = new VratiSve();
        OpstaSO.transakcija = false;
        return opsteIzvrsenjeSO(odoList, vs);
    }

    synchronized static String opsteIzvrsenjeSO(List<OpstiDomenskiObjekat> odoList, VratiSve vs) {
        if (!vs.otvoriBazu()) {
            return vs.vratiPorukuMetode();
        }

        if (vs.izvrsenjeSO(odoList) && transakcija) {
            signal = vs.rollbackTransakcije();
            return vs.vratiPorukuMetode();
        }

        if (transakcija) {
            vs.commitTransakcije();
        }
        return vs.vratiPorukuMetode();
    }

    
   
    boolean  izvrsenjeSO(List<OpstiDomenskiObjekat> odoList) {
        signal = dbbe.vratiSveODO(odoList);
        
        if (!signal) {
            dbbe.dodajPorukuMetode("*Sistem ne moze da nadje " + odoList.get(0).vratiNazivObjekta() + " po zadatoj vrednosti.");
            return false;
        }
        dbbe.dodajPorukuMetode("Sistem je nasao " + odoList.get(0).vratiNazivObjekta() + " po zadatoj vrednosti.");
        return true;
    }

    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat rac) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

