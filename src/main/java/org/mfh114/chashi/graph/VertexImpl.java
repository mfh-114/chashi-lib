package org.mfh114.chashi.graph;

import java.util.ArrayList;
import java.util.List;

class VertexImpl implements Vertex {

	private String name;
	private String valueStr;
	private boolean isVisted;
	private List<VertexCallback<?>> vertextCallbackList;

	public VertexImpl(String name) {
		this.name = name;
		this.valueStr = null;
		this.isVisted = false;
		this.vertextCallbackList = new ArrayList<>();
	}

	public VertexImpl(String name, String valueStr) {
		this.name = name;
		this.valueStr = valueStr;
		this.isVisted = false;
		this.vertextCallbackList = new ArrayList<>();
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
	public <T> void registerCallBack(VertexCallback<T> vertexCallback) {
		vertextCallbackList.add(vertexCallback);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VertexCallback<?> getRegisteredCallback() {
		if (vertextCallbackList == null || vertextCallbackList.isEmpty())
			throw new IllegalStateException("No callback is registered.");

		return vertextCallbackList.get(0);
	}

	@Override
	public String toString() {
		return "VertexImpl [name=" + name + ", valueStr=" + valueStr + ", isVisted=" + isVisted
				+ ", vertextCallbackList=" + vertextCallbackList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isVisted ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((valueStr == null) ? 0 : valueStr.hashCode());
		result = prime * result + ((vertextCallbackList == null) ? 0 : vertextCallbackList.hashCode());
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
		if (vertextCallbackList == null) {
			if (other.vertextCallbackList != null)
				return false;
		} else if (!vertextCallbackList.equals(other.vertextCallbackList))
			return false;
		return true;
	}

}
