package view.controllers;

/*
 * KontrolerKI.java
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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SO.KreirajNovi;
import logic.SO.Obradi;
import logic.SO.Pretrazi;
import logic.SO.Storniraj;
import logic.SO.Zapamti;
import model.OpstiDomenskiObjekat;
import view.forms.OpstaEkranskaForma;

public abstract class OpstiKontrolerKI {

//    Socket soketK;
//    ObjectOutputStream out;
//    ObjectInputStream in;
    String signal;
    OpstiDomenskiObjekat odo;
    OpstaEkranskaForma oef;

    OpstiKontrolerKI()  {
//        soketK = new Socket("127.0.0.1", 8189);
//        out = new ObjectOutputStream(soketK.getOutputStream());
//        in = new ObjectInputStream(soketK.getInputStream());
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
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU ********
         */
        signal = Pretrazi.Pretrazi(odo);
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();

        return signal;
    }


    public String SOKreirajNovi() {
        odo = oef.kreirajObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU ********
         */
        signal = KreirajNovi.kreirajNovi(odo);
        /**
         * *******************************************************************************
         */
        //KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOZapamti() {
        odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU ********
         */
        signal = Zapamti.Zapamti(odo);
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
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU ********
         */
        signal = Storniraj.Storniraj(odo);
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOObradi() {
       // odo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU ********
         */
        signal = Obradi.Obradi(odo);
        /**
         * *******************************************************************************
         */
        return signal;
    }

//    String pozivSO(String nazivSO) {
//        try {
//            out.writeObject(nazivSO);
//            out.writeObject(odo);
//        } catch (IOException io) {
//            return "Neuspesno slanje objekata ka serveru.";
//        }
//
//        try {
//            odo = (OpstiDomenskiObjekat) in.readObject();
//            signal = (String) in.readObject();
//        } catch (Exception e) {
//            return "Neuspesno citanje objekata sa servera";
//        }
//        return signal;
//    }

    abstract public void KonvertujGrafickiObjekatUDomenskiObjekat();

    abstract public void KonvertujDomenskiObjekatUGrafickiObjekat();
}