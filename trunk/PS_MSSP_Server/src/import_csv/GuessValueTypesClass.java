/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package import_csv;

import model.attribute.*;

public class GuessValueTypesClass {

    public static String guessValueType(String value) {
        try {
            Double.parseDouble(value);
            return Ontology.NUMERICAL_ATTRIBUTE;
        } catch (NumberFormatException ex) {
            if (value.contains("<") || value.contains(">") || value.contains("=")) {
                return Ontology.INTERVAL_ATTRIBUTE;
            } else if (value.endsWith(".") && countOccurances(value, '.') == 1) {
                return Ontology.ORDINAL_ATTRIBUTE;
            } else if (value.contains("/") || value.contains("-") || value.contains(".")) {
                return Ontology.DATE_ATTRIBUTE;
            } else {
                return Ontology.NOMINAL_ATTRIBUTE;
            }
        }
    }

    static int countOccurances(String s, char c) {
        char[] split = s.toCharArray();
        int number = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i] == c) {
                number++;
            }
        }
        return number;
    }
}
