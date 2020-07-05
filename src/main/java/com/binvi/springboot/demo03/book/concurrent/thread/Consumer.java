package com.binvi.springboot.demo03.book.concurrent.thread;

import java.util.Random;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/4/11 11:47
 */
public class Consumer implements Runnable {

	private Drop drop;

	public Consumer(Drop drop) {
		this.drop = drop;
	}

	public void run() {
		Random random = new Random();
		for (String message = drop.take();
			 ! message.equals("DONE");
			 message = drop.take()) {
			System.out.format("MESSAGE RECEIVED: %s%n", message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {}
		}
	}

}
