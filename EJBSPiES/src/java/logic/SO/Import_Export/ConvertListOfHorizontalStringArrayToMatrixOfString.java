/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO.Import_Export;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class ConvertListOfHorizontalStringArrayToMatrixOfString {

    public static String[][] convert(List<String[]> dsValues, String[][] stringMatrix) {
        List<String[]> attributeStringValueVertical = new ArrayList<String[]>();

        for (int i = 0; i < dsValues.get(0).length; i++) {
            attributeStringValueVertical.add(new String[dsValues.size()]);
        }
        for (int i = 0; i < dsValues.size(); i++) {
            String[] stringrow = dsValues.get(i); //red u prvoj matrici

            for (int j = 0; j < stringrow.length; j++) {
                String stringValue = stringrow[j];// red i u prvoj listi, j kolona
                stringMatrix[i][j] = stringValue;
                attributeStringValueVertical.get(j)[i] = stringValue;
            }
        }

//        for (int i = 0; i < attributeStringValueVertical.size(); i++) {
//            String[] strings = attributeStringValueVertical.get(i);
//            for (int j = 0; j < strings.length; j++) {
//                String string = strings[j];
//                System.out.print(string + ", ");
//
//            }
//
//
//            System.out.println();
//
//        }

        return stringMatrix;
    }
}
