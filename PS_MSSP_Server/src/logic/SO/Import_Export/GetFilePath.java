/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.io.File;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class GetFilePath {
    public static String getFilePath(Dataset dataset){
        String currentUserName = System.getProperty("user.name");
        String filePath = "C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\" + dataset.getDataSetID() + "_" + dataset.getTitle()+".ds";
        dataset.setFilePath(filePath);
        
        File file = new File("C:\\Users\\" + currentUserName + "\\Documents\\DataSetSimilarity\\");
        
        if(!file.exists()){
            file.mkdirs();
        }
        
        return filePath;
    }
}
