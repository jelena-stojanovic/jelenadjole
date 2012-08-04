/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels.importDSpanel.model;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.attribute.Ontology;

/**
 *
 * @author Jelena
 */
public class TableDataTypes extends JTable {

    String[] columnIdentifiers;
    ArrayList<String[]> arrayListString;

    public TableDataTypes(JPanel pnlAttributeTypes, JScrollPane jScrollPane3, JButton btnPreviousDataTypes, JButton btnFinish, String[] columnIdentifiers, ArrayList<String[]> arrayListString) {
        this.columnIdentifiers = columnIdentifiers;
        this.arrayListString = arrayListString;
        this.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}));
        jScrollPane3.setViewportView(this);

        javax.swing.GroupLayout pnlAttributeTypesLayout = new javax.swing.GroupLayout(pnlAttributeTypes);
        pnlAttributeTypes.setLayout(pnlAttributeTypesLayout);
        pnlAttributeTypesLayout.setHorizontalGroup(
                pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAttributeTypesLayout.createSequentialGroup().addContainerGap().addGroup(pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane3).addGroup(pnlAttributeTypesLayout.createSequentialGroup().addGap(0, 551, Short.MAX_VALUE).addComponent(btnPreviousDataTypes).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));
        pnlAttributeTypesLayout.setVerticalGroup(
                pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlAttributeTypesLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE).addGap(18, 18, 18).addGroup(pnlAttributeTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnFinish).addComponent(btnPreviousDataTypes)).addGap(21, 21, 21)));

    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        switch (row) {
            case 0:
                return new DefaultCellEditor(new JTextField(columnIdentifiers[column]));

            case 1: {
                JComboBox jcb = new JComboBox();
                for (String string : Ontology.getAttributeRoles()) {
                    jcb.addItem(string);
                }
                jcb.setSelectedIndex(0);
      
                return new DefaultCellEditor(jcb);
            }
            case 2: {
                JComboBox jcb = new JComboBox();
                for (String string : Ontology.getAttributeTypes()) {
                    jcb.addItem(string);
                }
                return new DefaultCellEditor(jcb);
            }
            default:
                return getCellEditor(row, column);
        }

    }

    @Override
    public TableCellRenderer getCellRenderer(int row, int column) {

        return super.getCellRenderer(row, column);
    }

    @Override
    public boolean editCellAt(int row, int column, EventObject e) {
        return super.editCellAt(row, column, e);
    }

    @Override
    public TableCellEditor getCellEditor() {
        return super.getCellEditor();
    }

    @Override
    public void setCellEditor(TableCellEditor anEditor) {
        TableCellEditor oldEditor = cellEditor;
        cellEditor = anEditor;
        firePropertyChange("tableCellEditor", oldEditor, anEditor);
    }
    
    
}
