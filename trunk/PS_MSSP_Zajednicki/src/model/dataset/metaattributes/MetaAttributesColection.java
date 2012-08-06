/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import java.util.HashMap;

/**
 *
 * @author Jelena
 */
public class MetaAttributesColection {
    
    HashMap<String, Class> mettaAtributes=new HashMap<String, Class>();
    HashMap<String, Class> statistics= new HashMap<String, Class>();
    
    private MetaAttributesColection() {
        //mettaAtributes=UCITAJIZBAZENPR;
        
        //check if there is some new MettaAttribute
        //calculate it on all ds-s
        
        //check if there is some new MettaAttribute
        //calculate it on all ds-s
    }
    
    public static MetaAttributesColection getInstance() {
        return MetaAttributesColectionHolder.INSTANCE;
    }
    
    private static class MetaAttributesColectionHolder {

        private static final MetaAttributesColection INSTANCE = new MetaAttributesColection();
    }
}
