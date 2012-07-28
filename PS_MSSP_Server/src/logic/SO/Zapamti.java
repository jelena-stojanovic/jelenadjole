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
   boolean izvrsenjeSO(OpstiDomenskiObjekat odo)
     { if (!Preduslov(odo))
	     { BBP.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + "." + odo.vratiImeKlase() + " je vec obradjen ili storniran.");
	  	   return false;
	     }

	  if (!odo.vrednosnaOgranicenja())
	    { BBP.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + ". Naruseno je vrednosno ogranicenje.");
	      return false;
	    }

	  if (!BBP.brisiSlog(odo))
	    { BBP.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + ".");
	   	  return false;
	    }

      if (!BBP.pamtiSlozeniSlog(odo))
       { BBP.dodajPorukuMetode("Sistem ne moze da zapamti " + odo.vratiNazivObjekta() + ".");
	   	 return false;
	   }

      BBP.dodajPorukuMetode("Sistem je zapamtio " + odo.vratiNazivObjekta() + ".");
      return true;
  }

   private boolean Preduslov(OpstiDomenskiObjekat odo) // 94,77
      {  if ((BBP.vratiLogickuVrednostAtributa(odo,"Obradjen") == true) || (BBP.vratiLogickuVrednostAtributa(odo,"Storniran") == true))
		   { return false;
	       }
	     return true;
	  }
}