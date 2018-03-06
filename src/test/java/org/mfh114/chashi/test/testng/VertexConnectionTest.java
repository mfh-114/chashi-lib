package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.VertexMatrix;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class VertexConnectionTest {

	private GraphFactory<VertexMatrix> graphFactory;
	private Vertex v1, v2, v3, v4, v5;

	@BeforeTest
	public void contruct() {

		System.out.println("Created 5 vertexes graph ...");

		graphFactory = new GraphFactory<VertexMatrix>();
		v1 = graphFactory.createVertex("v1");
		v2 = graphFactory.createVertex("v2");
		v3 = graphFactory.createVertex("v3");
		v4 = graphFactory.createVertex("v4");
		v5 = graphFactory.createVertex("v5");
	}

	@AfterTest
	public void destroy() {
		graphFactory = null;
	}
}
