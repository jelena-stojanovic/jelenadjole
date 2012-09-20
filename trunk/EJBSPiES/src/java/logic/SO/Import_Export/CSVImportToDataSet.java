/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Jelena
 */
public class CSVImportToDataSet {

    public static ArrayList<String[]> readCSV(String filePath, char columnSeparator) throws IOException {
        if (filePath == null) {
            return new ArrayList<String[]>();
        }
        File file = new File(filePath);
        BufferedReader bufRdr = new BufferedReader(new FileReader(file));
        String line = null;
        ArrayList<String[]> datasetList = new ArrayList<String[]>();
        while ((line = bufRdr.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, String.valueOf(columnSeparator));
            int size = st.countTokens();
            String[] lineInDataset = new String[size];

            for (int i = 0; i < size; i++) {
                lineInDataset[i] = st.nextToken();
            }
            datasetList.add(lineInDataset);
        }
        bufRdr.close();
        return datasetList;
    }
}
