package view.guicontrollers;

/*
 * KontrolerKI.java
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
import java.awt.event.*;
import javax.swing.table.*;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OpstiDomenskiObjekat;
import model.dataFormat.CSVFormat;
import model.dataFormat.DataFormat;
import view.forms.OpstaEkranskaForma;

public abstract class OpstiKontrolerKI {

    Socket soketK;
    ObjectOutputStream out;
    ObjectInputStream in;
    String signal;
    OpstiDomenskiObjekat odo;
    OpstaEkranskaForma oef;

    OpstiKontrolerKI() throws IOException {
        soketK = new Socket("127.0.0.1", 8189);
        out = new ObjectOutputStream(soketK.getOutputStream());
        in = new ObjectInputStream(soketK.getInputStream());
    }

    public String pritisakTipke(KeyEvent evt) {
        DefaultTableModel DTM = (DefaultTableModel) oef.vratiModel();
        if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
            DTM.addRow(oef.vratiPocetneVrednosti());
            return "Unet novi red u kolonu";
        }

        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            int selRed = oef.vratiSelektovaniRed();
            if (selRed >= 0) {
                DTM.removeRow(selRed);
                return SOZapamti();
            } else {
                return "Red ne moze da se brise ako nije selektovan.";
            }
        }

        return "Uneta je tipka koja se ne obradjuje.";
    }

    public String pustanjeTipke(KeyEvent evt) {
        DefaultTableModel DTM = (DefaultTableModel) oef.vratiModel();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            return SOZapamti();
        }
        return "Uneta je tipka koja se ne obradjuje.";
    }

    public String SOPretrazi() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Pretrazi");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();

        return signal;
    }

    public String SOKreirajNovi() {
        odo = oef.kreirajObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("kreirajNovi");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOZapamti() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Zapamti");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOStorniraj() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Storniraj");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOObradi() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Obradi");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public List<OpstiDomenskiObjekat> SOVratiSve() {
        odo = oef.kreirajObjekat();
        List<OpstiDomenskiObjekat> odoList = null;
        try {
            out.writeObject("VratiSve");
            out.writeObject(odo);
        } catch (IOException ex) {
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Neuspesno slanje objekata ka serveru.");
        }
        try {
            odoList = (List<OpstiDomenskiObjekat>) in.readObject();
            signal = (String) in.readObject();
            System.out.println(signal);
        } catch (IOException ex) {
            System.out.println("Neuspesno citanje objekata sa servera.");
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Neuspesno citanje objekata sa servera.");
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return odoList;

    }

    public void SOExport(DataFormat df) {
        odo = oef.kreirajObjekat();

        try {
            out.writeObject("Export");
            out.writeObject(odo);
            out.writeObject(df);
        } catch (IOException ex) {
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Neuspesno slanje objekata ka serveru.");
        }
        try {
            int filesize = 6022386; // filesize temporary hardcoded

            int bytesRead;
            int current = 0;
            
            // receive file
            byte[] mybytearray = new byte[filesize];

            FileOutputStream fos = new FileOutputStream(((CSVFormat) df).getCsvFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = in.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;

            
            do {
                bytesRead =
                        in.read(mybytearray, current, (mybytearray.length - current));
                if (bytesRead >= 0) {
                    current += bytesRead;
                }
            } while (bytesRead > -1);

            bos.write(mybytearray, 0, current);
            bos.flush();
            
            
            bos.close();

            signal = (String) in.readObject();


            //-----------------

        } catch (IOException ex) {
            System.err.println("Neuspesno citanje objekata sa servera.");
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Neuspesno citanje objekata sa servera.");
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    String pozivSO(String nazivSO) {
        try {
            out.writeObject(nazivSO);
            out.writeObject(odo);
        } catch (IOException io) {
            return "Neuspesno slanje objekata ka serveru.";
        }

        try {
            odo = (OpstiDomenskiObjekat) in.readObject();
            signal = (String) in.readObject();
        } catch (Exception e) {
            return "Neuspesno citanje objekata sa servera";
        }
        return signal;
    }

    abstract public void KonvertujGrafickiObjekatUDomenskiObjekat();

    abstract public void KonvertujDomenskiObjekatUGrafickiObjekat();
}