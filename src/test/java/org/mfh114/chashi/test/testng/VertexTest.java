package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.validator.ValidatorException;
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
	public void verifyVertexName() {

		System.out.println("Verify vertex name ...");

		Vertex v1 = graphFactory.createVertex("v1");

		Assert.assertEquals(v1.getVertexName(), "v1");
	}

	@Test(expectedExceptions = ValidatorException.class)
	public void verifyNoVertexName() {

		System.out.println("Verify no vertex name is set. Expected ValidatorException is thrown ...");

		graphFactory.createVertex(null);
	}

}
