package org.mfh114.chashi.fsm;

import java.util.ArrayList;
import java.util.List;

import org.mfh114.chashi.graph.Vertex;

public class IndependentGroup {

	private List<Vertex> independentVertexes;

	public IndependentGroup() {
		this.independentVertexes = new ArrayList<Vertex>();
	}

	public void addIndependentVertex(Vertex vertex) {
		this.independentVertexes.add(vertex);
	}

	public List<Vertex> getIndependentVertexes() {
		return independentVertexes;
	}

	@Override
	public String toString() {
		return "IndependentGroup [independentVertexes=" + independentVertexes + "]";
	}

}
