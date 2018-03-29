package org.mfh114.chashi.graph;

import org.mfh114.chashi.graph.exception.ChashiException;

public interface GraphRepresentaion<T> {

	public T represent() throws ChashiException;

}
