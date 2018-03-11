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
		while (true) {

			// Hold the group of empty columns. At least one or multiple
			// column can be empty per iteration
			List<Integer> emptyCols = new ArrayList<Integer>();

			// cols
			for (int i = 0; i < matrix.getMatrix().size(); i++) {

				List<Integer> cols = matrix.getMatrix().get(i);

				// rows of the column
				int sum = cols.parallelStream().mapToInt(e -> e.intValue()).sum();

				// if sum is greater than 0 then one or multiple rows contain 1
				// of the specific column
				if (sum > 0) {
					continue;
				} else {
					emptyCols.add(i);
				}
			}

			if (emptyCols != null && !emptyCols.isEmpty()) {

				// add vertex to sorted vertex
				sortedVertexGroupIndex.add(emptyCols);
				sortedVertexIndexList.addAll(emptyCols);

				// remove the entire empty column
				for (int x = 0; x < emptyCols.size(); x++) {
					int pos = emptyCols.get(x);
					matrix.getMatrix().remove(pos);

					// remove the row of position i th (empty column position)
					// ignore if other column's row is empty in that position
					for (int j = 0; j < matrix.getMatrix().size(); j++) {
						// remove indexToRm th position row from each column (j)
						if (!matrix.getMatrix().get(j).isEmpty())
							matrix.getMatrix().get(j).remove(pos);
					}
				}
			} else {
				throw new ChashiException(ErrorCode.GRAPH_IN_LOOP, "Cannot perform topological sort.");
			}

			// break when matrix is empty
			if (matrix.getMatrix().isEmpty())
				break;
		}

		System.out.println(sortedVertexGroupIndex.toString());

		// --------------------------------------------------
		// TODO: use future to create worker thread to handle event.
		// ------------------------------------------------

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
}
