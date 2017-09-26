package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.core.graph.Graph;
import org.mfh114.chashi.core.graph.Vertex;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VertexTester {

	@Test(groups = "unit-test")
	public void verifyVertexName() {
		
		Graph g = new Graph();
		
		Vertex v1 = g.createVertex("A");
		Vertex v2 = g.createVertex("B");
		
		Assert.assertEquals(v1.getName(), "A");
		Assert.assertEquals(v1.getSequenceIndex(), 0);
		
		Assert.assertEquals(v2.getName(), "B");
		Assert.assertEquals(v2.getSequenceIndex(), 1);
	}

}
