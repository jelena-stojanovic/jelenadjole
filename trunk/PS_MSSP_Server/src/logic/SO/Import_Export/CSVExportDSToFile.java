/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.attribute.*;
import model.dataFormat.CSVFormat;
import model.dataset.Dataset;
import tools.KonverterTipova;

/**
 *
 * @author Jelena
 */
public class CSVExportDSToFile {

    List<Attribute> attributes = null;

    public void export(Dataset dataset, CSVFormat csvFormat) throws Exception {

        boolean writeAttributeName = csvFormat.isUseFirstRowAsAttributeNames();
        char columnSeparator = csvFormat.getColumnSeparator();
        String filePath = csvFormat.getCsvFile().getPath();
        PrintWriter out = null;

        try {
            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            attributes = dataset.getAttributeList();

            //*****write name of attribute*******/
            if (writeAttributeName == true) {
                out.print(attributes.get(0).getName());

                for (int i = 1; i < attributes.size(); i++) {
                    Attribute attribute = attributes.get(i);
                    out.print(columnSeparator + attribute.getName());
                }
                out.println();
            }
            //***** end of write name of attribute*******/

            //******* write dataMatrix****/
            double[][] doubleMatrix = dataset.getDataTable().getDoubleMatrix();

            //no of rows =i
            for (int i = 0; i < doubleMatrix.length; i++) {
                double[] ds = doubleMatrix[i];

                /**
                 * *first value in row **
                 */
                double d1 = ds[0];
                if (attributes.get(0).isNominal()) {

                    String value = attributes.get(0).getNominalValueFromIndex(d1);
                    out.print(value);
                } else if (attributes.get(0).isDate()) {

                    Date date = KonverterTipova.Konvertuj(d1);
                    String format = csvFormat.getDatePattern();
                    String dateInFormat = new SimpleDateFormat(format).format(date);
                    out.print(dateInFormat);
                } else {
                    out.print(String.valueOf(d1));
                }
                /**
                 * *end of first value in row **
                 */
                //no of columns =j
                for (int j = 1; j < ds.length; j++) {
                    double d = ds[j];

                    if (attributes.get(j).isNominal()) {

                        String value = attributes.get(j).getNominalValueFromIndex(d);
                        out.print(',' + value);
                    } else if (attributes.get(j).isDate()) {

                        Date date = KonverterTipova.Konvertuj(d);
                        //String format= da.getDatePattern();
                        String format = csvFormat.getDatePattern();
                        String dateInFormat = new SimpleDateFormat(format).format(date);
                        out.print(',' + dateInFormat);
                    } else {
                        out.print(',' + String.valueOf(d));
                    }
                }
                if (i != (doubleMatrix.length - 1)) {
                    out.println();
                }
            }
            //*******end write dataMatrix****/

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVExportDSToFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }


    }

    public String exportClient(Dataset dataset, CSVFormat csvFormat) throws Exception {


        boolean writeAttributeName = csvFormat.isUseFirstRowAsAttributeNames();
        char columnSeparator = csvFormat.getColumnSeparator();

        String string = "";
        
            attributes = dataset.getAttributeList();

            //*****write name of attribute*******/
            if (writeAttributeName == true) {
                string += attributes.get(0).getName();

                for (int i = 1; i < attributes.size(); i++) {
                    Attribute attribute = attributes.get(i);
                    string += (columnSeparator + attribute.getName());
                }
                string += "\n";
            }
            //***** end of write name of attribute*******/

            //******* write dataMatrix****/
            double[][] doubleMatrix = dataset.getDataTable().getDoubleMatrix();

            //no of rows =i
            for (int i = 0; i < doubleMatrix.length; i++) {
                double[] ds = doubleMatrix[i];

                /**
                 * *first value in row **
                 */
                double d1 = ds[0];
                if (attributes.get(0).isNominal()) {

                    string += attributes.get(0).getNominalValueFromIndex(d1);

                } else if (attributes.get(0).isDate()) {

                    Date date = KonverterTipova.Konvertuj(d1);
                    String format = csvFormat.getDatePattern();
                    String dateInFormat = new SimpleDateFormat(format).format(date);
                    string += (dateInFormat);
                } else {
                    string += (String.valueOf(d1));
                }
                /**
                 * *end of first value in row **
                 */
                //no of columns =j
                for (int j = 1; j < ds.length; j++) {
                    double d = ds[j];

                    if (attributes.get(j).isNominal()) {

                        String value = attributes.get(j).getNominalValueFromIndex(d);
                        string += (',' + value);
                    } else if (attributes.get(j).isDate()) {

                        Date date = KonverterTipova.Konvertuj(d);
                        //String format= da.getDatePattern();
                        String format = csvFormat.getDatePattern();
                        String dateInFormat = new SimpleDateFormat(format).format(date);
                        string += (',' + dateInFormat);
                    } else {
                        string += (',' + String.valueOf(d));
                    }
                }
                if (i != (doubleMatrix.length - 1)) {
                    string += "\n";
                }
            }
            //*******end write dataMatrix****/
        
        return string;
    }
}
