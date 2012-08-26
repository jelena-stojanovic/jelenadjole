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

    public static List<OpstiDomenskiObjekat> VratiSve(List<OpstiDomenskiObjekat> odoList, String signal) {
        VratiSve vs = new VratiSve();
        OpstaSO.transakcija = false;
        return opsteIzvrsenjeSO(odoList, signal,vs);
    }

    synchronized static List<OpstiDomenskiObjekat> opsteIzvrsenjeSO(List<OpstiDomenskiObjekat> odoList, String signal, VratiSve vs) {
        if (!vs.otvoriBazu()) {
            signal=vs.vratiPorukuMetode();
            return null;
        }

        if (vs.izvrsenjeSO(odoList)==null && transakcija) {
            vs.rollbackTransakcije();
            signal=vs.vratiPorukuMetode();
            return null;
        }

        if (transakcija) {
            vs.commitTransakcije();
        }
        signal=vs.vratiPorukuMetode();
        return vs.izvrsenjeSO(odoList);
    }

    
   
    List<OpstiDomenskiObjekat>  izvrsenjeSO(List<OpstiDomenskiObjekat> odoList) {
        
        odoList = dbbe.vratiSveODO(odoList);
        
        if (odoList==null) {
            dbbe.dodajPorukuMetode("*Sistem ne moze da nadje nijedan " + odoList.get(0).vratiNazivObjekta() + " .");
            return odoList;
        }
        dbbe.dodajPorukuMetode("Sistem je nasao sve" + odoList.get(0).vratiNazivObjekta() + "e.");
        return odoList;
    }

    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat rac) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

