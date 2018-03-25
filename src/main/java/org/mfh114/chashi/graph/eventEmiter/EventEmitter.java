package org.mfh114.chashi.graph.eventEmiter;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.mfh114.chashi.graph.Vertex;

public class EventEmitter implements Emitter {

	private final List<Vertex> vertexList;
	private final List<List<Integer>> sortedVertexGroupIndex;

	private final BlockingQueue<Runnable> taskQueue;

	// number physical core + number of hyper threading
	private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 2;
	private static final int TASK_QUEUE_SIZE = MAX_POOL_SIZE * 2;
	private static final long KEEP_ALIVE_IDLE_THREADS = 0L;

	public EventEmitter(final List<Vertex> vertexList, final List<List<Integer>> sortedVertexGroupIndex) {
		this.vertexList = vertexList;
		this.sortedVertexGroupIndex = sortedVertexGroupIndex;
		this.taskQueue = new LinkedBlockingQueue<Runnable>(TASK_QUEUE_SIZE);
	}

	public void emit() throws Exception {

		System.out.println("Start emitting events...");

		ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_IDLE_THREADS,
				TimeUnit.MILLISECONDS, taskQueue);

		int index = 0;
		while (index < sortedVertexGroupIndex.size()) {

			List<Integer> sortedVertexIndexes = sortedVertexGroupIndex.get(index);
			int sizeOfSortedVertexIndexes = sortedVertexIndexes.size();

			CountDownLatch latch = new CountDownLatch(sizeOfSortedVertexIndexes);

			for (int i = 0; i < sizeOfSortedVertexIndexes; i++) {
				try {

					Vertex v = vertexList.get(sortedVertexIndexes.get(i));

					Task task = new Task(v.getRegisteredCallback(), latch);

					tpExecutor.submit(task);

				} catch (Exception e) {
					tpExecutor.shutdownNow();
					throw e;
				}
			}

			latch.await();

			index++;
		}

		tpExecutor.shutdown();

		System.out.println("End emitting events...");

	}

}
