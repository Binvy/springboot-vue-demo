package com.binvi.springboot.demo03.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/5/20 20:47
 */
public class Demo {

	private Service1 service1;
	private Service2 service2;
	private Service3 service3;

	public String invoke() throws ExecutionException, InterruptedException {

		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		Future<String> result1 = threadPool.submit(() -> {
			String result = service1.invoke();
			latch.countDown();
			return result;
		});

		Future<String> result2 = threadPool.submit(() -> {
			String result = service2.invoke();
			latch.countDown();
			return result;
		});

		Future<String> result3 = threadPool.submit(() -> {
			String result = service3.invoke();
			latch.countDown();
			return result;
		});

		latch.await();

		return result1.get() + result2.get() + result3.get();
	}


}

interface Service1 {
	String invoke();
}

interface Service2 {
	String invoke();
}

interface Service3 {
	String invoke();
}
