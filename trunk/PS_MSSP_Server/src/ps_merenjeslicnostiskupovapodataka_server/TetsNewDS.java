/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ps_merenjeslicnostiskupovapodataka_server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.attribute.Attribute;
import model.dataFormat.CSVFormat;

/**
 *
 * @author Jelena
 */
public class TetsNewDS {
    public static void main(String[] args) {
        char columnSeparator= ',';
        boolean useFirstRow= true;
        String filePath="C:\\Users\\Jelena\\Desktop\\Iris.csv";
        File file = new File(filePath);
        CSVFormat csvFormat= new CSVFormat(file);
        csvFormat.setColumnSeparator(columnSeparator);
        csvFormat.setUseFirstRowAsAttributeNames(useFirstRow);
        //csv.set... 
        
        List<Attribute> attributes= new ArrayList<Attribute>();
        
        
        
    }
    
}
