package logic.SO;

import model.OpstiDomenskiObjekat;

/*
 * Obradi.java
 *
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

public class Obradi extends OpstaSO
  {
    public static String Obradi(OpstiDomenskiObjekat odo)
      { Obradi ob = new Obradi();
	    OpstaSO.transakcija = true;
	    return OpstaSO.opsteIzvrsenjeSO(odo,ob);
      }


   // Prekrivanje metode klase OpstaSO
    @Override
   boolean izvrsenjeSO(OpstiDomenskiObjekat odo)
     { if (!Preduslov(odo))
	    { BBP.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ". Dokument je vec obradjen ili storniran.");
	      return false;
        }

  	   if (!odo.vrednosnaOgranicenja())
	    { BBP.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ". Naruseno je vrednosno ogranicenje.");
		  return false;
	    }

  	   odo.Obradi();

	   if (!BBP.brisiSlog(odo))
	    { BBP.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ".");
	      return false;
	    }

       if (!BBP.pamtiSlozeniSlog(odo))
        { BBP.dodajPorukuMetode("Sistem ne moze da obradi " + odo.vratiNazivObjekta() + ".");
	 	  return false;
	    }

       BBP.dodajPorukuMetode("Sistem je obradio " + odo.vratiNazivObjekta() + ".");
       return true;
  }



   private boolean Preduslov(OpstiDomenskiObjekat odo) // 94,77
      {  // 1. Ako je racun obradjen nad njim se ne moze izvrsiti operacija racunanja stavki.
		 // 2. Ako je racun storniran nad njim se ne moze izvrsiti operacija racunanja stavki.
		 if ((BBP.vratiLogickuVrednostAtributa(odo,"Obradjen") == true) || (BBP.vratiLogickuVrednostAtributa(odo,"Storniran") == true))
		   {  return false;
	       }
	     return true;
	  }
}