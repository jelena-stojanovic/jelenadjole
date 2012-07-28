/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import org.ejml.data.DenseMatrix64F;

/**
 *
 * @author Jelena
 */
public class DataTable {

    DenseMatrix64F matrix;

    public DataTable(double[][] data) {
        matrix = new DenseMatrix64F(data);
    }

    public void setMatrix(DenseMatrix64F matrix) {
        this.matrix = matrix;
    }

    public double getValue(int row, int column) {
        return matrix.get(row, column);
    }

    public int getIndex(int row, int col) {
        return matrix.getIndex(row, col);
    }

    public void set(int row, int column, double value) {
        matrix.set(row, column, value);
    }

    public void add(int row, int col, double value) {
        matrix.add(row, col, value);
    }

    public int getNumElements() {
        return matrix.getNumElements();
    }
}
