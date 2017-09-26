package org.mfh114.chashi.core.graph;

class VertexImpl implements Vertex {

	private String name;
	private int sequenceNumber;
	public boolean wasVisited;

	public VertexImpl(String name, int sequenceNumber) {
		this.name = name;
		this.sequenceNumber = sequenceNumber;
		this.wasVisited = false;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getSequenceIndex(){
		return sequenceNumber;
	}

	@Override
	public boolean isWasVisited() {
		return wasVisited;
	}

	@Override
	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", sequenceNumber=" + sequenceNumber + ", wasVisited=" + wasVisited + "]";
	}

}
