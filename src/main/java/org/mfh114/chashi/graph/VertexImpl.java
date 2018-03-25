package org.mfh114.chashi.graph;

import org.mfh114.chashi.graph.eventEmiter.VertexCallback;

class VertexImpl implements Vertex {

	private String name;
	private String valueStr;
	private boolean isVisted;
	private VertexCallback vertexCallback;

	public VertexImpl(String name, String valueStr) {
		this.name = name;
		this.valueStr = valueStr;
		this.isVisted = false;
		this.vertexCallback = null;
	}

	@Override
	public String getVertexName() {
		return name;
	}

	@Override
	public String getValueStr() {
		return valueStr;
	}

	@Override
	public void setVisted(boolean isVisted) {
		this.isVisted = isVisted;
	}

	@Override
	public boolean isVisted() {
		return isVisted;
	}

	@Override
	public void registerCallBack(VertexCallback vertexCallback) {
		this.vertexCallback = vertexCallback;
	}

	@Override
	public VertexCallback getRegisteredCallback() {
		if (vertexCallback == null)
			throw new IllegalStateException("No callback is registered.");

		return vertexCallback;
	}

	@Override
	public String toString() {
		return "VertexImpl [name=" + name + ", valueStr=" + valueStr + ", isVisted=" + isVisted + ", vertexCallback="
				+ vertexCallback + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isVisted ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((valueStr == null) ? 0 : valueStr.hashCode());
		result = prime * result + ((vertexCallback == null) ? 0 : vertexCallback.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VertexImpl other = (VertexImpl) obj;
		if (isVisted != other.isVisted)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (valueStr == null) {
			if (other.valueStr != null)
				return false;
		} else if (!valueStr.equals(other.valueStr))
			return false;
		if (vertexCallback == null) {
			if (other.vertexCallback != null)
				return false;
		} else if (!vertexCallback.equals(other.vertexCallback))
			return false;
		return true;
	}

}
