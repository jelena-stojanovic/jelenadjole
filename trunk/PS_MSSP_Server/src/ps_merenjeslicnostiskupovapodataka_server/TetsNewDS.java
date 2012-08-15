/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ps_merenjeslicnostiskupovapodataka_server;

import logic.SO.KreirajNovi;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class TetsNewDS {
    public static void main(String[] args) {
      /*  char columnSeparator= ',';
        boolean useFirstRow= true;
        String filePath="C:\\Users\\Jelena\\Desktop\\Iris.csv";
        File file = new File(filePath);
        CSVFormat csvFormat= new CSVFormat(file);
        csvFormat.setColumnSeparator(columnSeparator);
        csvFormat.setUseFirstRowAsAttributeNames(useFirstRow);
        //csv.set... 
        */
        //List<Attribute> attributes= new ArrayList<Attribute>();
        Dataset dataSet = new Dataset();
        
        System.out.println(KreirajNovi.kreirajNovi(dataSet));
        System.out.println(dataSet.getDataSetID());
       
        
        
    }
    
}
