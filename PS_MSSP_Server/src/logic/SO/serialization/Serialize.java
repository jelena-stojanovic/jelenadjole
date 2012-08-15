/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.serialization;

import data.DataSetCollection;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dataset.Dataset;
import model.dataset.MetaDataSet;

/**
 *
 * @author Jelena
 */
public class Serialize {

    public static void serialize(Dataset dataset, String filePath) throws IOException {
        ObjectOutputStream oos = null;
        File file = new File(filePath);
        if (file != null) {
            try {
                oos = new ObjectOutputStream(new FileOutputStream(filePath));
            } catch (FileNotFoundException ex) {

                String currentUserName = System.getProperty("user.name");
                filePath = "C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + dataset.getDataSetID() + "_" + dataset.getTitle();
                oos = new ObjectOutputStream(new FileOutputStream(filePath));
                oos.writeObject(dataset);
            } finally {
                oos.close();
            }
        }
    }

    public static void serialize(Dataset dataset) throws IOException {

        String currentUserName = System.getProperty("user.name");
        String filePath = "C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + dataset.getDataSetID() + "_" + dataset.getTitle();
        dataset.setFilePath(filePath);
        
        File file = new File("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\");
        
        if(!file.exists()){
            file.mkdirs();
        }
        
        addDSToMDS(dataset, filePath);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dataset);
        oos.close();
        
    }
    
    private static void addDSToMDS(Dataset ds,String filepath){
        if(!(ds instanceof MetaDataSet))
        DataSetCollection.getInstance().getMetaDataSet().getDatasets().add(new File (filepath));
    }
}
