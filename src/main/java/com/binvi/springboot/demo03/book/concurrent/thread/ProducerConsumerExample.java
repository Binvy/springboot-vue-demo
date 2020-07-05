package com.binvi.springboot.demo03.book.concurrent.thread;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/4/11 11:47
 */
public class ProducerConsumerExample {

	public static void main(String[] args) {
		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}

}
