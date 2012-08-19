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
        
                String simpleClassName = tmdt.getAttributeType(i) + "attribute";
                String className = "model.attribute." + simpleClassName;
                Constructor c = Class.forName(className).getConstructor();
                
                
                Attribute attribute= new Attribute();
                AttributePK apk= new AttributePK(i, ds.getDataSetID());
                attribute.setAttributePK(apk);
                attribute.setAttributeRole(tmdt.getAttributeRole(i));
                attribute.setName(tmdt.getAttributeName(i));
                attribute.setDataset(ds);
                
                
                if(simpleClassName.equals(Nominalattribute.class.getName())){
                    Nominalattribute noma = (Nominalattribute)c.newInstance();
                    noma.setAttribute(attribute);
                    NominalattributePK nomapk= new NominalattributePK(attribute.getAttributePK().getIndexOfAttribute(), attribute.getAttributePK().getDataSetID());
                    noma.setNominalattributePK(nomapk);
                    
                    attribute.setNominalattribute(noma);
                }else if(simpleClassName.equals(Numericalattribute.class.getName())){
                    Numericalattribute numa = (Numericalattribute)c.newInstance();
                    numa.setAttribute(attribute);
                    NumericalattributePK numapk= new NumericalattributePK(attribute.getAttributePK().getIndexOfAttribute(), attribute.getAttributePK().getDataSetID());
                    numa.setNumericalattributePK(numapk);
                    
                    attribute.setNumericalattribute(numa);
                }else if(simpleClassName.equals(Dateattribute.class.getName())){
                    Dateattribute da = (Dateattribute)c.newInstance();
                    DateattributePK dpk= new DateattributePK(attribute.getAttributePK().getIndexOfAttribute(), attribute.getAttributePK().getDataSetID());
                    da.setDateattributePK(dpk);
                    da.setAttribute(attribute);
                    
                    attribute.setDateattribute(da);
                }
                attributes.add(attribute);
            

        }
        return attributes;
    }

}
