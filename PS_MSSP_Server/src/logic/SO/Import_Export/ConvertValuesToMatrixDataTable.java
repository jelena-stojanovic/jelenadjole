/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.attribute.*;
import model.dataset.DataTable;

/**
 *
 * @author Jelena
 */
public class ConvertValuesToMatrixDataTable {

    public static void convert(DataTable dataTable, Attribute a, String[] strings) throws ParseException {

        int index = a.getAttributePK().getIndexOfAttribute();

        if (a.isNominal()) {

            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                
                Double d = a.getIndexOfNominalValue(string);
              
                dataTable.add(i, index, d);

            }
        } else if (a.isNumerical()) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                Double d = Double.parseDouble(string);
                dataTable.add(i, index, d);

            }

        //} else if (a.isOrdinal()) {
        } else if (a.isDate()) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                
                Date date = new SimpleDateFormat("MM/dd/yyyy").parse(string);
                
                Double d = Double.valueOf(date.getTime());
                dataTable.add(i, index, d);

            }
       // } else if (a.isInterval()) {
        }



    }
}
