package logic.SO;

import model.OpstiDomenskiObjekat;

/*
 * Pretrazi.java
 *
 * 02.05.2011
 *
 * @autor Dr Sinisa Vlajic
 *
 * Katedra za softversko inzenjerstvo
 *
 * Laboratorija za softversko inzenjerstvo
 *
 * Fakultet organizacionih nauka - Beograd
 *
 */
public class Pretrazi extends OpstaSO {

    public static String Pretrazi(OpstiDomenskiObjekat odo) {
        Pretrazi p = new Pretrazi();
        OpstaSO.transakcija = false;
        return OpstaSO.opsteIzvrsenjeSO(odo, p);
    }

    // Prekrivanje metode klase OpstaSO
    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat odo) {
        signal = dbbe.vratiODOpoUslovu(odo);
        if (!signal) {
            dbbe.dodajPorukuMetode("*Sistem ne moze da nadje " + odo.vratiNazivObjekta() + " po zadatoj vrednosti.");
            return false;
        }
        dbbe.dodajPorukuMetode("Sistem je nasao " + odo.vratiNazivObjekta() + " po zadatoj vrednosti.");
        return true;
    }
}