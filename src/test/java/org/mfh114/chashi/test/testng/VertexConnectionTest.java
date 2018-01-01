package org.mfh114.chashi.test.testng;

import java.util.Arrays;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.VertexConnection;
import org.mfh114.chashi.graph.VertexMatrix;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	@Test
	public void verifyVertexConnection(){
		
		System.out.println("Verify vertex connection. v1-->v2,v3,v4; v5-->v3,v4 ..."); 
		
		VertexConnection vConn = graphFactory.createVertexConnection(graphFactory.getVertexList());
		vConn.from(v1).to(v2,v3,v4).connect();
		vConn.from(v5).to(v3,v4).connect();
		
		VertexMatrix vMatrix = graphFactory.getRepresentation();
		
		Assert.assertNotNull(vMatrix);
		Assert.assertEquals(vMatrix.getRow(v1), Arrays.asList(v2,v3,v4));
		Assert.assertEquals(vMatrix.getRow(v5), Arrays.asList(v3,v4));
	}
}
