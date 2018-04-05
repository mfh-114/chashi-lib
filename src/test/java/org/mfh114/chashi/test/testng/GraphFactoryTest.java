package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.eventEmiter.VertexCallback;
import org.mfh114.chashi.graph.exception.ChashiException;
import org.mfh114.chashi.graph.exception.ValidatorException;
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
	public void verifyVertexInstance() throws ValidatorException {

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

		VertexCallBackImpl vcImpl = new VertexCallBackImpl();
		v1.registerCallBack(vcImpl);

		v1.getRegisteredCallback().call();

		Assert.assertEquals(vcImpl.getResult(), "I am CallBack");
	}

	@Test
	public void verifyVertexList() throws ValidatorException {

		System.out.println("Verify vertexes are connected ...");

		graphFactory.createVertex("v1");
		graphFactory.createVertex("v2");

		Assert.assertEquals(graphFactory.getVertexList().size(), 2);
	}

	@Test(expectedExceptions = ValidatorException.class)
	public void verifyVertexNotUniqueName() throws ValidatorException {

		System.out.println("Verify vertex is not unique name. Expected ValidatorException expection ...");

		graphFactory.createVertex("v1");
		graphFactory.createVertex("v1");

		Assert.assertEquals(graphFactory.getVertexList().size(), 2);
	}

	// inner class to stub the VertexCallBack implementation
	class VertexCallBackImpl implements VertexCallback {

		String r = "";

		@Override
		public void call() throws ChashiException {
			r = "I am CallBack";
		}

		public String getResult() {
			return r;
		}
	}
}
