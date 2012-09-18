/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Message;

/**
 *
 * @author Jelena
 */
public class TableModelMessages extends AbstractTableModel {

    private List<Message> messages;

    public TableModelMessages(List<Message> messages) {
        this.messages = messages;

    }

    @Override
    public int getRowCount() {
        if (messages == null) {
            return 0;
        }
        return messages.size();
    }

    @Override
    public int getColumnCount() {

        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Message message = messages.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return message.getSendUser().getUsername();
            case 1:
                return message.getRecieveUser().getUsername();
            case 2:
                return message.getmText();
            default:
                return "Never";
        }
    }
}
