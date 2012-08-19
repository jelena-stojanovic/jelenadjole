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

        if (a.getNominalattribute()!=null) {

            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                Nominalattribute na = a.getNominalattribute();
                Double d = na.getIndexOfNominalValue(string);
              
                dataTable.add(i, index, d);

            }
        } else if (a.getNumericalattribute()!=null) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                Double d = Double.parseDouble(string);
                dataTable.add(i, index, d);

            }

        //} else if (a.isOrdinal()) {
        } else if (a.getDateattribute()!=null) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                Dateattribute da = a.getDateattribute();
                Date date = new SimpleDateFormat(da.getDatePattern()).parse(string);
                
                Double d = Double.valueOf(date.getTime());
                dataTable.add(i, index, d);

            }
       // } else if (a.isInterval()) {
        }



    }
}
