package org.mfh114.chashi.graph;

public interface VertexConnection {

	public VertexConnection from(Vertex v);

	public VertexConnection to(Vertex... v);

	public void connect();
	
	public void clear();
}
