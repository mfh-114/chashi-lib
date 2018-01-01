package org.mfh114.chashi.graph;

public interface VertexConnection {

	public VertexConnection from(Vertex v);

	public VertexConnection to(Vertex... v);

	public VertexConnection connect();

	public void clear();
}
