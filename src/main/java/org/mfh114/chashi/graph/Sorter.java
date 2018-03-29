package org.mfh114.chashi.graph;

import java.util.List;

import org.mfh114.chashi.graph.exception.ChashiException;

public interface Sorter {

	/***
	 * Get the sorted vertexes of the graph
	 * 
	 * @return list of sorted vertexes
	 * @throws ChashiException 
	 */
	public List<Vertex> sort() throws ChashiException;

	/***
	 * Get the sorted vertexes of the graph
	 * 
	 * @param triggerEvent
	 *            boolean type. If it is is true then vertex's registered event
	 *            will be triggered asynchronously.
	 * 
	 * @return list of sorted vertexes
	 * @throws ChashiException 
	 */
	public List<Vertex> sort(boolean triggerEvent) throws ChashiException;
}
