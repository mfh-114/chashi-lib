package org.mfh114.chashi.graph;

import org.mfh114.chashi.graph.eventEmiter.VertexCallback;

public interface Vertex {

	public String getVertexName();

	public String getValueStr();

	public void setVisted(boolean isVisted);

	public boolean isVisted();

	public void registerCallBack(VertexCallback vertexCallback);

	public VertexCallback getRegisteredCallback() throws IllegalStateException;
}
