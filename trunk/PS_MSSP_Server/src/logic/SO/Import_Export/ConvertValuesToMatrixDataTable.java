/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import model.attribute.Attribute;
import model.attribute.DateAttribute;
import model.attribute.NominalAttribute;
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
                NominalAttribute na = (NominalAttribute) a;
                Double d = na.getIndexOfNominalValue(string);
              
                dataTable.add(i, index, d);

            }
        } else if (a.isNumerical()) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                Double d = Double.parseDouble(string);
                dataTable.add(i, index, d);

            }

        } else if (a.isOrdinal()) {
        } else if (a.isDate()) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                DateAttribute da = (DateAttribute) a;
                //Date date = new SimpleDateFormat(da.getDatePatern()).parse(string);
                Date date = new Date();
                Double d = Double.valueOf(date.getTime());
                dataTable.add(i, index, d);

            }
        } else if (a.isInterval()) {
        }



    }
}
