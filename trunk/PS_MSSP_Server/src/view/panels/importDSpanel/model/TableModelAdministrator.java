/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Administrator;

/**
 *
 * @author Jelena
 */
public class TableModelAdministrator extends AbstractTableModel{
    List<Administrator> administrators= new ArrayList<Administrator>();

    public TableModelAdministrator(List<Administrator> administrators) {
        this.administrators = administrators;
    }
    
    @Override
    public int getRowCount() {
        return administrators.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
            Administrator administrator= administrators.get(rowIndex);
           switch(columnIndex){
            case 0: return administrator.getUsername();
            case 1: return administrator.getFirstName();
            case 2: return administrator.getLastName();
            case 3: return administrator.getEmail();
                default: return "ne";
        }
            
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Username";
            case 1: return "Firs name";
            case 2: return "Last Name";
            case 3: return "E-mail";
                default: return "ne";
        }
    }
    
    public Administrator getAdmin(int row){
        return administrators.get(row);
    }
}
