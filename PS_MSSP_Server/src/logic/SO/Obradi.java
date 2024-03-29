package logic.SO;

import model.OpstiDomenskiObjekat;

/*
 * Obradi.java
 *
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
public class Obradi extends OpstaSO {

    public static String Obradi(OpstiDomenskiObjekat odo) {
        Obradi ob = new Obradi();
        OpstaSO.transakcija = true;
        return OpstaSO.opsteIzvrsenjeSO(odo, ob);
    }

    // Prekrivanje metode klase OpstaSO
    @Override
    boolean izvrsenjeSO(OpstiDomenskiObjekat odo) {
        if (!Preduslov(odo)) {
            dbbe.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ". Dokument je vec obradjen ili storniran.");
            return false;
        }

        /*if (!odo.vrednosnaOgranicenja()) {
            dbbe.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ". Naruseno je vrednosno ogranicenje.");
            return false;
        }

        odo.Obradi();
*/
//        if (!dbbe.obrisiODO(odo)) {
//            dbbe.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ".");
//            return false;
//        }
//
//        if (!dbbe.sacuvajODO(odo)) {
//            dbbe.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ".");
//            return false;
//        }

        
        if (!dbbe.izmeniODO(odo)) {
            dbbe.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ".");
            return false;
        }
        
        dbbe.dodajPorukuMetode("Sistem je obradio " + odo.vratiNazivObjekta() + ".");
        return true;
    }

    private boolean Preduslov(OpstiDomenskiObjekat odo) {// 94,77
//      {  // 1. Ako je racun obradjen nad njim se ne moze izvrsiti operacija racunanja stavki.
//		 // 2. Ako je racun storniran nad njim se ne moze izvrsiti operacija racunanja stavki.
//		 if ((dbbe.vratiLogickuVrednostAtributa(odo,"Obradjen") == true) || (dbbe.vratiLogickuVrednostAtributa(odo,"Storniran") == true))
//		   {  return false;
//	       }
        return true;
    }
}