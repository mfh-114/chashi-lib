package org.mfh114.chashi.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mfh114.chashi.ErrorCode;
import org.mfh114.chashi.graph.Vertex;

public class VertexImplValidator implements Validator<Vertex> {

	private List<Vertex> vertexList = null;

	public VertexImplValidator() {
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
			throw new ValidatorException(ErrorCode.REQUIRED_PARAM, "Vertex name is required");

		// At this stage vertex has the name. Therefore, check the name against
		// latest vertex list to make sure there
		// is not duplicate name.
		for (Vertex v : vertexList) {
			if (v.getVertexName().equals(vertex.getVertexName()))
				throw new ValidatorException(ErrorCode.DUP_VERTEX_NAME, "Vertex is already create with this name: "
						+ vertex.getVertexName() + ". Please use unique vertex name.");
		}
	}

}
