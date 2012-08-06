/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.dataset.DataSet;
import model.dataset.MetaAttributesAndStatisticsColection;

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
        return DataSet.vratiZaglavlje().length+MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames().length;
    }

    @Override
    public String getColumnName(int column) {
        if(column<DataSet.vratiZaglavlje().length){
            return DataSet.vratiZaglavlje()[column];
        }else{
            return MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames()[column-DataSet.vratiZaglavlje().length];
        }
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataSet ds= datasets.get(rowIndex);
        Object[] objs= ds.vratiVrednostiPolja();
        if(columnIndex<DataSet.vratiZaglavlje().length){
            return objs[columnIndex];
        }else{
            String string=MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames()[columnIndex-DataSet.vratiZaglavlje().length];
            Double get = ds.getMetaAttributes().get(string);
            return get;
        }
    }
   
            
}
