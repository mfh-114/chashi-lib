package org.mfh114.chashi.test.testng;

import java.util.Arrays;
import java.util.List;

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
	private List<Vertex> vertexes;

	@BeforeTest
	public void contruct() {

		System.out.println("Created 5 vertexes graph ...");

		graphFactory = new GraphFactory<VertexMatrix>();
		v1 = graphFactory.createVertex("v1");
		v2 = graphFactory.createVertex("v2");
		v3 = graphFactory.createVertex("v3");
		v4 = graphFactory.createVertex("v4");
		v5 = graphFactory.createVertex("v5");

		vertexes = Arrays.asList(v1, v2, v3, v4, v5);
	}

	@AfterTest
	public void destroy() {
		graphFactory = null;
	}

	/***
	 * We are looking for the following matrix
	 * 
	 * <pre>
	 *  ==========================
	 *      v1 | v2 | v3 | v4 | v5
	 *  --------------------------
	 *  v1| 0  |  1 |  1 | 0  | 0 
	 *  --------------------------
	 *  v2| 0  |  0 |  1 | 1  | 0
	 *  --------------------------
	 *  v3| 0  |  0 |  0 | 0  | 1 
	 *  --------------------------
	 *  v4| 0  |  0 |  0 | 0  | 0
	 *  --------------------------
	 *  v5| 0  | 0  |  0 | 0  | 0
	 *  ==========================
	 *     
	 *    /->v2 -> v4
	 *  v1   |
	 *   \   v         
	 *    \->v3 -> v5
	 * 
	 * </pre>
	 */

	@Test
	public void verifyConnectionFromV1ToV2_V3() {
		System.out.println("Verify vertex connection from v1 to v2 and v3...");

		VertexConnection vConn = graphFactory.createVertexConnection(vertexes);
		vConn.from(v1).to(v2, v3).connect();

		VertexMatrix vM = vConn.getVertexMatrix();

		List<Integer> colB = vM.getColumn(v2.getVertexName());
		Assert.assertEquals(colB.get(0), new Integer(1));

		List<Integer> colC = vM.getColumn(v3.getVertexName());
		Assert.assertEquals(colC.get(0), new Integer(1));
	}

	@Test
	public void verifyConnectionFromV2ToV3_V4() {
		System.out.println("Verify vertex connection v2 to v3 and v4...");

		VertexConnection vConn = graphFactory.createVertexConnection(vertexes);
		vConn.from(v2).to(v3, v4).connect();

		VertexMatrix vM = vConn.getVertexMatrix();

		List<Integer> colB = vM.getColumn(v3.getVertexName());
		Assert.assertEquals(colB.get(1), new Integer(1));

		List<Integer> colC = vM.getColumn(v4.getVertexName());
		Assert.assertEquals(colC.get(1), new Integer(1));
	}

	@Test
	public void verifyConnectionFromv3Tov5() {
		System.out.println("Verify vertex connection v3 to v5...");

		VertexConnection vConn = graphFactory.createVertexConnection(vertexes);
		vConn.from(v3).to(v5).connect();

		VertexMatrix vM = vConn.getVertexMatrix();

		List<Integer> colB = vM.getColumn(v5.getVertexName());
		Assert.assertEquals(colB.get(2), new Integer(1));
	}
}
