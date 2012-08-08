/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset;

import java.io.Serializable;
import org.ejml.data.DenseMatrix64F;

/**
 *
 * @author Jelena
 */
public class DataTable implements Serializable{

    DenseMatrix64F matrix;
    double[][] data;
    int row;
    int column;
    
    public DataTable(double[][] data) {
        //matrix = new DenseMatrix64F(data);
        this.data=data;
        row= data.length;
        column=data[0].length;
    }

    public DataTable(int numRow, int numCol) {
        data= new double[numRow][numCol];
        this.row=numRow;
        this.column=numCol;
    }

    public void setMatrix(DenseMatrix64F matrix) {
        this.matrix = matrix;
    }

    public DenseMatrix64F getMatrix() {
        return matrix;
    }
    
    public double[][] getDoubleMatrix(){
        /*double[][] doubleMatrix= new double[getNumRows()][getNumColums()];
        
        for (int i = 0; i < doubleMatrix.length; i++) {
            double[] ds = doubleMatrix[i];
            for (int j = 0; j < ds.length; j++) {
                double d = ds[j];
                doubleMatrix[i][j]=d;
            }
        }
        
        return doubleMatrix;*/
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public double[][] getData() {
        return data;
    }
    
    

    public double getValue(int row, int column) {
        //return matrix.get(row, column);
        return data[row][column];
    }

    public int getIndex(int row, int col) {
        return row * this.column + col;
        
    }

    public void set(int row, int column, double value) {
       // matrix.set(row, column, value);
        data[row][column]=value;
    }

    public void add(int row, int col, double value) {
        //matrix.add(row, col, value);
        data[row][col]=value;
    }

    public int getNumElements() {
     
        //return matrix.getNumElements();
        return row*column;
    }
    
    public double[] getColumn(int columnIndex){
        double[] columnValues=new double[row];
        for (int i = 0; i < row; i++) {
            //columnValues[i]= matrix.get(i, columnIndex);   
            columnValues[i]=data[i][columnIndex];
        }
        return columnValues;
    }
    
    public double[] getRow(int rowIndex){
        
        double[] rowValues= new double[column];
        /*
         *  for (int i = 0; i < column; i++) {
            //rowValues[i]=matrix.get(rowIndex, i);
            rowValues[i]=data[rowIndex][i];
        }

         */
        System.arraycopy(data[rowIndex], 0, rowValues, 0, column);
        return rowValues;
    }
    
    public void setNumRows(int numRows){
        //matrix.numRows=numRows;
        row=numRows;
        if(column!=0)
            data=new double[numRows][column];
    }
    
    public int getNumRows(){
        //return matrix.getNumRows();
        return row;
    }
    
    public void setNumColums(int numColums){
        //matrix.numCols=numColums;
        column=numColums;
        if(row!=0)
            data= new double[row][numColums];
        
    }
    public int getNumColums(){
        //return matrix.getNumElements()/matrix.getNumRows();
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
}
