/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import model.dataFormat.CSVFormat;
import model.dataset.Dataset;
import to.DataSetTO;

/**
 *
 * @author Jelena
 */
@Local
public interface SessionBeanDatasetLocal {
 
    List<DataSetTO> getAllDatasetsTO();

    List<Dataset> getAllDatasets();
    
    Dataset getDataset(Dataset ds);
    public void saveDataset(Dataset ds,ArrayList<String[]>metaAttributes , ArrayList<String[]> stringArrayList);
    int createDataset(Dataset ds);
    void saveDataset(Dataset ds);
    void updateDataset(Dataset ds);
    String exportDS(Dataset ds, CSVFormat csv);
    ArrayList<String[]> readCSV(String filePath, char columnSeparator);
    String[][] convert(List<String[]> dsValues, String[][] stringMatrix);
}
