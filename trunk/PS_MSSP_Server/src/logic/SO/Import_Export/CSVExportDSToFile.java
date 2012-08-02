/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.attribute.Attribute;
import model.attribute.NominalAttribute;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class CSVExportDSToFile {

    List<Attribute> attributes = null;

    public void export(String filePath, DataSet dataset, boolean writeAttributeName, char columnSeparator) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            attributes = dataset.getAttributes();
            List<Integer> nominalAttributeIndexes = getNominalAttributeIndex();

            if (writeAttributeName == true) {
                out.write(attributes.get(0).getName());

                for (int i = 1; i < attributes.size(); i++) {
                    Attribute attribute = attributes.get(i);
                    out.print(columnSeparator + attribute.getName());
                }
                out.println();
            }

            int noOfColums = dataset.getDataTable().getNumColums();
            int noOfRows = dataset.getDataTable().getNumRows();
            double[][] doubleMatrix = dataset.getDataTable().getDoubleMatrix();
            //                               trebalo bi da je broj redova
            for (int i = 0; i < doubleMatrix.length; i++) {
                double[] ds = doubleMatrix[i];
                out.print(String.valueOf(ds[0]));
                //                      broj kolona
                for (int j = 1; j < ds.length; j++) {
                    double d = ds[j];
                    if (nominalAttributeIndexes.contains(j)) {
                        try {
                           out.print(MappingValues.getNominalValueFromIndex(((NominalAttribute)attributes.get(j)).getClassToIndexMap(),d));
                        } catch (Exception ex) {
                            Logger.getLogger(CSVExportDSToFile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        out.print(',' + String.valueOf(d));
                    }
                }
                out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVExportDSToFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }


    }

    private List<Integer> getNominalAttributeIndex() {
        List<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            if (attribute.isNominal()) {
                indexes.add(i);
            }
        }

        return indexes;
    }
}
