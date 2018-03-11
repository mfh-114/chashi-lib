package org.mfh114.chashi.graph;

import java.util.List;

public interface Sorter {

	/***
	 * Get the sorted vertexes of the graph
	 * 
	 * @return list of sorted vertexes
	 */
	public List<Vertex> sort();

	/***
	 * Get the sorted vertexes of the graph
	 * 
	 * @param triggerEvent
	 *            boolean type. If it is is true then vertex's registered event
	 *            will be triggered asynchronously.
	 * 
	 * @return list of sorted vertexes
	 */
	public List<Vertex> sort(boolean triggerEvent);
}
