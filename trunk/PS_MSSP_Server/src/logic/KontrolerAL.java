package logic;

/*
 * KontrolerAL.java
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
import java.net.*;
import java.io.*;
import logic.SO.*;
import model.OpstiDomenskiObjekat;

class KontrolerAL // Kontroler aplikacione logike
{

    static ServerSocket ss;
    static Klijent kl[];

    public static void main(String[] args) throws Exception {
        kl = new Klijent[10];
        ss = new ServerSocket(8189);

        System.out.println("Podignut je serverski program:");
        for (int brojKlijenta = 0; brojKlijenta < 10; brojKlijenta++) {
            Socket soketS = ss.accept();
            System.out.println("Klijent " + (brojKlijenta + 1));
            kl[brojKlijenta] = new Klijent(soketS, brojKlijenta + 1);
        }
    }
}

class Klijent extends Thread {

    public Klijent(Socket soketS1, int brojKlijenta1) {
        soketS = soketS1;
        brojKlijenta = brojKlijenta1;
        System.out.println("Konstruktor");
        start();
    }

    public void run() {
        try {
            String signal = "";
            out = new ObjectOutputStream(soketS.getOutputStream());
            in = new ObjectInputStream(soketS.getInputStream());

            System.out.println("run");
            while (true) { // Citanje naziva operacije i racuna
                String NazivSO = (String) in.readObject();
                OpstiDomenskiObjekat rac = (OpstiDomenskiObjekat) in.readObject();


                if (NazivSO.equals("kreirajNovi") == true) {
                    signal = KreirajNovi.kreirajNovi(rac);
                }

                if (NazivSO.equals("Pretrazi") == true) {
                    signal = Pretrazi.Pretrazi(rac);
                }

                if (NazivSO.equals("Zapamti") == true) {
                    signal = Zapamti.Zapamti(rac);
                }

                if (NazivSO.equals("Obradi") == true) {
                    signal = Obradi.Obradi(rac);
                }

                if (NazivSO.equals("Storniraj") == true) {
                    signal = Storniraj.Storniraj(rac);
                }

                // Slanje promenjenog racuna i signala o uspesnosti operacije
                out.writeObject(rac);
                out.writeObject(new String(signal));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private Socket soketS;
    int brojKlijenta;
    ObjectOutputStream out;
    ObjectInputStream in;
}
