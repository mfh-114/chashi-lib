package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.eventEmiter.VertexCallback;
import org.mfh114.chashi.graph.exception.ChashiException;
import org.mfh114.chashi.graph.exception.ValidatorException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VertexTest {

	private GraphFactory graphFactory;

	@BeforeMethod
	public void setup() {
		this.graphFactory = new GraphFactory();
	}

	@Test
	public void verifyVertexName() throws ValidatorException {

		System.out.println("Verify vertex name ...");

		Vertex v1 = graphFactory.createVertex("v1");

		Assert.assertEquals(v1.getVertexName(), "v1");
	}

	@Test
	public void verifyVertexValue() throws ValidatorException {

		System.out.println("Verify vertex value ...");

		Vertex v1 = graphFactory.createVertex("v1", "v1 value");

		Assert.assertEquals(v1.getValueStr(), "v1 value");
	}

	@Test
	public void verifyIsVertexAlreadyVisted() throws ValidatorException {

		System.out.println("Verify vertex already visted ...");

		Vertex v1 = graphFactory.createVertex("v1", "v1 value");
		v1.setVisted(true);

		Assert.assertEquals(v1.isVisted(), true);
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
	public void verifyToString() throws ValidatorException {
		System.out.println("Verify vertex toString ...");

		Vertex v1 = graphFactory.createVertex("v1");

		String expectedResult = "VertexImpl [name=v1, valueStr=null, isVisted=false, vertexCallback=null]";
		Assert.assertEquals(v1.toString(), expectedResult);
	}

	@Test
	public void verifyHashCode() throws ValidatorException {
		System.out.println("Verify vertex hashcode ...");

		Vertex v1 = graphFactory.createVertex("v1");

		Assert.assertNotNull(v1.hashCode());
	}

	@Test
	public void verifyEquals() throws ValidatorException {
		System.out.println("Verify vertex equality ...");

		Vertex v1 = graphFactory.createVertex("v1");
		Vertex v2 = graphFactory.createVertex("v2", "This value 2");
		Vertex v3 = graphFactory.createVertex("v3", "This value 3");
		VertexCallBackImpl vcImpl = new VertexCallBackImpl();
		v3.registerCallBack(vcImpl);

		Assert.assertEquals(v1.equals(v2), false);
		Assert.assertEquals(v1.equals(v3), false);
		Assert.assertEquals(v2.equals(v3), false);
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
