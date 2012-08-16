///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package data;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import logic.ControllerAL_Main;
//import logic.SO.Pretrazi;
//import logic.SO.serialization.Deserialize;
//import model.dataset.Dataset;
//import model.dataset.DatasetWrapper;
//import model.dataset.MetaDataSet;
//
///**
// *
// * @author Jelena
// */
//public class DataSetCollection {
//    List<Dataset> datasets=ControllerAL_Main.getInstance().getAllDataSets();
//    ArrayList<DatasetWrapper> datasetstable= new ArrayList<DatasetWrapper>();
//    MetaDataSet mds=new MetaDataSet();
//    DatasetWrapper mdswr= new DatasetWrapper();
//
//    List<File> files= new ArrayList<File>();
//    
//    
//    private DataSetCollection() {
//        String pretrazi = Pretrazi.Pretrazi(mds);
//        System.out.println(pretrazi);
//        try {
//            try {
//                datasets= new ArrayList<Dataset>();
//                String currentUserName=System.getProperty("user.name");
//                
//                mds=(MetaDataSet) Deserialize.deserialize("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + 0 + "_" + "MetaDataSet");
//                datasets.add(0, mds);
//            } catch (IOException ex) {
//                if(mds==null){
//                    mds= new MetaDataSet();
//                    mds.setDataSetID(0);
//                    mds.setTitle("MetaDataSet");
//                    String currentUserName=System.getProperty("user.name");
//                    mds.setFilePath("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + 0 + "_" + "MetaDataSet");
//                    datasets.add(mds);
//                }
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(DataSetCollection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ArrayList<Dataset> dss = (ArrayList<Dataset>) Deserialize.deserialize(mds.getDatasets());
//            for (Dataset dataSet : dss) {
//                datasets.add(dataSet);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(DataSetCollection.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DataSetCollection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public static DataSetCollection getInstance() {
//        return DataSetCollectionHolder.INSTANCE;
//    }
//    
//    private static class DataSetCollectionHolder {
//
//        private static final DataSetCollection INSTANCE = new DataSetCollection();
//    }
//    
//    public void addDataSet(Dataset ds){
//        datasets.add(ds);
//    }
//
//    public List<Dataset> getDatasets() {
//        return datasets;
//    }
//
//    public void setDatasets(ArrayList<Dataset> datasets) {
//        this.datasets = datasets;
//    }
//
//    public MetaDataSet getMetaDataSet() {
//        return mds;
//    }
//
//    public ArrayList<DatasetWrapper> getDatasetstable() {
//        return datasetstable;
//    }
//
//    public void setDatasets(List<Dataset> datasets) {
//        this.datasets = datasets;
//    }
//
//    public void setDatasetstable(ArrayList<DatasetWrapper> datasetstable) {
//        this.datasetstable = datasetstable;
//    }
//    
//    public void getDataTable(Dataset dataset){
//        for (int i = 0; i < 10; i++) {
//            
//        }
//    }
//}
