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
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import logic.SO.*;
import logic.SO.Import_Export.CSVExportDSToFile;
import logic.SO.similarity.CalculateCosineSimilarity;
import logic.SO.similarity.CalculateEuclidianSimilarity;
import model.OpstiDomenskiObjekat;
import model.dataFormat.CSVFormat;
import model.dataFormat.DataFormat;
import model.dataset.Dataset;
import to.DataSetTO;

public class KontrolerAL // Kontroler aplikacione logike
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

    @Override
    public void run() {
        try {
            String signal = "";
            out = new ObjectOutputStream(soketS.getOutputStream());
            in = new ObjectInputStream(soketS.getInputStream());

            System.out.println("run");
            while (true) { // Citanje naziva operacije i racuna
                String NazivSO = (String) in.readObject();
                OpstiDomenskiObjekat rac = (OpstiDomenskiObjekat) in.readObject();


                if (NazivSO.equals("VratiSve") == true) {
                    List<OpstiDomenskiObjekat> odoList = new ArrayList<OpstiDomenskiObjekat>();
                    odoList.add(rac);
                    odoList = VratiSve.VratiSve(odoList, signal);
                    List<OpstiDomenskiObjekat> odoListDS = new ArrayList<OpstiDomenskiObjekat>();
                    if (rac instanceof Dataset) {

                        for (int i = 0; i < odoList.size(); i++) {
                            OpstiDomenskiObjekat opstiDomenskiObjekat = odoList.get(i);
                            DataSetTO dto = new DataSetTO((Dataset) opstiDomenskiObjekat);
                            odoListDS.add(dto);

                        }
                        out.writeObject(odoListDS);
                    } else {
                        out.writeObject(odoList);
                    }
                    out.writeObject(signal);
                } else if (NazivSO.equals("CalculateSimilarity")) {
                    Dataset ds1 = (Dataset) rac;
                    Dataset ds2 = (Dataset) in.readObject();
                    String similarity = (String) in.readObject();

                    double d = Double.NaN;

                    if (similarity.equals("CalculateCosineSimilarity")) {
                        d = CalculateCosineSimilarity.calculate(ds1, ds2);
                    } else if (similarity.equals("CalculateEuclidianSimilarity")) {
                        d = CalculateEuclidianSimilarity.calculate(ds1, ds2);
                    }

                    out.writeObject(d);
                    out.writeObject(signal);


                } else if (NazivSO.equals("Export") == true) {
                    Dataset ds = (Dataset) rac;
                    DataFormat df = (DataFormat) in.readObject();

                    String filePath = ds.getFilePath();
                    File file = new File((filePath + ".csv"));
                    if (!file.exists()) {
                        CSVFormat csv = (CSVFormat) df;
                        csv.setCsvFile(new File((filePath + ".csv")));
                        new CSVExportDSToFile().export(ds, csv);
                    }
                   

                    // sendfile

                    byte[] mybytearray = new byte[(int) file.length()];
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    bis.read(mybytearray, 0, mybytearray.length);

                    out.write(mybytearray, 0, mybytearray.length);
                    out.flush();

                   

                  //  out.writeObject(exportClient);
                    out.writeObject(signal);

                } else {

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
                    out.writeObject(signal);
                }
            }

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    private Socket soketS;
    int brojKlijenta;
    ObjectOutputStream out;
    ObjectInputStream in;
}
