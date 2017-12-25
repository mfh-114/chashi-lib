package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphFactory {

	public List<Vertex> vertexList;

	/***
	 * Create default GraphFactory instance
	 */
	public GraphFactory() {
		this.vertexList = new ArrayList<>();
	}

	/***
	 * Create Vertex by name, String type value and visited flag value.
	 * 
	 * @param name
	 *            Vertex name. it is required value and it should be unique.
	 * 
	 * @return Vertex
	 */
	public Vertex createVertex(String name) {
		return createVertex(name, null);
	}

	/***
	 * Create Vertex by name, String type value and visited flag value.
	 * 
	 * @param name
	 *            Vertex name. it is required value and it should be unique.
	 * @param valueStr
	 *            Vertex object may carry data value as String. It is an
	 *            optional value.
	 * 
	 * @return Vertex
	 */
	public Vertex createVertex(String name, String valueStr) {

		Vertex v = new VertexImpl(name, valueStr);

		// check vertex name uniqueness
		verifyVertexNameUniquess(name);

		// add vertex to list
		vertexList.add(v);

		return v;
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	private void verifyVertexNameUniquess(String vName) throws IllegalArgumentException {

		for (Vertex v : vertexList) {
			if (v.getVertexName().equals(vName))
				throw new IllegalArgumentException(
						"Vertex is already create with this name: " + vName + ". Please use unique vertex name.");
		}
	}
}
