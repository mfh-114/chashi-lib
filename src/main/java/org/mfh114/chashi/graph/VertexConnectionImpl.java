package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.ErrorCode;

class VertexConnectionImpl implements VertexConnection, GraphRepresentaion<VertexMatrix> {

	// key = vertex name, value = list of vertexes
	private Map<String, List<Vertex>> rowMap = null;
	private Map<String, List<Vertex>> columnMap = null;

	private Vertex startVertex;
	private List<Vertex> endVertexes;

	public VertexConnectionImpl(List<Vertex> vertexes) {
		this.rowMap = new HashMap<String, List<Vertex>>();
		this.columnMap = new HashMap<String, List<Vertex>>();
		this.startVertex = null;
		this.endVertexes = new ArrayList<Vertex>();

		// create init stage for the rowMap and colMap by vertex list.
		for (Vertex v : vertexes) {
			this.rowMap.put(v.getVertexName(), null);
			this.columnMap.put(v.getVertexName(), null);
		}
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

		// fill the rowMap value by startVertex name
		if (rowMap.containsKey(startVertex.getVertexName())) {
			rowMap.put(startVertex.getVertexName(), endVertexes);
		} else
			throw new InvalidVertexNameException(ErrorCode.INVALID_VERTEX_NAME,
					"Vertex name: " + startVertex + " is not valid.");

		// fill the colMap value by startVertex name per endVertex
		for (Vertex endVertex : endVertexes) {
			if (columnMap.containsKey(endVertex.getVertexName())) {

				// first get the array list if available. otherwise create new
				// array list
				List<Vertex> colCellList = columnMap.get(endVertex.getVertexName());
				if (colCellList != null && !colCellList.isEmpty()) {
					colCellList.add(startVertex);
					columnMap.put(endVertex.getVertexName(), colCellList);
				} else {
					List<Vertex> newColCellList = new ArrayList<Vertex>();
					newColCellList.add(startVertex);
					columnMap.put(endVertex.getVertexName(), newColCellList);
				}

			} else {
				throw new InvalidVertexNameException(ErrorCode.INVALID_VERTEX_NAME,
						"Vertex name: " + endVertex + " is not valid.");
			}
		}

		return this;
	}

	@Override
	public VertexMatrix represent() throws ChashiException {

		return new VertexMatrix(rowMap, columnMap);

	}

	public void clear() {
		if (rowMap != null) {
			rowMap.clear();
			rowMap = null;
		}
		if (columnMap != null) {
			columnMap.clear();
			columnMap = null;
		}
	}
}
