/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.attribute.*;
import model.dataset.Dataset;
import view.panels.importDSpanel.model.TableModelDataTypes;

/**
 *
 * @author Jelena
 */
public class AttributeFactory {
    public static List<Attribute> createAttributes(Dataset ds,TableModelDataTypes tmdt ) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {

        List<Attribute> attributes = new ArrayList<Attribute>();
        for (int i = 0; i < tmdt.getColumnCount(); i++) {
        
//                String simpleClassName = tmdt.getAttributeType(i) + "attribute";
//                String className = "model.attribute." + simpleClassName;
//                Constructor c = Class.forName(className).getConstructor();
//                
                
                Attribute attribute= new Attribute();
                AttributePK apk= new AttributePK(i, ds.getDataSetID());
                attribute.setAttributePK(apk);
                attribute.setAttributeRole(tmdt.getAttributeRole(i));
                attribute.setName(tmdt.getAttributeName(i));
                attribute.setDataset(ds);
                attribute.setDateAttributeType(tmdt.getAttributeTypeObj(i));
                
                
//                System.out.println(simpleClassName);
//                if(simpleClassName.equals(Nominalattribute.class.getSimpleName())){
//                    Nominalattribute noma = (Nominalattribute)c.newInstance();
//                    
//                    noma.setAttribute(attribute);
//                    NominalattributePK nomapk= new NominalattributePK();
//                    nomapk.setDataSetID(attribute.getAttributePK().getDataSetID());
//                    nomapk.setIndexOfAttribute(attribute.getAttributePK().getIndexOfAttribute());
//                    noma.setNominalattributePK(nomapk);
//                    
//                    attribute.setNominalattribute(noma);
//                    System.out.println("Kreiran novi nominal attribute u attribute factory"+noma.getAttribute().getName());
//                }else if(simpleClassName.equals(Numericalattribute.class.getSimpleName())){
//                    Numericalattribute numa = (Numericalattribute)c.newInstance();
//                    numa.setAttribute(attribute);
//                    
//                    NumericalattributePK numapk= new NumericalattributePK();
//                    numapk.setDataSetID(attribute.getAttributePK().getDataSetID());
//                    numapk.setIndexOfAttribute(attribute.getAttributePK().getIndexOfAttribute());
//                    
//                    numa.setNumericalattributePK(numapk);
//                    
//                    attribute.setNumericalattribute(numa);
//                    System.out.println("Kreiran novi numerical attribute u attribute factory"+numa.getAttribute().getName());
//                }else if(simpleClassName.equals(Dateattribute.class.getSimpleName())){
//                    Dateattribute da = (Dateattribute)c.newInstance();
//                    DateattributePK dpk= new DateattributePK(attribute.getAttributePK().getIndexOfAttribute(), attribute.getAttributePK().getDataSetID());
//                    da.setDateattributePK(dpk);
//                    da.setAttribute(attribute);
//                    
//                    attribute.setDateattribute(da);
//                }
                attributes.add(attribute);
            

        }
        return attributes;
    }

}
