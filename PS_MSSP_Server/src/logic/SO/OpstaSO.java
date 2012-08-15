package logic.SO;

import data.DBBrokerEntity;
import model.OpstiDomenskiObjekat;

/*
 * OpstaSO.java
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
public abstract class OpstaSO {

    //static BrokerBazePodataka dbbe;
    static DBBrokerEntity dbbe;
    static boolean signal;
    static boolean BazaOtvorena = false;
    static boolean transakcija = false;

    /*
     * synchronized static String opsteIzvrsenjeSO(OpstiDomenskiObjekat rac,
     * OpstaSO os) { if (!os.otvoriBazu()) return os.vratiPorukuMetode();
     *
     * if (!os.izvrsenjeSO(rac) && transakcija) { signal =
     * os.rollbackTransakcije(); return os.vratiPorukuMetode(); }
     *
     * if (transakcija) os.commitTransakcije(); return os.vratiPorukuMetode(); }
     */
    synchronized static String opsteIzvrsenjeSO(OpstiDomenskiObjekat rac, OpstaSO os) {
        if (!os.otvoriBazu()) {
            return os.vratiPorukuMetode();
        }

        if (!os.izvrsenjeSO(rac) && transakcija) {
            signal = os.rollbackTransakcije();
            return os.vratiPorukuMetode();
        }

        if (transakcija) {
            os.commitTransakcije();
        }
        return os.vratiPorukuMetode();
    }

    abstract boolean izvrsenjeSO(OpstiDomenskiObjekat rac);

//    boolean otvoriBazu() {
//        if (BazaOtvorena == false) {
//            dbbe = new BrokerBazePodataka();
//            dbbe.isprazniPoruku();
//            signal =dbbe.otvoriBazu("RACUN");
//            if (!signal) {
//                return false;
//            }
//        }
//        dbbe.isprazniPoruku();
//        BazaOtvorena = true;
//        return true;
//    }
//
//    boolean commitTransakcije() {
//        return dbbe.commitTransakcije();
//    }
//
//    boolean rollbackTransakcije() {
//        return dbbe.rollbackTransakcije();
//    }
//
//    String vratiPorukuMetode() {
//        System.out.println(dbbe.vratiPorukuMetode());
//        return dbbe.vratiPorukuMetode();
//    }

    boolean otvoriBazu() {
        if (BazaOtvorena == false) {
            dbbe= DBBrokerEntity.getInstance();
            signal=dbbe.beginTransaction();
            if (!signal) {
                return false;
            }
        }
        dbbe.isprazniPoruku();
        BazaOtvorena = true;
        return true;
    }

    boolean commitTransakcije() {
        return dbbe.commitTransaction();
    }

    boolean rollbackTransakcije() {
        return dbbe.rollbackTransaction();
    }

    String vratiPorukuMetode() {
        System.out.println(dbbe.vratiPorukuMetode());
        return dbbe.vratiPorukuMetode();
    }
}