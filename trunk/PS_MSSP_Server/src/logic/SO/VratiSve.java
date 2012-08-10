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

    public static String VratiSve(OpstiDomenskiObjekat odo) {
        VratiSve vs = new VratiSve();
        OpstaSO.transakcija = false;
        return OpstaSO.opsteIzvrsenjeSO(odo, vs);
    }

    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat odo) {
        signal = BBP.nadjiSlogiVratiGa(odo);
        List<OpstiDomenskiObjekat> vratiSveODO = DBBrokerEntity.getInstance().vratiSveODO(odo);
        if (!signal) {
            BBP.dodajPorukuMetode("*Sistem ne moze da nadje " + odo.vratiNazivObjekta() + " po zadatoj vrednosti.");
            return false;
        }
        BBP.dodajPorukuMetode("Sistem je nasao " + odo.vratiNazivObjekta() + " po zadatoj vrednosti.");
        return true;
    }
}

