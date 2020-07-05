package com.binvi.springboot.demo03.book.jvm.chapter7;

/**
 * @author binvi
 * @version 1.0
 * @Description: 虚拟机会保证一个类的<cinit>()方法在多线程环境中被正确地加锁、同步，
 * 				 如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<cinit>方法，其他线程都需要阻塞等待，知道活动线程执行<cinit>()方法完毕。
 * @date 2019/9/18 21:29
 */
public class CinitMultiThread {

	static class DeadLoopClass {
		static {
			if (true) {
				System.out.println(Thread.currentThread() + " init DeadLoopClass");
				while (true) {}
			}
		}
	}

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + " start");
				DeadLoopClass deadLoopClass = new DeadLoopClass();
				System.out.println(Thread.currentThread() + " over");
			}
		};

		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();

	}

}
