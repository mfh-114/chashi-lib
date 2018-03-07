package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

public class VertexMatrix {

	// key = vertex name, value = list of vertexes
	private List<List<Integer>> matrix = new ArrayList<List<Integer>>();
	private List<String> vertexNames = new ArrayList<String>();
	private List<String> sortedVertex = new ArrayList<String>();

	public VertexMatrix(List<String> vertexNames) {
		this.vertexNames = vertexNames;
	}

	public void init() {
		for (int i = 0; i < vertexNames.size(); i++) {

			List<Integer> col = new ArrayList<Integer>();

			for (int j = 0; j < vertexNames.size(); j++)
				col.add(0);

			matrix.add(i, col);
		}
	}

	public List<Integer> getColumn(String vertexName) {

		return matrix.get(indexOfSearchVertexName(vertexName));
	}

	// TODO: Need to be modified by row instead of column
	public boolean isEmptyColumn() {
		boolean isEmpty = false;
		for (int i = 0; i < vertexNames.size(); i++) {
			List<Integer> colForScan = matrix.get(i);
			if (colForScan.isEmpty()) {
				sortedVertex.add(vertexNames.get(i));
				isEmpty = true;

				// remove the entire empty column
				matrix.remove(i);

				// remove the row of position i th (empty column position)
				// ignore if other column's row is empty in that position
				for (int j = 0; j < matrix.size(); i++) {
					// remove i th position row from each column (j)
					if (!matrix.get(j).isEmpty())
						matrix.get(j).remove(i);
				}

				break;
			}
		}
		return isEmpty;
	}

	public void populateColumn(Vertex fromVertex, List<Vertex> toVertexes) {
		// "from" vertex is row vertex. We need to know which row index.
		// "to" vertexes are the columns. Using "from" vertex row index, the
		// column list specific indexes will be populated.

		int rowIndex = indexOfSearchVertexName(fromVertex.getVertexName());

		for (Vertex colVertex : toVertexes) {
			int colIndex = indexOfSearchVertexName(colVertex.getVertexName());

			// set is used to replace the value 0 by 1
			matrix.get(colIndex).set(rowIndex, 1);
		}
	}

	private int indexOfSearchVertexName(String vertexName) {
		int indexOfVertexName = -1;
		for (int i = 0; i < vertexNames.size(); i++) {
			if (vertexNames.get(i) != null && vertexNames.get(i).equals(vertexName)) {
				indexOfVertexName = i;
				break;
			}
		}
		return indexOfVertexName;
	}

	public void clear() {
		if (matrix != null)
			matrix.clear();
		matrix = null;
	}
}
