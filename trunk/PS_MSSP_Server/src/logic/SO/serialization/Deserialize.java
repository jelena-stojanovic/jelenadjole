/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class Deserialize {
    /*public static List<DataSet> deserialize(List<String> filepaths) throws IOException, ClassNotFoundException{
        List<DataSet> datasets=new ArrayList<DataSet>();
        for (String filepath : filepaths) {
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filepath));
            DataSet ds=(DataSet) ois.readObject();
            datasets.add(ds);
        }
        return datasets;
    }*/
    
    public static List<DataSet> deserialize(List<File> files) throws IOException, ClassNotFoundException{
        List<DataSet> datasets=new ArrayList<DataSet>();
        for (File file : files) {
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream(file));
            DataSet ds=(DataSet) ois.readObject();
            datasets.add(ds);
        }
        return datasets;
    }
    
        public static DataSet deserialize(String filepath) throws IOException, ClassNotFoundException{
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filepath));
            DataSet ds=(DataSet) ois.readObject();
            return ds;
    }

    
}
