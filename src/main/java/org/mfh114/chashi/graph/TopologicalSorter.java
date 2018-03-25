package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.ErrorCode;

class TopologicalSorter implements Sorter {

	private VertexMatrix matrix;
	private List<Vertex> vertexList;
	private List<Integer> sortedVertexIndexList = new ArrayList<Integer>();
	private List<List<Integer>> sortedVertexGroupIndex = new ArrayList<List<Integer>>();

	public TopologicalSorter(List<Vertex> vertexList, VertexMatrix matrix) {
		this.matrix = matrix;
		this.vertexList = vertexList;
	}

	@Override
	public List<Vertex> sort() throws ChashiException {
		return sort(false);
	}

	@Override
	public List<Vertex> sort(boolean triggerEvent) throws ChashiException {

		System.out.println("Size: " + matrix.size());

		// In this case, matrix size is same as the row and column.
		int rowSize = matrix.size();
		int colSize = rowSize;

		while (sortedVertexIndexList.size() < vertexList.size()) {
			// Hold the group of 0 value columns. At least one or multiple
			// column can be zero per iteration
			List<Integer> zeroValueCols = new ArrayList<Integer>();
			int colIndex = 0;
			while (colIndex < colSize) {

				// skip the process of the column index, if sorted vertex
				// already
				// contains the the same index. Which means, it is already
				// preocessed previously, we will skip this index.
				if (!sortedVertexIndexList.contains(colIndex)) {
					int rowIndex = 0;
					int sum = 0;
					while (rowIndex < rowSize) {

						sum += matrix.getMatrix()[rowIndex][colIndex];

						rowIndex++;
					}
					// if sum is greater than 0 then one or multiple rows
					// contain 1 of the specific column index
					if (sum == 0)
						zeroValueCols.add(colIndex);
				}

				colIndex++;
			}

			if (zeroValueCols != null && !zeroValueCols.isEmpty()) {
				// add vertex to sorted vertex
				sortedVertexGroupIndex.add(zeroValueCols);
				sortedVertexIndexList.addAll(zeroValueCols);

				// set entire row to 0. So 0 column index will be used to get
				// target row which all cells will be zero.
				for (int i = 0; i < zeroValueCols.size(); i++)
					matrix.setRowToZero(zeroValueCols.get(i));
			} else {
				// at least one entire column must be 0 otherwise graph is in
				// loop
				matrix.clear();
				throw new ChashiException(ErrorCode.DUP_VERTEX_NAME, "Cannot procced. Graph is in loop.");
			}
		}

		matrix.clear();

		System.out.println(sortedVertexIndexList.toString());
		System.out.println(sortedVertexGroupIndex.toString());

		if (triggerEvent) {

		}

		return getSortedVertexList(sortedVertexIndexList);
	}

	private List<Vertex> getSortedVertexList(List<Integer> sortedVertexIndexList) {

		// TODO: next version, do not use extra space for storing sorting use
		// the vertexList (original) space.
		List<Vertex> sortedVertexList = new ArrayList<Vertex>();

		for (int i = 0; i < sortedVertexIndexList.size(); i++) {
			sortedVertexList.add(vertexList.get(sortedVertexIndexList.get(i)));
		}

		return sortedVertexList;
	}
	
	public List<List<Integer>> getSortedVertexGroupIndexes(){
		return sortedVertexGroupIndex;
	}
}
