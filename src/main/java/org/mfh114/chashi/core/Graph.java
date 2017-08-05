package org.mfh114.chashi.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.map.MultiValueMap;
import org.mfh114.chashi.bean.Matrix;

public class Graph {

	private int sequenceIndex;
	private List<Vertex> vertexList;
	private MultiValueMap vertexConnections;

	public Graph() {
		this.sequenceIndex = 0;
		this.vertexList = new ArrayList<Vertex>();
		this.vertexConnections = new MultiValueMap();
	}

	public Vertex createVertex(String name) {
		Vertex v = new VertexImpl(name, sequenceIndex++);
		this.vertexList.add(v);
		return v;
	}

	public List<Vertex> getVertexes() {
		return vertexList;
	}

	/**
	 * Connect a edge from vertex1 to vertex 2.
	 * 
	 * @param vertex1
	 * @param vertex2
	 */
	public void connectVertex(Vertex vertex1, Vertex vertex2) {
		vertexConnections.put(vertex1.getName(), vertex2);
	}

	public Matrix transformToAdjacencyMatrix() {
		System.out.println("size: " + vertexConnections.totalSize());
		int vSize = vertexList.size();
		Matrix matrix = new Matrix(vSize, vSize);

		@SuppressWarnings("unchecked")
		Set<String> keySet = vertexConnections.keySet();
		Iterator<String> iterator = keySet.iterator();

		int rowIndex = 0;
		while (iterator.hasNext()) {
			String key = iterator.next();

			@SuppressWarnings("unchecked")
			List<Vertex> connectedVertextOfV = (List<Vertex>) vertexConnections.getCollection(key);
			for (int j = 0; j < connectedVertextOfV.size(); j++) {
				Vertex v1 = connectedVertextOfV.get(j);
				matrix.setValue(v1, rowIndex, v1.getSequenceIndex());
			}

			rowIndex++;
		}

		return matrix;
	}
}
