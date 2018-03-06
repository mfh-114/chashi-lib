package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class VertexConnectionImpl implements VertexConnection {

	// key = vertex name, value = list of vertexes
	private VertexMatrix matrix = null;

	private Vertex startVertex;
	private List<Vertex> endVertexes;

	public VertexConnectionImpl(List<Vertex> vertexes) {

		matrix = new VertexMatrix(vertexes.stream().map(a -> a.getVertexName()).collect(Collectors.toList()));
		matrix.createColumn();

		this.startVertex = null;
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
	public VertexConnection connect() throws InvalidVertexNameException {

		matrix.populateColumn(startVertex, endVertexes);

		return this;
	}

	public void clear() {
		if (matrix != null)
			matrix.clear();
	}
}
