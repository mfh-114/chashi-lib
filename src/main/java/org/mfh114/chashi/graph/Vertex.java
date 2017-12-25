package org.mfh114.chashi.graph;

public interface Vertex {

	public String getVertexName();

	public String getValueStr();

	public void setVisted(boolean isVisted);
	
	public boolean isVisted();
	
	public <T> void registerCallBack(VertexCallback<T> vertexCallback);
	
	public <T> VertexCallback<T> getRegisteredCallback() throws IllegalStateException;
}
