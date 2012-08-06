/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.util.HashMap;
import tools.ReflectionTools;

/**
 *
 * @author Jelena
 */
public class MetaAttributesAndStatisticsColection {
    
    HashMap<String, Class> mettaAtributes=new HashMap<String, Class>();
    HashMap<String, Class> statistics= new HashMap<String, Class>();
    private String[] availableStatisticsImplementationClassNames = ReflectionTools.getComponentClassNamesForSubproblem(model.statistics.NumericalStatistic.class);
    private String[] availableMetaAttributeImplementationClassNames = ReflectionTools.getComponentClassNamesForSubproblem(model.dataset.metaattributes.DSMetaAttribute.class);
    
    private MetaAttributesAndStatisticsColection() {
        //mettaAtributes=UCITAJIZBAZENPR;
        
        //check if there is some new MettaAttribute
        //calculate it on all ds-s
        
        //check if there is some new MettaAttribute
        //calculate it on all ds-s
    }
    
    public static MetaAttributesAndStatisticsColection getInstance() {
        return MetaAttributesColectionHolder.INSTANCE;
    }

    public String[] getAvailableMetaAttributeImplementationClassNames() {
        
        return availableMetaAttributeImplementationClassNames;
    }

    public String[] getAvailableStatisticsImplementationClassNames() {
        return availableStatisticsImplementationClassNames;
    }
    
    
    private static class MetaAttributesColectionHolder {

        private static final MetaAttributesAndStatisticsColection INSTANCE = new MetaAttributesAndStatisticsColection();
    }
}
