/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.util.ArrayList;
import java.util.List;
import model.attribute.*;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public class AttributeFactory {

    public static List<Attribute> createAttributes(Dataset ds, ArrayList<String[]> metaattributes) {

        List<Attribute> attributes = new ArrayList<Attribute>();
        if (metaattributes == null) {
            return attributes;
        }
        for (int i = 0; i < metaattributes.get(0).length; i++) {
            Attribute attribute = new Attribute();
            AttributePK apk = new AttributePK(i, ds.getDataSetID());
            attribute.setAttributePK(apk);
            attribute.setAttributeRole(metaattributes.get(1)[i]);
            attribute.setName(metaattributes.get(0)[i]);
            attribute.setDataset(ds);
            attribute.setDateAttributeType(Ontology.getAttributeTypeObject(metaattributes.get(2)[i]));

            attributes.add(attribute);


        }
        return attributes;
    }
}
