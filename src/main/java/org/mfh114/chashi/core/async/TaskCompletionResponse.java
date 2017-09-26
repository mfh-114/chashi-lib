package org.mfh114.chashi.core.async;

public class TaskCompletionResponse<T> {

	private final String id;
	private final T response;

	public TaskCompletionResponse(final String id, final T response) {
		this.id = id;
		this.response = response;
	}

	public String getId() {
		return id;
	}

	public T getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return "TaskCompletionResponse [id=" + id + ", response=" + response + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
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
		TaskCompletionResponse<?> other = (TaskCompletionResponse<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}

}
