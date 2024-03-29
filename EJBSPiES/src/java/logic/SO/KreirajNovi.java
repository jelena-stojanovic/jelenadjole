package logic.SO;

import model.OpstiDomenskiObjekat;

/*
 * KreirajNovi.java
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
public class KreirajNovi extends OpstaSO {

    public static String kreirajNovi(OpstiDomenskiObjekat odo) {
        KreirajNovi kn = new KreirajNovi();
        OpstaSO.transakcija = true;
        return OpstaSO.opsteIzvrsenjeSO(odo, kn);
    }

    // Prekrivanje metode klase OpstaSO
    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat odo) {
        if (!dbbe.kreirajNovi(odo)) {
            dbbe.dodajPorukuMetode("Sistem ne moze da kreira " + odo.vratiNazivNovogObjekta() + ".");
            return false;
        }
        dbbe.dodajPorukuMetode("Sistem je kreirao " + odo.vratiNazivNovogObjekta() + ".");
        return true;
    }
}
