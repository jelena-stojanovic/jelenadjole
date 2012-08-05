package tools;

/*
 * KonverterTipova.java
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
import javax.swing.*;
import javax.swing.table.*;
import java.lang.reflect.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OpstiDomenskiObjekat;

public class KonverterTipova {   // Konvertovanje tipova grafickih elemenata u proste tipove i tipove objekata

    public static String Konvertuj(JFormattedTextField kon_u, String kon_i) {
        return (String) kon_u.getValue();
    }

    public static Double Konvertuj(JFormattedTextField kon_u, Double kon_i) {
        return (Double) kon_u.getValue();
    }
    
    public static boolean Konvertuj(JCheckBox kon_u, boolean kon_i) {
        return kon_u.isSelected();
    }

// Konvertovanje prostih tipova i tipova objekata u tipove grafickih elemenata
    public static void Konvertuj(String kon_u, JFormattedTextField kon_i) {
        kon_i.setValue(kon_u);
    }

    public static void Konvertuj(Double kon_u, JFormattedTextField kon_i) {
        kon_i.setValue(kon_u);
    }

    public static void Konvertuj(boolean kon_u, JCheckBox kon_i) {
        kon_i.setSelected(kon_u);
    }

// Konvertovanje tabele u niz objekata
    public static void KonvertujTabeluUNizObjekata(JTable Tabela, OpstiDomenskiObjekat[] nizObjekata) {
        try {
            for (int i = 0; i < Tabela.getRowCount(); i++) {
                for (int j = 0; j < Tabela.getColumnCount(); j++) {
                    Object ob = Tabela.getValueAt(i, j);
                    Polje.Napuni(j, ob, nizObjekata[i]);
                }
            }
        } catch (IllegalAccessException iae) {
        }
    }

// Konvertovanje niza objekata u tabelu
    public static void KonvertujNizObjekataUTabelu(OpstiDomenskiObjekat[] nizObjekata, JTable Tabela) {
        try {
            DefaultTableModel DTM = (DefaultTableModel) Tabela.getModel();
            DTM.setRowCount(nizObjekata.length);
            for (int i = 0; i < nizObjekata.length; i++) {
                for (int j = 0; j < Tabela.getColumnCount(); j++) {
                    Tabela.setValueAt(Polje.Vrati(j, nizObjekata[i]), i, j);
                }
            }
        } catch (IllegalAccessException iae) {
        }
    }

// Konvertovanje atributa result seta u atribut objekta
    public static String Konvertuj(ResultSet kon_u, String kon_i, String nazivAtributa) {
        try {
            return kon_u.getString(nazivAtributa);
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return "";
        }
    }

    public static Double Konvertuj(ResultSet kon_u, Double kon_i, String nazivAtributa) {
        try {
            return new Double(kon_u.getDouble(nazivAtributa));
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return new Double(0);
        }
    }

    public static boolean Konvertuj(ResultSet kon_u, boolean kon_i, String nazivAtributa) {
        try {
            return kon_u.getBoolean(nazivAtributa);
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return false;
        }
    }

    public static Integer Konvertuj(ResultSet kon_u, Integer kon_i, String nazivAtributa) {
        try {
            return new Integer(kon_u.getInt(nazivAtributa));
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return new Integer(0);
        }
    }
    
    public static java.util.Date Konvertuj(ResultSet kon_u, String nazivAtributa) {
        try {
            return new java.util.Date(kon_u.getDate(nazivAtributa).getTime());
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
        return null;
    }
    
    public static java.sql.Date Konvertuj(java.util.Date date) {
            return new java.sql.Date(date.getTime());
    }
    
    
    
}

class Polje {

    static void Napuni(int j, Object ob, OpstiDomenskiObjekat odo) throws IllegalAccessException {
        Class cl = ((Object) odo).getClass();
        Field[] f = cl.getDeclaredFields();
        // Puni j-ti atribut polje tekuceg objekta (odo) sa vrednoscu ob.
        f[j].set(odo, ob);
    }

    static Object Vrati(int j, OpstiDomenskiObjekat odo) throws IllegalAccessException {
        Class cl = ((Object) odo).getClass();
        Field[] f = cl.getDeclaredFields();
        // Vraca od tekuceg objekta (odo) vrednost i-tog atributa (polja).
        return f[j].get(odo);
    }
}