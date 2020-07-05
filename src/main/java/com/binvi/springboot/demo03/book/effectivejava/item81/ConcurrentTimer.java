package com.binvi.springboot.demo03.book.effectivejava.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author binvi
 * @version 1.0
 * @Description: Simple framework for timing concurrent execution
 * @date 2019/9/8 12:21
 */
public class ConcurrentTimer {

	private ConcurrentTimer() {}

	public static long time(Executor executor, int concurrency,
							Runnable action) throws InterruptedException {
		CountDownLatch ready = new CountDownLatch(concurrency);
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch done = new CountDownLatch(concurrency);

		for (int i = 0; i < concurrency; i++) {
			executor.execute(() -> {
				ready.countDown(); // Tell timer we're ready
				try {
					start.await(); // Wait till peers are ready
					action.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				} finally {
					done.countDown(); // Tell timer we're done
				}
			});
		}
		ready.await(); // Wait for all workers to be ready
		long startNanos = System.nanoTime();
		start.countDown(); // And they're off
		done.await(); // Wait for all workers to finish
		return System.nanoTime() - startNanos;
	}

}
