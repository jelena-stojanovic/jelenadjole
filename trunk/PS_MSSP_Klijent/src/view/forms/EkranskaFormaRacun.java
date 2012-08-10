package view.forms;

/*
 * EkranskaFormaRacun.java
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import view.AbsoluteConstraints;
import view.AbsoluteLayout;
import view.guicontrollers.KontrolerKIRacun;

public class EkranskaFormaRacun extends OpstaEkranskaForma {

    KontrolerKIRacun kkir;
    private JLabel LNazivDokumenta;
    // Komponente koje reprezentuju klasu
    JLabel LBrojRacuna;
    JFormattedTextField BrojRacuna;
    JLabel LNazivPartnera;
    JFormattedTextField NazivPartnera;
    JLabel LUkupnaVrednost;
    JFormattedTextField UkupnaVrednost;
    JCheckBox Obradjen;
    JCheckBox Storniran;
    JFormattedTextField Pretrazivanje;
    JLabel LPretrazivanje;
    // Komponenete koje reprezentuju niz objekata stavke dokumenta.
    JTable TabStavkaRacuna;
    // Atributi potrebni za definisanje tabele.
    DefaultTableModel DTM;
    private JButton Kreiraj;
    private JButton Zapamti;
    private JButton Obradi;
    private JButton Storniraj;

    // Glavni program
    public static void main(String args[]) {
        EkranskaFormaRacun EF = new EkranskaFormaRacun();
        EF.show();
    }

    // 1. Konstruktor ekranske forme
    public EkranskaFormaRacun() {
        kreirajKomponenteEkranskeForme();      // 1.1
        pokreniMenadzeraRasporedaKomponeti();  // 1.2
        postaviImeForme();                     // 1.3

        postaviTextFieldBrojRacuna();          // 1.4
        postaviTextFieldNazivPartnera();       // 1.5
        postaviTextFieldUkupnaVrednost();      // 1.6
        postaviTextFieldPretrazivanje();       // 1.7

        postaviCheckBoxObradjen(); 			   // 1.8
        postaviCheckBoxStorniran();            // 1.9

        postaviDugmeKreiraj();                 // 1.10
        postaviDugmeObradi();                  // 1.11
        postaviDugmeStorniraj();			   // 1.12
        postaviDugmeZapamti();				   // 1.13

        postaviTabelu();					   // 1.14

        inicijalizacijaKontrolera();		   // 1.15


        pack();
    }

// 1.1 Kreiranje i inicijalizacija komponenti ekranske forme
    void kreirajKomponenteEkranskeForme() {
        LNazivDokumenta = new JLabel();
        BrojRacuna = new JFormattedTextField();
        LBrojRacuna = new JLabel();
        NazivPartnera = new JFormattedTextField();
        LNazivPartnera = new JLabel();
        UkupnaVrednost = new JFormattedTextField();
        LUkupnaVrednost = new JLabel();
        Obradjen = new JCheckBox();
        Storniran = new JCheckBox();
        Kreiraj = new JButton();
        Zapamti = new JButton();
        Obradi = new JButton();
        Storniraj = new JButton();
        Pretrazivanje = new JFormattedTextField();
        LPretrazivanje = new JLabel();
    }

// 1.2 Kreiranje menadzera rasporeda komponenti i njegovo dodeljivanje do kontejnera okvira(JFrame komponente).
    void pokreniMenadzeraRasporedaKomponeti() {
        getContentPane().setLayout(new AbsoluteLayout());
    }

// 1.3 Odredivanje naslovnog teksta i njegovo dodeljivanje do kontejnera okvira.
    void postaviImeForme() {
        LNazivDokumenta.setFont(new Font("Times New Roman", 1, 24));
        LNazivDokumenta.setText("Racun");
        getContentPane().add(LNazivDokumenta, new AbsoluteConstraints(20, 10, -1, -1));
    }

// 1.4
    void postaviTextFieldBrojRacuna() {
        LBrojRacuna.setText("Broj racuna:");
        getContentPane().add(LBrojRacuna, new AbsoluteConstraints(20, 80, -1, -1));
        BrojRacuna.setEditable(false);
        getContentPane().add(BrojRacuna, new AbsoluteConstraints(20, 100, 50, -1));
    }

// 1.5
    void postaviTextFieldNazivPartnera() {
        LNazivPartnera.setText("Naziv partnera:");
        getContentPane().add(LNazivPartnera, new AbsoluteConstraints(20, 130, -1, -1));
        NazivPartnera.setEditable(true);
        getContentPane().add(NazivPartnera, new AbsoluteConstraints(20, 150, 250, -1));
    }

// 1.6
    void postaviTextFieldUkupnaVrednost() {
        LUkupnaVrednost.setText("Ukupna vrednost:");
        getContentPane().add(LUkupnaVrednost, new AbsoluteConstraints(480, 290, 150, -1));
        UkupnaVrednost.setEditable(false);
        getContentPane().add(UkupnaVrednost, new AbsoluteConstraints(480, 310, 120, -1));
    }

// 1.7
    void postaviTextFieldPretrazivanje() { // Dodeljivanje pocetne vrednosti i formata polja.
        Pretrazivanje.setValue(new String(""));
        // Polje postaje slusalac dogadjaja,koji ce se desiti nakon unosa podataka u polje.
        Pretrazivanje.setBackground(new Color(51, 51, 255));
        // Odredjivanje boje crtanja polja.
        Pretrazivanje.setForeground(new Color(255, 255, 51));

        Pretrazivanje.addActionListener(new ActionListener() // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE
        {

            /**
             * *****************************************************
             */
            public void actionPerformed(ActionEvent evt) {
                BrojRacuna.setValue(Pretrazivanje.getValue());
                NazivPartnera.setValue("");
                UkupnaVrednost.setValue(new Double(0));
                DefaultTableModel DTM = (DefaultTableModel) TabStavkaRacuna.getModel();
                DTM.setRowCount(0);
                String signal = kkir.SOPretrazi();
                if (signal.charAt(1) == '*') {
                    BrojRacuna.setValue("");
                    NazivPartnera.setValue("");
                    UkupnaVrednost.setValue(new Double(0));
                }
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
                if (DTM.getRowCount() == 0) {
                    DTM.addRow(StavkaRacuna.vratiPocetneVrednosti());
                }

            }
            /**
             * *****************************************************
             */
        });
        // Polje se dodaje kontejneru okvira (JFrame).
        getContentPane().add(Pretrazivanje, new AbsoluteConstraints(140, 100, 50, -1));

        LPretrazivanje.setText("Pretrazi");
        getContentPane().add(LPretrazivanje, new AbsoluteConstraints(140, 80, -1, -1));
    }

// 1.8
    void postaviCheckBoxObradjen() {
        Obradjen.setText("Obradjen");
        Obradjen.setFocusable(false);
        Obradjen.setEnabled(false);
        getContentPane().add(Obradjen, new AbsoluteConstraints(390, 80, -1, -1));
    }

// 1.9
    void postaviCheckBoxStorniran() {
        Storniran.setText("Storniran");
        Storniran.setFocusable(false);
        Storniran.setEnabled(false);
        getContentPane().add(Storniran, new AbsoluteConstraints(500, 80, -1, -1));
    }

// 1.10
    void postaviDugmeKreiraj() {
        Kreiraj.setText("Kreiraj");
        Kreiraj.addActionListener(new ActionListener() {

            /**
             * *****************************************************
             */
            // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE
            public void actionPerformed(ActionEvent evt) {
                String signal = kkir.SOKreirajNovi();

                DTM.setRowCount(0);
                //for (int j=0; j<TabStavkaRacuna.getColumnCount(); j++)
                //   {  TabStavkaRacuna.setValueAt(StavkaRacuna.vratiPocetneVrednosti()[j],0,j);}
                DTM.addRow(StavkaRacuna.vratiPocetneVrednosti());
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
            }
        });
        /**
         * *****************************************************
         */
        getContentPane().add(Kreiraj, new AbsoluteConstraints(170, 30, -1, -1));
    }

// 1.11
    void postaviDugmeObradi() {
        Obradi.setText("Obradi");
        Obradi.addActionListener(new ActionListener() {
            // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE

            /**
             * *****************************************************
             */
            public void actionPerformed(ActionEvent evt) {
                String signal = kkir.SOObradi();
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
            }
            /**
             * *****************************************************
             */
        });
        getContentPane().add(Obradi, new AbsoluteConstraints(390, 30, -1, -1));
    }

// 1.12
    void postaviDugmeStorniraj() {
        Storniraj.setText("Storniraj");
        Storniraj.addActionListener(new ActionListener() {
            // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE

            /**
             * *****************************************************
             */
            public void actionPerformed(ActionEvent evt) {
                String signal = kkir.SOStorniraj();
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
            }
            /**
             * *****************************************************
             */
        });
        getContentPane().add(Storniraj, new AbsoluteConstraints(500, 30, -1, -1));
    }

// 1.13
    void postaviDugmeZapamti() {
        Zapamti.setText("Zapamti");
        Zapamti.addActionListener(new ActionListener() { // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE

            /**
             * *****************************************************
             */
            public void actionPerformed(ActionEvent evt) {
                String signal = kkir.SOZapamti();
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
            }
        });
        /**
         * *****************************************************
         */
        getContentPane().add(Zapamti, new AbsoluteConstraints(280, 30, -1, -1));
    }

// 1.14
    void postaviTabelu() { // 1. - Kreiranje i inicijalizacija modela tabele.

        String[] zaglavlje = StavkaRacuna.vratiZaglavlje();

        TabStavkaRacuna = new JTable();

        DTM = new DefaultTableModel(zaglavlje, 1) {  // LOGICKO POVEZIVANJE (PO TIPU) KOLONA TABELE SA ATRIBUTIMA klase stavka.		  // Inicilazacija KOLONA TABELE sa tipovima klasa stavka dok.

            Class[] types = StavkaRacuna.vratiTipove();
            // Ova metoda onemogucava unos podataka neodgovarajuceg tipa u polja (celije) tabele.
            // npr: Ukoliko je kolona vezana za Double klasu u nju se ne mogu uneti String podaci.

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        // 2. - Povezivanje tabele sa modelom tabele.
        TabStavkaRacuna.setModel(DTM);


        // 3. - Tabela postaje slusalac dogadjaja, koji ce se desiti nakon pritiska tipke
        // na bilo kom polju tabele.
        TabStavkaRacuna.addKeyListener(new KeyAdapter() {

            /**
             * *****************************************************
             */
            // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE
            public void keyPressed(KeyEvent evt) {
                String signal = kkir.pritisakTipke(evt);
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
            }
            /**
             * *****************************************************
             */
        });

// 4. - Tabela postaje slusalac dogadjaja, koji ce se desiti nakon otpustanja tipke
// na bilo kom polju tabele.
        TabStavkaRacuna.addKeyListener(new KeyAdapter() {

            /**
             * *****************************************************
             */
            // DOGADJAJ KOJI INICIRA POZIV SISTEMSKE OPERACIJE
            public void keyReleased(KeyEvent evt) {
                String signal = kkir.pustanjeTipke(evt);
                // Prikaz poruke o uspesnosti izvrsenja operacije
                PrikazPorukeUspesnosti(signal);
            }
            /**
             * *****************************************************
             */
        });


// 5.Kreiranje i inicijalizacija objekta koji pomaze da se tabela skroluje hotizontalno
// i vertikalno.
        int vsb = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int hsb = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane skrol = new JScrollPane(TabStavkaRacuna, vsb, hsb);
// Skrol objekat se dodaje kontejneru okvira (JFrame)
        getContentPane().add(skrol, new AbsoluteConstraints(20, 190, 440, 150));

    }

// 1.15 Inicijalizacija KontroleraKI
    void inicijalizacijaKontrolera() {
        try {
            kkir = new KontrolerKIRacun(this);
        } catch (Exception e) {
        }
    }

// Nakon izvrsenja sistemskih operacija poziva se ova metoda koja prikazuje
// dijalog boks sa porukom o uspesnosti izvrsenja sistemske operacije.
    void PrikazPorukeUspesnosti(String signal) {
        Boolean prikazi = new Boolean(true);;
        DijalogBoksPrikazPoruke DBPP = new DijalogBoksPrikazPoruke(this);
        int signal1 = DBPP.PrikazPoruke(signal);
        if (signal1 == 1) {
            DBPP.show();
            pack();
        }
    }

// POZIVA SE IZ OPSTIKONTROLERKI - pocetak
    @Override
    TableModel vratiModel() {
        return TabStavkaRacuna.getModel();
    }

    @Override
    Object[] vratiPocetneVrednosti() {
        return StavkaRacuna.vratiPocetneVrednosti();
    }

    int vratiSelektovaniRed() {
        return TabStavkaRacuna.getSelectedRow();
    }

    OpstiDomenskiObjekat kreirajObjekat() {
        return new Racun();
    }
// POZIVA SE IZ OPSTIKONTROLERKI - kraj
}

class DijalogBoksPrikazPoruke extends JDialog {

    public DijalogBoksPrikazPoruke(JFrame roditelj) {
        super(roditelj, "Poruka:", true);
    } // true definise modalni dijalog

    int PrikazPoruke(String signal) {
        Box b = Box.createVerticalBox();
        b.add(Box.createGlue());

        System.out.println("Signal (klijent):" + signal);

        b.add(new JLabel(signal));
        getContentPane().add(b, "Center");
        setSize(750, 75);
        return 1;
    }
}
