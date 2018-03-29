package org.mfh114.chashi.graph;

import java.util.List;

import org.mfh114.chashi.graph.exception.InvalidVertexNameException;

public interface VertexConnection {

	public VertexConnection from(Vertex v);

	public VertexConnection to(Vertex... v);

	public void connect() throws InvalidVertexNameException;

	/**
	 * Return the list of vertexes which are connected with target vertex.
	 * 
	 * @param targetVertex
	 * @return list of vertexes
	 */
	public List<Vertex> getConnectedVertexesOf(Vertex targetVertex);

	public void clear();
}
