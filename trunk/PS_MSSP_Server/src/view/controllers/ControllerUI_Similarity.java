/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import javax.swing.JOptionPane;
import logic.SO.similarity.CalculateCosineSimilarity;
import logic.SO.similarity.CalculateEuclidianSimilarity;
import model.dataset.Dataset;
import view.panels.importDSpanel.model.TableModelDataSets;
import view.panels.similarity.PanelSimilarity;

/**
 *
 * @author Jelena
 */
public class ControllerUI_Similarity {

    private PanelSimilarity panelSimilarity;
    Dataset dataset1;
    Dataset dataset2;

    public ControllerUI_Similarity() {
    }

    private void setSelectedDataSets() {
        if (getPanelSimilarity().getTblAllDatasets() != null) {
            int[] indexes = getPanelSimilarity().getTblAllDatasets().getSelectedRows();

            if (indexes.length != 2) {
                JOptionPane.showMessageDialog(getPanelSimilarity(), "You must select two data sets");
            } else {
                dataset1 = ((TableModelDataSets) (getPanelSimilarity().getTblAllDatasets().getModel())).getDataSet(indexes[0]);
                dataset2 = ((TableModelDataSets) (getPanelSimilarity().getTblAllDatasets().getModel())).getDataSet(indexes[1]);
            }
        }
    }

    public double calculateSimilarity() {
        setSelectedDataSets();
        if (panelSimilarity.getCbSimilarity().getSelectedItem().equals(CalculateCosineSimilarity.class.getSimpleName())) {
            return CalculateCosineSimilarity.calculate(dataset1, dataset2);
        } else if (panelSimilarity.getCbSimilarity().getSelectedItem().equals( CalculateEuclidianSimilarity.class.getSimpleName())) {
            return CalculateEuclidianSimilarity.calculate(dataset1, dataset2);
        }

        return -1;
    }

    /**
     * @return the panelSimilarity
     */
    public PanelSimilarity getPanelSimilarity() {
        return panelSimilarity;
    }

    /**
     * @param panelSimilarity the panelSimilarity to set
     */
    public void setPanelSimilarity(PanelSimilarity panelSimilarity) {
        this.panelSimilarity = panelSimilarity;
    }
}
