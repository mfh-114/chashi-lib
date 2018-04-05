package org.mfh114.chashi.test.testng;

import java.util.Arrays;
import java.util.List;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.VertexConnection;
import org.mfh114.chashi.graph.eventEmiter.VertexCallback;
import org.mfh114.chashi.graph.exception.ChashiException;
import org.mfh114.chashi.graph.exception.ValidatorException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventEmitterTest {

	private GraphFactory graphFactory;
	private Vertex v1, v2, v3, v4;

	@BeforeMethod
	public void construct() throws ValidatorException {

		System.out.println("Created 6 vertexes graph ...");

		graphFactory = new GraphFactory();
		v1 = graphFactory.createVertex("v1");
		v1.registerCallBack(new VertexCallback() {

			@Override
			public void call() throws ChashiException {
				System.out.print("Callback for v1.");
			}
		});
		v2 = graphFactory.createVertex("v2");
		v2.registerCallBack(new VertexCallback() {

			@Override
			public void call() throws ChashiException {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					throw new ChashiException("v2 callback failed.", e);
				}
				System.out.print("Callback for v2.");
			}
		});
		v3 = graphFactory.createVertex("v3");
		v3.registerCallBack(new VertexCallback() {

			@Override
			public void call() throws ChashiException {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new ChashiException("v3 callback failed.", e);
				}
				System.out.print("Callback for v3.");
			}
		});
		v4 = graphFactory.createVertex("v4");
		v4.registerCallBack(new VertexCallback() {

			@Override
			public void call() throws ChashiException {
				System.out.print("Callback for v4.");
			}
		});
	}

	@AfterMethod
	public void destroy() {
		graphFactory = null;
	}

	/***
	 * We are looking for the following matrix
	 * 
	 * <pre>
	 *  ======================
	 *      v1 | v2 | v3 | v4 
	 *  ----------------------
	 *  v1| 0  |  1 |  1 | 0  
	 *  ----------------------
	 *  v2| 0  |  0 |  0 | 1  
	 *  ----------------------
	 *  v3| 0  |  0 |  0 | 1  
	 *  ----------------------
	 *  v4| 0  |  0 |  0 | 0  
	 *  ----------------------
	 *  ======================
	 *     
	 *    /->v2 -> v4
	 *  v1       ^
	 *   \      /      
	 *    \->v3
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void verifySort() throws Exception {
		System.out.println("Verify topological sort...");
		VertexConnection vConn = graphFactory.createVertexConnection();
		vConn.from(v1).to(v2, v3).connect();
		vConn.from(v2).to(v4).connect();
		vConn.from(v3).to(v4).connect();
		List<Vertex> sortedVertex = graphFactory.sort();

		List<String> expectedSortedVertexNames = Arrays.asList("v1", "v2", "v3", "v4");

		for (int i = 0; i < sortedVertex.size(); i++)
			Assert.assertEquals(sortedVertex.get(i).getVertexName(), expectedSortedVertexNames.get(i));
		
		graphFactory.emitEvent();
	}
}
