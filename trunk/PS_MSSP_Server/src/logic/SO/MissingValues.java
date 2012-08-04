/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.SO;

/**
 *
 * @author Djordje
 */
public class MissingValues {

    public static int countMissingValues(String[] column) {
        int count = 0;
        for (String string : column) {
            if (string == null || string.equals("?") || string.equals("")) {
                count++;
            }
        }
        return count;

    }
}
