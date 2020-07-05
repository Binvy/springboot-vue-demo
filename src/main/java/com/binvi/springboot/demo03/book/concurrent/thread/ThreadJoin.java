package com.binvi.springboot.demo03.book.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/7/9 23:15
 */
public class ThreadJoin {

	public static void main(String[] args) throws Exception {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domion(previous), String.valueOf(i));
			thread.start();
			previous = thread;
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.printf("%s-%s terminate.\n",
				Thread.currentThread().getId(), Thread.currentThread().getName());
	}

	static class Domion implements Runnable {
		private Thread thread;
		public Domion(Thread thread) {
			this.thread = thread;
		}
		@Override
		public void run() {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%s-%s terminate.\n",
				Thread.currentThread().getId(), Thread.currentThread().getName());
		}
	}

}
