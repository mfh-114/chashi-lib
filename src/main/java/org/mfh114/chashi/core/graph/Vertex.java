package org.mfh114.chashi.core.graph;

import java.util.List;

import org.mfh114.chashi.core.event.VertexEventListener;

public interface Vertex {

	public String getName();

	public int getSequenceIndex();

	public boolean isWasVisited();

	public void setWasVisited(boolean wasVisited);

}
