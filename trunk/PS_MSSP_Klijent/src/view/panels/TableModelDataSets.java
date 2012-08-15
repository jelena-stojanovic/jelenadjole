/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.dataset.Dataset;
import model.dataset.MetaAttributesAndStatisticsColection;

/**
 *
 * @author Jelena
 */
public class TableModelDataSets extends AbstractTableModel{
    List<Dataset> datasets= new ArrayList<Dataset>();

    public TableModelDataSets(ArrayList<Dataset> datasets) {
        this.datasets= datasets;
    }

    @Override
    public int getRowCount() {
        return datasets.size();
    }

    @Override
    public int getColumnCount() {
        return Dataset.vratiZaglavlje().length+MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames().length;
    }

    @Override
    public String getColumnName(int column) {
        if(column<Dataset.vratiZaglavlje().length){
            return Dataset.vratiZaglavlje()[column];
        }else{
            return MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames()[column-Dataset.vratiZaglavlje().length];
        }
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dataset ds= datasets.get(rowIndex);
        Object[] objs= ds.vratiVrednostiPolja();
        if(columnIndex<Dataset.vratiZaglavlje().length){
            return objs[columnIndex];
        }else{
            String string=MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames()[columnIndex-Dataset.vratiZaglavlje().length];
            Double get = ds.getMetaAttributes().get(string);
            return get;
        }
    }
   
    public Dataset getDataSet(int rowindex){
        return datasets.get(rowindex);
    }        
}
