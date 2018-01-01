package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.ErrorCode;

public class VertexMatrix {

	// key = vertex name, value = list of vertexes
	private final Map<String, List<Vertex>> rowMap;
	private final Map<String, List<Vertex>> columnMap;

	public VertexMatrix(Map<String, List<Vertex>> rowMap, Map<String, List<Vertex>> columnMap) {
		this.rowMap = rowMap;
		this.columnMap = columnMap;
	}

	public List<Vertex> getRow(Vertex key) {
		if (StringUtils.isBlank(key.getVertexName()))
			return new ArrayList<Vertex>(1);

		if (rowMap.containsKey(key.getVertexName()))
			return rowMap.get(key.getVertexName());
		else
			return new ArrayList<Vertex>(1);

	}

	public List<Vertex> getColumn(Vertex key) {
		if (StringUtils.isBlank(key.getVertexName()))
			return new ArrayList<Vertex>(1);

		if (columnMap.containsKey(key.getVertexName()))
			return columnMap.get(key.getVertexName());
		else
			return new ArrayList<Vertex>(1);
	}

	public int IndexOfInRowMap(Vertex v) {

		if (v == null)
			throw new ChashiException(ErrorCode.REQUIRED_PARAM, "Vertex is reuqired.");

		if (StringUtils.isBlank(v.getVertexName()))
			throw new ChashiException(ErrorCode.REQUIRED_PARAM, "Vertex name is reuqired.");

		int index = -1;
		if (rowMap.containsKey(v.getVertexName())) {

			List<Vertex> rowMapVertexes = rowMap.get(v.getVertexName());
			if (rowMapVertexes != null && !rowMapVertexes.isEmpty()) {
				for (int i = 0; i < rowMapVertexes.size(); i++) {
					if (StringUtils.equals(rowMapVertexes.get(i).getVertexName(), v.getVertexName())) {
						index = i;
						break;
					}
				}
			}
		}
		return index;
	}

	public int IndexOfInColumnMap(Vertex v) {

		if (v == null)
			throw new ChashiException(ErrorCode.REQUIRED_PARAM, "Vertex is reuqired.");

		if (StringUtils.isBlank(v.getVertexName()))
			throw new ChashiException(ErrorCode.REQUIRED_PARAM, "Vertex name is reuqired.");

		int index = -1;
		if (rowMap.containsKey(v.getVertexName())) {

			List<Vertex> colMapVertexes = rowMap.get(v.getVertexName());
			if (colMapVertexes != null && !colMapVertexes.isEmpty()) {
				for (int i = 0; i < colMapVertexes.size(); i++) {
					if (StringUtils.equals(colMapVertexes.get(i).getVertexName(), v.getVertexName())) {
						index = i;
						break;
					}
				}
			}
		}
		return index;
	}

	public void clear() {
		if (rowMap != null)
			rowMap.clear();

		if (columnMap != null)
			columnMap.clear();
	}
}
