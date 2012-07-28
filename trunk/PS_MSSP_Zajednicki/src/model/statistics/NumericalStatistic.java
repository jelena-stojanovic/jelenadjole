/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.statistics;

import java.util.ArrayList;
import java.util.List;
import tools.ReflectionTools;

/**
 *
 * @author Jelena
 */
public abstract class NumericalStatistic {

    private static String[] availableImplementationClassNames = ReflectionTools.getComponentClassNamesForSubproblem(model.statistics.NumericalStatistic.class);

    public abstract double calculate(double[] valuesArray);

    /**
     * @return the availableImplementationClassNames
     */
    public static String[] getAvailableImplementationClassNames() {
        return availableImplementationClassNames;
    }

   
}
