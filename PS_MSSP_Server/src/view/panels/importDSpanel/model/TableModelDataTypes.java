/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel.model;

import import_csv.GuessValueTypesClass;
import java.awt.Component;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import logic.ControllerAL_DSImport;
import model.attribute.Ontology;

/**
 *
 * @author Jelena
 */
public class TableModelDataTypes extends AbstractTableModel{

    List<String[]> arrayListString; 
    String[] columnIdentifiers;
    List<String[]> metaAttributes= new ArrayList<String[]>();
    
    public TableModelDataTypes(List<String[]> arrayListString, String[] columnIdentifiers) {
        this.arrayListString=arrayListString;
        this.columnIdentifiers=columnIdentifiers;
        metaAttributes.add(new String[columnIdentifiers.length]);//attributes name
        metaAttributes.add(new String[columnIdentifiers.length]);//attributes role
        metaAttributes.add(new String[columnIdentifiers.length]);//attributes type
    }

    
    
    @Override
    public int getRowCount() {
        return arrayListString.size()+3;
    }

    @Override
    public int getColumnCount() {
        return columnIdentifiers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            switch(rowIndex){
                case 0:{
                    if(metaAttributes.get(0)[columnIndex] ==null){
                        metaAttributes.get(0)[columnIndex]= columnIdentifiers[columnIndex];
                    }
                    return metaAttributes.get(0)[columnIndex];
                } 
                    
                case 1: {
                    if(metaAttributes.get(1)[columnIndex] ==null){
                        metaAttributes.get(1)[columnIndex]="Attribute";
                    }   
                    return metaAttributes.get(1)[columnIndex];
                }
                case 2: {
                    if(metaAttributes.get(2)[columnIndex] ==null){
                       
                    String value=arrayListString.get(1)[columnIndex];
                    String value1=arrayListString.get(arrayListString.size()-1)[columnIndex];
                    int index=Math.round((arrayListString.size()-1)/2);
                    String value3=arrayListString.get(index)[columnIndex];
                    String guessed=GuessValueTypesClass.guessValueType(value);
                    System.out.print(guessed+"-");
                    String guessed2=GuessValueTypesClass.guessValueType(value1);
                    System.out.print(guessed2+"-");
                    String guessed3=GuessValueTypesClass.guessValueType(value3);
                    System.out.print(guessed2+"=");
                    String guessedReal= Ontology.NOMINAL_ATTRIBUTE;
                    if(guessed.equals(guessed2)&&guessed.equals(guessed3))
                        guessedReal=guessed;
                    System.out.println(guessedReal);
                     metaAttributes.get(2)[columnIndex]=guessedReal;
                    }
                    return metaAttributes.get(2)[columnIndex];
                    //return GuessValueTypesClass.guessValueType(arrayListString.get(1)[columnIndex]);
                }  
            }
            
            return arrayListString.get(rowIndex-3)[columnIndex];
    }

    /*
    public TableCellEditor getCellEditor(int row, int column){
        switch(row){
                case 0: return new DefaultCellEditor(new JTextField(columnIdentifiers[column]));
                    
                case 1: {
                    JComboBox jcb= new JComboBox();
                    for (String string : Ontology.getAttributeRoles()) {
                        jcb.addItem(string);
                    }
                    jcb.setSelectedIndex(0);
                    
                    return new DefaultCellEditor(jcb);
                }
                case 2: {
                    JComboBox jcb= new JComboBox();
                    for (String string : Ontology.getAttributeTypes()) {
                        jcb.addItem(string);
                    }
                    jcb.setSelectedItem(GuessValueTypesClass.guessValueType(arrayListString.get(1)[column]));
                    return new DefaultCellEditor(jcb);
                }
                default: return getCellEditor(row, column);
           }
            
    }
*/
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(rowIndex){
                case 0: return true;
                case 1: return true;
                case 2: return true;  
            }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(rowIndex<3){
            columnIdentifiers[columnIndex]=(String)aValue;
            metaAttributes.get(rowIndex)[columnIndex]=(String)aValue;
        }
        else{
            arrayListString.get(rowIndex-3)[columnIndex]=(String)aValue;
        }
                
    }
    
    public String getAttributeRole(int index){
      return metaAttributes.get(1)[index] ;
      
    }
    
    public String getAttributeType(int index){
      return metaAttributes.get(2)[index] ;
      
    }
}
