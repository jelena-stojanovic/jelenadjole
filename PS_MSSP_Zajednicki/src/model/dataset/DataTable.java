/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;

/**
 *
 * @author Jelena
 */
public class DataTable implements Serializable{

    private Dataset dataSet;
    double[][] data;
    int row;
    int column;
    
    public DataTable(double[][] data) {
        
        this.data=data;
        row= data.length;
        column=data[0].length;
    }

    public DataTable(int numRow, int numCol) {
        data= new double[numRow][numCol];
        this.row=numRow;
        this.column=numCol;
    }

    public double[][] getDoubleMatrix(){
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public double[][] getData() {
        return data;
    }
    
    

    public double getValue(int row, int column) {
        return data[row][column];
    }

    public int getIndex(int row, int col) {
        return row * this.column + col;
        
    }

    public void set(int row, int column, double value) {
        data[row][column]=value;
    }

    public void add(int row, int col, double value) {
        data[row][col]=value;
    }

    public int getNumElements() {
        return row*column;
    }
    
    public double[] getColumn(int columnIndex){
        double[] columnValues=new double[row];
        for (int i = 0; i < row; i++) {
            columnValues[i]=data[i][columnIndex];
        }
        return columnValues;
    }
    
    public double[] getRow(int rowIndex){
        
        double[] rowValues= new double[column];
        System.arraycopy(data[rowIndex], 0, rowValues, 0, column);
        return rowValues;
    }
    
    public void setNumRows(int numRows){
        row=numRows;
        if(column!=0)
            data=new double[numRows][column];
    }
    
    public int getNumRows(){
        return row;
    }
    
    public void setNumColums(int numColums){
        column=numColums;
        if(row!=0)
            data= new double[row][numColums];
        
    }
    public int getNumColums(){
        return column;
    }
    
    public void addColumn(double[] columnData){
        double[][] oldMatrix=data;
        column++;
        double[][] newMatrix= new double[row][column];
        for (int i = 0; i < newMatrix.length; i++) {
            System.arraycopy(oldMatrix[i], 0, newMatrix[i], 0, column-1);
            newMatrix[i][column-1]=columnData[i];
        }
     data= newMatrix;   
    }
    
    public void addRow(double[] rowd){
        double[][] oldMatrix=data;
        double[][] newMatrix= new double[row+1][column];
        for (int i = 0; i < newMatrix.length-1; i++) {
            System.arraycopy(oldMatrix, 0, newMatrix, 0, (row)*column);
                    }
        newMatrix[row]=rowd;
        row++;
        data= newMatrix;   
    }

    /**
     * @return the dataSet
     */
    public Dataset getDataSet() {
        return dataSet;
    }

    /**
     * @param dataSet the dataSet to set
     */
    public void setDataSet(Dataset dataSet) {
        this.dataSet = dataSet;
    }
}
