/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.OpstiDomenskiObjekat;

/**
 *
 * @author Jelena
 */
public class PretraziPoUslovu extends OpstaSO{

    public static List<OpstiDomenskiObjekat> Pretrazi(OpstiDomenskiObjekat odo, String signal, HashMap<String, Object> mapFieldValue) {
        PretraziPoUslovu p = new PretraziPoUslovu();
        OpstaSO.transakcija = false;
        return opsteIzvrsenjeSO(odo,signal, p, mapFieldValue);
    }

    // Prekrivanje metode klase OpstaSO
//    @Override
//    boolean izvrsenjeSO(OpstiDomenskiObjekat odo) {
//        signal = dbbe.vratiODOpoUslovu(odo);
//        if (!signal) {
//            dbbe.dodajPorukuMetode("*Sistem ne moze da nadje " + odo.vratiNazivObjekta() + " po zadatoj vrednosti.");
//            return false;
//        }
//        dbbe.dodajPorukuMetode("Sistem je nasao " + odo.vratiNazivObjekta() + " po zadatoj vrednosti.");
//        return true;
//    }
    synchronized static List<OpstiDomenskiObjekat> opsteIzvrsenjeSO(OpstiDomenskiObjekat odo, String signal, PretraziPoUslovu p, HashMap<String, Object> mapFieldValue) {
        if (!p.otvoriBazu()) {
            signal=p.vratiPorukuMetode();
            return null;
        }
        List<OpstiDomenskiObjekat> odoList=p.izvrsenjeSO(odo, mapFieldValue);
        if (odoList==null && transakcija) {
            p.rollbackTransakcije();
            signal=p.vratiPorukuMetode();
            return null;
        }

        if (transakcija) {
            p.commitTransakcije();
        }
        signal=p.vratiPorukuMetode();
        return odoList;
    }

    
   
    List<OpstiDomenskiObjekat>  izvrsenjeSO(OpstiDomenskiObjekat odo,HashMap<String, Object> mapFieldValue) {
        
        List<OpstiDomenskiObjekat> odoList =dbbe.vratiODOpoUslovu(odo,mapFieldValue);
        
        if (odoList==null) {
            dbbe.dodajPorukuMetode("*Sistem ne moze da nadje nijedan " + odoList.get(0).vratiNazivObjekta() + " po uslovu.");
            return odoList;
        }
        dbbe.dodajPorukuMetode("Sistem je " + odo.vratiNazivObjekta() + "e po uslovu.");
        return odoList;
    }

    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat rac) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
