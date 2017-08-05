package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.bean.Matrix;
import org.mfh114.chashi.core.Graph;
import org.mfh114.chashi.core.Vertex;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GraphTester {
	
	private Graph graph;
	private Matrix expectedMatrix;
	
	@BeforeTest
	public void setup(){
		graph = new Graph();
		
		Vertex v1 = graph.createVertex("A");
		Vertex v2 = graph.createVertex("B");
		Vertex v3 = graph.createVertex("C");
		Vertex v4 = graph.createVertex("D");
		
		graph.connectVertex(v1, v2);
		graph.connectVertex(v1, v3);
		graph.connectVertex(v2, v4);
		
		expectedMatrix = new Matrix(4,4);
		expectedMatrix.setValue(v2, 0, 1);
		expectedMatrix.setValue(v3, 0, 2);
		expectedMatrix.setValue(v4, 1, 3);
		
	}
	
	@Test(groups="unit-test")
	public void verifyGraph(){
		Matrix matrix = graph.transformToAdjacencyMatrix();
		for(int i=0; i<graph.getVertexes().size(); i++){
			for(int j=0; j<graph.getVertexes().size(); j++){
				Assert.assertEquals(matrix.getValue(i, j),expectedMatrix.getValue(i, j));
			}
		}
	}

}
