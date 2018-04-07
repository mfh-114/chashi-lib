package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.eventEmiter.VertexCallback;
import org.mfh114.chashi.graph.exception.ChashiException;
import org.mfh114.chashi.graph.exception.ParameterRequiredException;
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

	@Test
	public void verifyVertexList() throws ValidatorException {

		System.out.println("Verify vertexes are connected ...");

		graphFactory.createVertex("v1");
		graphFactory.createVertex("v2");

		Assert.assertEquals(graphFactory.getVertexList().size(), 2);
	}

	@Test(expectedExceptions = ParameterRequiredException.class)
	public void verifyVertexNameNotAvailable() throws ValidatorException {

		System.out.println("Verify vertex name not available. Expected ParameterRequiredException expection ...");

		graphFactory.createVertex(null);

	}

	@Test(expectedExceptions = ValidatorException.class)
	public void verifyVertexNotUniqueName() throws ValidatorException {

		System.out.println("Verify vertex is not unique name. Expected ValidatorException expection ...");

		graphFactory.createVertex("v1");
		graphFactory.createVertex("v1");
	}
}
