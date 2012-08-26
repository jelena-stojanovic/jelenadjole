package logic.SO;

import model.OpstiDomenskiObjekat;

/*
 * Zapamti.java
 *
 * 02.05.2011
 *
 * @autor  Dr Sinisa Vlajic
 *
 * Katedra za softversko inzenjerstvo
 *
 * Laboratorija za softversko inzenjerstvo
 *
 * Fakultet organizacionih nauka - Beograd
 *
 */

public class Zapamti extends OpstaSO
{

   public static String Zapamti(OpstiDomenskiObjekat odo)
     { Zapamti r = new Zapamti();
       OpstaSO.transakcija = true;
	   return OpstaSO.opsteIzvrsenjeSO(odo,r);
     }

   // Prekrivanje metode klase OpstaSO
    @Override
   boolean izvrsenjeSO(OpstiDomenskiObjekat odo)
     { if (!Preduslov(odo))
	     { dbbe.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + "." + odo.vratiImeKlase() + " je vec obradjen ili storniran.");
	  	   return false;
	     }

	/*  if (!odo.vrednosnaOgranicenja())
	    { dbbe.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + ". Naruseno je vrednosno ogranicenje.");
	      return false;
	    }
*/
//	  if (!dbbe.obrisiODO(odo))
//	    { dbbe.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + ".");
//	   	  return false;
//	    }

      if (!dbbe.sacuvajODO(odo))
       { dbbe.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + ".");
	   	 return false;
	   }

      dbbe.dodajPorukuMetode("Sistem je zapamtio " + odo.vratiNazivObjekta() + ".");
      return true;
  }

   private boolean Preduslov(OpstiDomenskiObjekat odo){ // 94,77
//      {  if ((dbbe.vratiLogickuVrednostAtributa(odo,"Obradjen") == true) || (dbbe.vratiLogickuVrednostAtributa(odo,"Storniran") == true))
//		   { return false;
//	       }
	     return true;
	  }
}