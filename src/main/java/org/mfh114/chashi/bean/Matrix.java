package org.mfh114.chashi.bean;

import java.util.Arrays;

public class Matrix {

	private Object[][] matrix;

	public Matrix(int rowSize, int colSize){
		this.matrix = new Object[rowSize][colSize];
	}
	
	public void setValue(Object value, int rowIndex, int colIndex){
		this.matrix[rowIndex][colIndex] = value;
	}
	
	public Object getValue(int rowIndex, int colIndex){
		return matrix[rowIndex][colIndex];
	}
	
	public Object[] getColValuesOfRow(int rowIndex){
		return matrix[rowIndex];
	}

	@Override
	public String toString() {
		return "Matrix [matrix=" + Arrays.toString(matrix) + "]";
	}
	
	
}
