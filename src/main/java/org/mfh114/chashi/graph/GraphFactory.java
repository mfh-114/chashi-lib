package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

import org.mfh114.chashi.validator.ValidatorException;
import org.mfh114.chashi.validator.VertexImplValidator;

public class GraphFactory {

	public List<Vertex> vertexList;
	private VertexImplValidator vertexImplValidator;

	/***
	 * Create default GraphFactory instance
	 */
	public GraphFactory() {
		this.vertexList = new ArrayList<>();
		this.vertexImplValidator = new VertexImplValidator();
	}

	/***
	 * Create Vertex by name, String type value and visited flag value.
	 * 
	 * @param name
	 *            Vertex name. it is required value and it should be unique.
	 * 
	 * @throws ValidatorException
	 *             could be thrown if parameters are not valid.
	 * 
	 * @return Vertex
	 */
	public Vertex createVertex(String name) throws ValidatorException {
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
	 * @throws ValidatorException
	 *             could be thrown if parameters are not valid.
	 * 
	 * @return Vertex
	 */
	public Vertex createVertex(String name, String valueStr) throws ValidatorException {

		Vertex v = new VertexImpl(name, valueStr);

		// validate the vertex with last vertex list
		vertexImplValidator.setVertexList(vertexList);
		vertexImplValidator.validate(v);

		// add vertex to list
		vertexList.add(v);

		return v;
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

}
