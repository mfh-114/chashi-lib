package org.mfh114.chashi.core;

public class Graph {

	private EdgeRepresention edgeRepresention;

	public Graph(EdgeRepresention edgeRepresention) {
		this.edgeRepresention = edgeRepresention;
	}

	public void addVertex(Vertex vertex) {
		edgeRepresention.addVertex(vertex);
	}

	@SuppressWarnings("unchecked")
	public <T> T render() {
		return (T) edgeRepresention.render();
	}
}
