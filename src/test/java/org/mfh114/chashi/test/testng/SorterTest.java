package org.mfh114.chashi.test.testng;

import java.util.Arrays;
import java.util.List;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Sorter;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.VertexConnection;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SorterTest {

	private GraphFactory graphFactory;
	private Vertex v1, v2, v3, v4, v5, v6;

	@BeforeMethod
	public void contruct() {

		System.out.println("Created 6 vertexes graph ...");

		graphFactory = new GraphFactory();
		v1 = graphFactory.createVertex("v1");
		v2 = graphFactory.createVertex("v2");
		v3 = graphFactory.createVertex("v3");
		v4 = graphFactory.createVertex("v4");
		v5 = graphFactory.createVertex("v5");
		v6 = graphFactory.createVertex("v6");
	}

	@AfterMethod
	public void destroy() {
		graphFactory = null;
	}

	/***
	 * We are looking for the following matrix
	 * 
	 * <pre>
	 *  ===============================
	 *      v1 | v2 | v3 | v4 | v5 | v6
	 *  -------------------------------
	 *  v1| 0  |  1 |  1 | 0  | 0  | 1
	 *  -------------------------------
	 *  v2| 0  |  0 |  1 | 1  | 0  | 0
	 *  -------------------------------
	 *  v3| 0  |  0 |  0 | 0  | 1  | 0
	 *  -------------------------------
	 *  v4| 0  |  0 |  0 | 0  | 0  | 0
	 *  -------------------------------
	 *  v5| 0  |  0 |  0 | 0  | 0  | 0
	 *  -------------------------------
	 *  v6| 0  |  0 |  0 | 0  | 0  | 0
	 *  ===============================
	 *     
	 *    /->v2 -> v4
	 *  v1   |
	 *   \   v         
	 *    \->v3 -> v5
	 *     \-> v6
	 * </pre>
	 */
	@Test
	public void verifySort() {
		System.out.println("Verify topological sort...");
		VertexConnection vConn = graphFactory.createVertexConnection();
		vConn.from(v1).to(v2, v3, v6).connect();
		vConn.from(v2).to(v3, v4).connect();
		vConn.from(v3).to(v5).connect();

		Sorter sorter = graphFactory.createTopologicalSorter();
		List<Vertex> sortedVertex = sorter.sort();

		List<String> expectedSortedVertexNames = Arrays.asList("v1", "v2", "v6", "v3", "v4", "v5");

		for (int i = 0; i < sortedVertex.size(); i++)
			Assert.assertEquals(sortedVertex.get(i).getVertexName(), expectedSortedVertexNames.get(i));
	}

	/***
	 * We are looking for the following matrix
	 * 
	 * <pre>
	 *  ===============================
	 *      v1 | v2 | v3 | v4 | v5 | v6
	 *  -------------------------------
	 *  v1| 0  |  1 |  1 | 0  | 0  | 1
	 *  -------------------------------
	 *  v2| 0  |  0 |  1 | 1  | 0  | 0
	 *  -------------------------------
	 *  v3| 0  |  0 |  0 | 0  | 1  | 0
	 *  -------------------------------
	 *  v4| 0  |  0 |  0 | 0  | 0  | 0
	 *  -------------------------------
	 *  v5| 0  |  0 |  0 | 0  | 0  | 0
	 *  -------------------------------
	 *  v6| 0  |  0 |  0 | 0  | 0  | 0
	 *  ===============================
	 *     
	 *    /->v2 -> v4
	 *  v1   |
	 *   \   v         
	 *    \->v3 -> v5
	 *     \-> v6
	 * </pre>
	 */
	@Test
	public void verifySortWithEvent() {
		System.out.println("Verify topological sort with event ...");
		VertexConnection vConn = graphFactory.createVertexConnection();
		vConn.from(v1).to(v2, v3, v6).connect();
		vConn.from(v2).to(v3, v4).connect();
		vConn.from(v3).to(v5).connect();

		Sorter sorter = graphFactory.createTopologicalSorter();
		List<Vertex> sortedVertex = sorter.sort(true);

		List<String> expectedSortedVertexNames = Arrays.asList("v1", "v2", "v6", "v3", "v4", "v5");

		for (int i = 0; i < sortedVertex.size(); i++)
			Assert.assertEquals(sortedVertex.get(i).getVertexName(), expectedSortedVertexNames.get(i));
	}	
	
	/***
	 * We are looking for the following matrix
	 * 
	 * <pre>
	 *  ================
	 *      v1 | v2 | v3
	 *  ----------------
	 *  v1| 0  |  1 |  1
	 *  ----------------
	 *  v2| 0  |  0 |  1
	 *  ----------------
	 *  v3| 1  |  0 |  0
	 *  ----------------
	 *  ================
	 *     
	 *    /->v2
	 *  v1<.  |
	 *   \  \ v         
	 *    \->v3
	 * </pre>
	 */
	@Test(expectedExceptions = ChashiException.class)
	public void verifyGraphInLoopException() {
		System.out.println("Verify graph is in loop exception ...");

		System.out.println("Verify topological sort...");
		VertexConnection vConn = graphFactory.createVertexConnection();
		vConn.from(v1).to(v2, v3).connect();
		vConn.from(v2).to(v3).connect();
		vConn.from(v3).to(v1).connect();

		Sorter sorter = graphFactory.createTopologicalSorter();
		try {
			sorter.sort();
		} catch (ChashiException e) {
			Assert.assertEquals(e.getMessage(), "Cannot procced. Graph is in loop.");
			throw e;
		}
	}
}
