/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.SO.serialization.Deserialize;
import model.dataset.DataSet;
import model.dataset.MetaDataSet;

/**
 *
 * @author Jelena
 */
public class DataSetCollection {
    ArrayList<DataSet> datasets;
    MetaDataSet mds=null;
    private DataSetCollection() {
        try {
            try {
                datasets= new ArrayList<DataSet>();
                String currentUserName=System.getProperty("user.name");
                mds=(MetaDataSet) Deserialize.deserialize("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + 0 + "_" + "MetaDataSet");
                datasets.add(0, mds);
            } catch (IOException ex) {
                if(mds==null){
                    mds= new MetaDataSet();
                    mds.setDataSetID(0);
                    mds.setTitle("MetaDataSet");
                    String currentUserName=System.getProperty("user.name");
                    mds.setFilePath("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + 0 + "_" + "MetaDataSet");
                    datasets.add(mds);
                }
            } catch (ClassNotFoundException ex) {
                if(mds==null){
                    mds= new MetaDataSet();
                    mds.setDataSetID(0);
                    mds.setTitle("MetaDataSet");
                    String currentUserName=System.getProperty("user.name");
                    mds.setFilePath("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + 0 + "_" + "MetaDataSet");
                    datasets.add(mds);
                }
            }
            ArrayList<DataSet> dss = (ArrayList<DataSet>) Deserialize.deserialize(mds.getDatasets());
            for (DataSet dataSet : dss) {
                datasets.add(dataSet);
            }
        } catch (IOException ex) {
            Logger.getLogger(DataSetCollection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSetCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DataSetCollection getInstance() {
        return DataSetCollectionHolder.INSTANCE;
    }
    
    private static class DataSetCollectionHolder {

        private static final DataSetCollection INSTANCE = new DataSetCollection();
    }
    
    public void addDataSet(DataSet ds){
        datasets.add(ds);
    }

    public ArrayList<DataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(ArrayList<DataSet> datasets) {
        this.datasets = datasets;
    }

    public MetaDataSet getMetaDataSet() {
        return mds;
    }
    
}
