package org.mfh114.chashi.core;

public class Vertex {

	public String name;
	public boolean wasVisited;

	public Vertex(String name) {
		this.name = name;
		this.wasVisited = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", wasVisited=" + wasVisited + "]";
	}

}
