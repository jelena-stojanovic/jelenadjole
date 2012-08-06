/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.dataset.DataSet;

/**
 *
 * @author Jelena
 */
public class TableModelDataSets extends AbstractTableModel{
    List<DataSet> datasets= new ArrayList<DataSet>();

    public TableModelDataSets(ArrayList<DataSet> datasets) {
        this.datasets= datasets;
    }

    @Override
    public int getRowCount() {
        return datasets.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
            
}
