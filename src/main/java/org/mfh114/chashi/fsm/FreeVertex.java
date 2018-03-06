package org.mfh114.chashi.fsm;

import java.util.ArrayList;
import java.util.List;

/***
 * During scanning process (state), it store the independent vertexes which are
 * not depends on other vertex(es).
 *
 */
public class FreeVertex {

	private List<String> vertexNames;

	public FreeVertex() {
		this.vertexNames = new ArrayList<String>();
	}

	public void addVertexName(String vertexName) {
		this.vertexNames.add(vertexName);
	}

	public List<String> getVertexNames() {
		return this.vertexNames;
	}
}
