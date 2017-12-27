package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.VertexCallback;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GraphFactoryTest {

	private GraphFactory graphFactory;

	@BeforeMethod
	public void setup() {
		this.graphFactory = new GraphFactory();
	}

	@Test
	public void verifyGraphInstance() {

		System.out.println("Verify GraphFactory instance is created ...");

		Assert.assertNotNull(graphFactory);
	}

	@Test
	public void verifyVertexInstance() {

		System.out.println("Verify vertex is created ...");

		Vertex v1 = graphFactory.createVertex("v1");

		Assert.assertNotNull(v1);
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void verifyVertexCallbackIsNotRegistered() throws IllegalStateException, Exception {

		System.out.println("Verify vertex callback is not registered. Expected IllegalStateException ...");

		Vertex v1 = graphFactory.createVertex("v1");

		v1.getRegisteredCallback().call();
	}

	@Test
	public void verifyVertexCallback() throws IllegalStateException, Exception {

		System.out.println("Verify vertex callback is registered ...");

		Vertex v1 = graphFactory.createVertex("v1");

		VertexCallback<String> vc1 = new VertexCallback<String>() {

			public String call() throws Exception {
				return "I am CallBack1";

			}
		};

		v1.registerCallBack(vc1);

		Assert.assertEquals(v1.getRegisteredCallback().call(), "I am CallBack1");
	}

	@Test
	public void verifyVertexList() {

		System.out.println("Verify vertexes are connected ...");

		graphFactory.createVertex("v1");
		graphFactory.createVertex("v2");

		Assert.assertEquals(graphFactory.getVertexList().size(), 2);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void verifyVertexNotUniqueName() {

		System.out.println("Verify vertex is not unique name. Expected IllegalArgumentException expection ...");

		graphFactory.createVertex("v1");
		graphFactory.createVertex("v1");

		Assert.assertEquals(graphFactory.getVertexList().size(), 2);
	}
}
