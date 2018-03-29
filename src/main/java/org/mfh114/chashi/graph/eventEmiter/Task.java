package org.mfh114.chashi.graph.eventEmiter;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

	private final VertexCallback vertexCallback;
	private final CountDownLatch latch;

	public Task(final VertexCallback vertexCallback, final CountDownLatch latch) {
		this.vertexCallback = vertexCallback;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			this.vertexCallback.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		this.latch.countDown();
	}

}
