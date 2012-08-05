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

    public DataTable() {
        matrix= new DenseMatrix64F();
    }

    public void setMatrix(DenseMatrix64F matrix) {
        this.matrix = matrix;
    }

    public DenseMatrix64F getMatrix() {
        return matrix;
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
    
    public double[] getColumn(int columnIndex){
        int noRows= matrix.getNumRows();
        double[] columnValues=new double[noRows];
        for (int i = 0; i < noRows; i++) {
            columnValues[i]= matrix.get(i, columnIndex);   
        }
        return columnValues;
    }
    
    public double[] getRow(int rowIndex){
        int noColums= matrix.getNumElements()/matrix.getNumRows();
        double[] rowValues= new double[noColums];
        for (int i = 0; i < noColums; i++) {
            rowValues[i]=matrix.get(rowIndex, i);
        }
        return rowValues;
    }
    
    public void setNumRows(int numRows){
        matrix.numRows=numRows;
    }
    
    public int getNumRows(){
        return matrix.getNumRows();
    }
    
    public void setNumColums(int numColums){
        matrix.numCols=numColums;
    }
    public int getNumColums(){
        return matrix.getNumElements()/matrix.getNumRows();
    }
    
    public double[][] getDoubleMatrix(){
        double[][] doubleMatrix= new double[getNumRows()][getNumColums()];
        
        for (int i = 0; i < doubleMatrix.length; i++) {
            double[] ds = doubleMatrix[i];
            for (int j = 0; j < ds.length; j++) {
                double d = ds[j];
                doubleMatrix[i][j]=d;
            }
        }
        
        return doubleMatrix;
    }
}
