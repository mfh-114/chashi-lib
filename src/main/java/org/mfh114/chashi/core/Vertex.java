package org.mfh114.chashi.core;

public interface Vertex {

	public String getName();
	
	public int getSequenceIndex();

	public boolean isWasVisited();

	public void setWasVisited(boolean wasVisited);

}
