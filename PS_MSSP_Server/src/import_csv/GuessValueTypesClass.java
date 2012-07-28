/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package import_csv;

import model.attribute.Attribute;
import model.attribute.DateAttribute;
import model.attribute.IntervalAttribute;
import model.attribute.NominalAttribute;
import model.attribute.NumericalAttribute;
import model.attribute.OrdinalAttribute;

public class GuessValueTypesClass {

    public static Attribute guessValueType(String value) {
        try {
            Double.parseDouble(value);
            return new NumericalAttribute();
        } catch (NumberFormatException ex) {
            if (value.contains("<") || value.contains(">") || value.contains("=")) {
                return new IntervalAttribute();
            } else if (value.endsWith(".") && countOccurances(value, '.') == 1) {
                return new OrdinalAttribute();
            } else if (value.contains("/") || value.contains("-") || value.contains(".")) {
                return new DateAttribute();
            } else {
                return new NominalAttribute();
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
