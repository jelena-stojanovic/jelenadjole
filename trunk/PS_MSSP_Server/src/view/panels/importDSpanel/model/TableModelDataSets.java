/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.ControllerAL_MetaAttribute;
import model.dataset.Dataset;
import model.dataset.Dsmetaattribute;
import model.dataset.MetaAttributesAndStatisticsColection;

/**
 *
 * @author Jelena
 */
public class TableModelDataSets extends AbstractTableModel{
    List<Dataset> datasets= new ArrayList<Dataset>();
    ArrayList<Dsmetaattribute> dataMetaAttributes= ControllerAL_MetaAttribute.getInstance().getAllDsmetaattributes();

    public TableModelDataSets(ArrayList<Dataset> datasets) {
        this.datasets= datasets;
    }

    @Override
    public int getRowCount() {
        return datasets.size();
    }

    @Override
    public int getColumnCount() {
        return Dataset.vratiZaglavlje().length+dataMetaAttributes.size();
    }

    @Override
    public String getColumnName(int column) {
        if(column<Dataset.vratiZaglavlje().length){
            return Dataset.vratiZaglavlje()[column];
        }else{
            return dataMetaAttributes.get(column-Dataset.vratiZaglavlje().length).getDsmetaattributeName();
        }
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dataset ds= datasets.get(rowIndex);
        Object[] objs= ds.vratiVrednostiPolja();
        if(columnIndex<Dataset.vratiZaglavlje().length){
            return objs[columnIndex];
        }else{
            Dsmetaattribute dSMetaAttribute= dataMetaAttributes.get(columnIndex-Dataset.vratiZaglavlje().length);
            //String string=MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames()[columnIndex-Dataset.vratiZaglavlje().length];
            //Double get = ds.getMetaAttributes().get(string);
            
            return ds.getDataSetMetaAttributeValue(dSMetaAttribute);
        }
    }
   
    public Dataset getDataSet(int rowindex){
        return datasets.get(rowindex);
    }        
}
