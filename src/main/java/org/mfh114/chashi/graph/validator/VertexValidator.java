package org.mfh114.chashi.graph.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.exception.DuplicateVertexNameException;
import org.mfh114.chashi.graph.exception.ParameterRequiredException;
import org.mfh114.chashi.graph.exception.ValidatorException;

public class VertexValidator implements Validator<Vertex> {

	private List<Vertex> vertexList = null;

	public VertexValidator() {
		this.vertexList = new ArrayList<>();
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	/**
	 * Validate the vertex.
	 * 
	 * <pre>
	 *  - Check vertex name is null or not
	 *  - Check vertex name is unique or not
	 * </pre>
	 */
	@Override
	public void validate(Vertex vertex) throws ValidatorException {

		if (StringUtils.isBlank(vertex.getVertexName()))
			throw new ParameterRequiredException("Vertex name is required.");

		// At this stage vertex has the name. Therefore, check the name against
		// latest vertex list to make sure there
		// is not duplicate name.
		for (Vertex v : vertexList) {
			if (v.getVertexName().equals(vertex.getVertexName()))
				throw new DuplicateVertexNameException("Vertex is already create with this name: "
						+ vertex.getVertexName() + ". Please use unique vertex name.");
		}
	}

}
