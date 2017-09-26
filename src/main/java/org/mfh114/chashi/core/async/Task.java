package org.mfh114.chashi.core.async;

/**
 * This interface represent to execute a concrete Task asynchronously.
 * Registered event will be fired and event listener performed action.
 * 
 * 
 * @author firoj
 *
 * @param <T>
 */
public interface Task<T> {

	/**
	 * Perform task asynchronously
	 * 
	 * @return T
	 */
	public TaskCompletionResponse<T> complete();

}
