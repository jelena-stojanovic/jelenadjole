/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.tableModels;

import java.util.List;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.Status;


/**
 *
 * @author Jelena
 */
public class TableModelStatus extends AbstractTableModel {

    private List<Status> statuses;

    public TableModelStatus(List<Status> statuses) {
        this.statuses = statuses;
    }
    @Override
    public int getRowCount() {
        if (statuses == null) {
            return 0;
        }
        return statuses.size();
    }

    @Override
    public int getColumnCount() {

        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Status status = statuses.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return status.getFpuser().getUsername();
            case 1:
                return status.getStatusText();
            case 2:
                return status.getAreaOfInterest().getAreaName();
            case 3:
                return status.getNoLike();
            case 4:
                return status.getNofacePalm();
            default:
                return "Never";

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Korisničko ime";
            case 1:
                return "Status";
            case 2:
                return "Oblast status";
            case 3:
                return "Broj lajkova";
            case 4:
                return "Broj facepalmo-va";
            
            default:
                return "Never";

        }
    }

    public Status getStatus(int rowIndex) {
        return statuses.get(rowIndex);
    }
    
    
}
