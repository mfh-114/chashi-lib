package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mfh114.chashi.graph.eventEmiter.EventEmitter;
import org.mfh114.chashi.graph.exception.ChashiException;
import org.mfh114.chashi.graph.exception.ValidatorException;
import org.mfh114.chashi.graph.validator.VertexImplValidator;

public class GraphFactory {

	private List<Vertex> vertexList;
	private VertexImplValidator vertexImplValidator;
	private VertexConnectionImpl vertexConnectionImpl;
	private VertexMatrix matrix;
	private TopologicalSorter topoSorter;

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

	/***
	 * Get list of created vertexes.
	 * 
	 * @return {@link List} of vertexes
	 */
	public List<Vertex> getVertexList() {
		return vertexList;
	}

	/***
	 * Create and get vertex connection implementation based on the
	 * representation type of the graph.
	 * 
	 * @param vertexList
	 * @return {@link VertexConnection}
	 */
	public VertexConnection createVertexConnection() {
		this.matrix = new VertexMatrix(vertexList.stream().map(v -> v.getVertexName()).collect(Collectors.toList()));
		this.matrix.init();
		this.vertexConnectionImpl = new VertexConnectionImpl(vertexList, matrix);
		return vertexConnectionImpl;
	}

	public List<Vertex> sort() throws ChashiException {
		this.topoSorter = new TopologicalSorter(vertexList, matrix);
		return this.topoSorter.sort();
	}

	public void emitEvent() throws Exception {

		if (topoSorter == null)
			throw new IllegalAccessError("sort method is not called.");

		EventEmitter emitter = new EventEmitter(vertexList, this.topoSorter.getSortedVertexGroupIndexes());
		emitter.emit();
	}
}
