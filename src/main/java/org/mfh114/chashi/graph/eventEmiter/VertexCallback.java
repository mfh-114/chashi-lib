package org.mfh114.chashi.graph.eventEmiter;

import org.mfh114.chashi.graph.exception.ChashiException;

public interface VertexCallback {

	public void call() throws ChashiException;

}
