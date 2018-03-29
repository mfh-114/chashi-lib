package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

class VertexMatrix {

	private int[][] matrix = null;
	private int size = 0;
	private List<String> vertexNames = new ArrayList<String>();

	public VertexMatrix(List<String> vertexNames) {
		this.vertexNames = vertexNames;
	}

	public void init() {

		if (this.vertexNames == null || this.vertexNames.isEmpty())
			throw new IllegalArgumentException("Vertex names list is not set.");

		this.size = vertexNames.size();

		// initialize matrix arrays
		matrix = new int[size][size];

		// populate the matrix by 0
		for (int i = 0; i < vertexNames.size(); i++)
			for (int j = 0; j < vertexNames.size(); j++)
				matrix[i][j] = 0;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	/****
	 * Size of the matrix. In this case, row and column will be same size which
	 * is same as total number of vertexes.
	 * 
	 * @return size
	 */
	public int size() {
		return size;
	}

	public void populateColumn(Vertex fromVertex, List<Vertex> toVertexes) {
		// "from" vertex is row vertex. We need to know which row index.
		// "to" vertexes are the columns. Using "from" vertex row index, the
		// column list specific indexes will be populated.

		int rowIndex = indexOfVertex(fromVertex.getVertexName());

		for (Vertex colVertex : toVertexes) {
			int colIndex = indexOfVertex(colVertex.getVertexName());

			// set is used to replace the value 0 by 1
			matrix[rowIndex][colIndex] = 1;
		}
	}

	public void setRowToZero(int rowIndex) {
		for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
			matrix[rowIndex][colIndex] = 0;
		}
	}

	private int indexOfVertex(String vertexName) {
		int indexOfVertex = -1;
		for (int i = 0; i < vertexNames.size(); i++) {
			if (vertexNames.get(i) != null && vertexNames.get(i).equals(vertexName)) {
				indexOfVertex = i;
				break;
			}
		}
		return indexOfVertex;
	}

	public void clear() {
		matrix = null;

		if (vertexNames != null)
			vertexNames.clear();
		vertexNames = null;
	}
}
