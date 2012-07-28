package logic.SO;

import data.BrokerBazePodataka;
import model.OpstiDomenskiObjekat;

/*
 * OpstaSO.java
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
public abstract class OpstaSO
{
  static BrokerBazePodataka BBP;
  static boolean signal;
  static boolean BazaOtvorena = false;
  static boolean transakcija = false;

  synchronized static String opsteIzvrsenjeSO(OpstiDomenskiObjekat rac, OpstaSO os)
   { if (!os.otvoriBazu()) return os.vratiPorukuMetode();

  	 if (!os.izvrsenjeSO(rac) && transakcija)
	  { signal = os.rollbackTransakcije();
		return os.vratiPorukuMetode();
      }

     if (transakcija) os.commitTransakcije();
        return os.vratiPorukuMetode();
   }

   abstract boolean izvrsenjeSO(OpstiDomenskiObjekat rac);


   boolean otvoriBazu()
   { if (BazaOtvorena == false)
	    { BBP = new BrokerBazePodataka();
	      BBP.isprazniPoruku();
          signal = BBP.otvoriBazu("RACUN");
          if (!signal) return false;
         }
     BBP.isprazniPoruku();
     BazaOtvorena = true;
     return true;
   }

   boolean commitTransakcije()
     { return BBP.commitTransakcije();}

   boolean rollbackTransakcije()
     { return BBP.rollbackTransakcije();}

   String vratiPorukuMetode()
     { System.out.println(BBP.vratiPorukuMetode());
	   return BBP.vratiPorukuMetode();
	 }
}