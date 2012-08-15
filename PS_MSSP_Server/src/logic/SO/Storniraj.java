package logic.SO;

import model.OpstiDomenskiObjekat;

/*
 * Storniraj.java
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
public class Storniraj extends OpstaSO {

    public static String Storniraj(OpstiDomenskiObjekat odo) {
        Storniraj st = new Storniraj();
        OpstaSO.transakcija = true;
        return OpstaSO.opsteIzvrsenjeSO(odo, st);
    }

    // Prekrivanje metode klase OpstaSO
    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat odo) {
        if (!Preduslov(odo)) {
            dbbe.dodajPorukuMetode("Sistem ne moze da stornira " + odo.vratiNazivObjekta() + "." + odo.vratiImeKlase() + " je vec storniran.");
            return false;
        }
    //    odo.Storniraj();

        if (!dbbe.obrisiODO(odo)) {
            dbbe.dodajPorukuMetode("Sistem ne moze da stornira " + odo.vratiNazivObjekta() + ".");
            return false;
        }

        if (!dbbe.sacuvajODO(odo)) {
            dbbe.dodajPorukuMetode("Sistem ne moze da stornira " + odo.vratiNazivObjekta() + ".");
            return false;
        }

        dbbe.dodajPorukuMetode("Sistem je stornirao " + odo.vratiNazivObjekta() + ".");
        return true;
    }

    private boolean Preduslov(OpstiDomenskiObjekat odo) // 94,77
    {  // 1. Ako je racun storniran nad njim se ne moze izvrsiti operacija racunanja stavki.
//		if  (dbbe.vratiLogickuVrednostAtributa(odo,"Storniran") == true)
//		  { return false; }
        return true;
    }
}