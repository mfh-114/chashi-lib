package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

import org.mfh114.chashi.graph.exception.InvalidVertexNameException;

class VertexConnectionImpl implements VertexConnection {

	// key = vertex name, value = list of vertexes
	private VertexMatrix matrix = null;

	private Vertex startVertex;
	private List<Vertex> endVertexes;
	private List<Vertex> vertexList;

	public VertexConnectionImpl(List<Vertex> vertexList, VertexMatrix matrix) {
		this.matrix = matrix;
		this.startVertex = null;
		this.vertexList = vertexList;
		this.endVertexes = new ArrayList<Vertex>();
	}

	@Override
	public VertexConnection from(Vertex vertex) {

		startVertex = vertex;

		return this;
	}

	@Override
	public VertexConnection to(Vertex... vertexArr) {
		endVertexes = new ArrayList<Vertex>();

		for (Vertex v : vertexArr) {
			endVertexes.add(v);
		}
		return this;
	}

	@Override
	public void connect() throws InvalidVertexNameException {

		matrix.populateColumn(startVertex, endVertexes);

		// return this;
	}

	public VertexMatrix getVertexMatrix() {
		return matrix;
	}

	public void clear() {
		if (matrix != null)
			matrix.clear();
	}

	@Override
	public List<Vertex> getConnectedVertexesOf(Vertex targetVertex) {

		int index = vertexList.indexOf(targetVertex);

		int[] columnIndexesArr = matrix.getMatrix()[index];

		List<Vertex> columIndexes = new ArrayList<Vertex>();
		for (int i = 0; i < columnIndexesArr.length; i++) {

			// get i th index of the vertex where matrix value is 1
			int value = matrix.getMatrix()[index][i];
			if (value == 0)
				continue;

			Vertex v = vertexList.get(i);
			columIndexes.add(v);
		}

		return columIndexes;
	}
}
