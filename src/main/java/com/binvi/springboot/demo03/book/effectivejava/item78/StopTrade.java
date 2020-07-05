package com.binvi.springboot.demo03.book.effectivejava.item78;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author binvi
 * @version 1.0
 * @Description: 同步访问共享的可变数据
 * @date 2019/9/7 10:48
 */
public class StopTrade {

	private static final Logger logger = LoggerFactory.getLogger(StopTrade.class);

	private static boolean stopRequested;
	private static boolean stopRequested2;
	private static volatile boolean stopRequested3;

	private static volatile int nextSerialNumber = 0;
	private static final AtomicLong nextSerialNum = new AtomicLong();

	private static synchronized void requestStop() {
		stopRequested2 = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested2;
	}

	public static void main(String[] args) throws InterruptedException {
		test1();
		test2();
		test3();
		generateSerialNumber();
		generateSerialNumberAtomic();
	}

	/**
	 * 第一个线程轮询boolean域，通过第二个线程设置为true，表示第一个线程将终止自己。
	 * @throws InterruptedException
	 */
	private static void test1() throws InterruptedException {
		StopWatch mainStopWatch = new StopWatch("test1 main thread");
		mainStopWatch.start("test1 main thread");
		runInnerThread();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		mainStopWatch.stop();
		logger.info(mainStopWatch.prettyPrint());
	}

	/**
	 * synchronized读写同步，保证同步起作用。
	 * @throws InterruptedException
	 */
	private static void test2() throws InterruptedException {
		StopWatch stopWatch = new StopWatch("test2 main thread");
		stopWatch.start("test2 main thread");
		runInnerThread2();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());
	}

	/**
	 * volatile保证任何一个线程在读取该域的时候将看到刚刚被写入的值
	 * @throws InterruptedException
	 */
	private static void test3() throws InterruptedException {
		StopWatch mainStopWatch = new StopWatch("test3 main thread");
		mainStopWatch.start("test3 main thread");
		runInnerThread3();
		TimeUnit.SECONDS.sleep(1);
		stopRequested3 = true;
		mainStopWatch.stop();
		logger.info(mainStopWatch.prettyPrint());
	}

	/**
	 * 增量操作符++不是原子操作，如果只有volatile，没有synchronized同步，也无法正确工作
	 * ++操作：
	 *     先读取值，然后写回一个新值，相当于原来的值再加上1。
	 *     如果第二个线程在第一个线程读取旧值和写回新值期间读取这个域，第二个线程就会与第一个线程一起看到同一个值，并返回相同的序列号。导致安全性失败。
	 *
	 * 修正方法：方法声明中添加synchronized修饰符，确保多个调用不会交叉存取，确保每个调用都会看到之前所有调用的效果。
	 */
	private synchronized static void generateSerialNumber() {
		nextSerialNumber++;
	}

	/**
	 * 最好还是使用java.util.concurrent.atomic包中的原子类。
	 */
	private static void generateSerialNumberAtomic() {
		nextSerialNum.getAndIncrement();
	}

	/**
	 * 有个问题：
	 *
	 * 	如果程序有日志，如下：
	 * 	<pre>
	 * 	{@code
	 * 	    while (!stopRequested) {
	 * 	        ogger.info("i = " + i++);
	 * 	    }
	 * 	}
	 * 	</pre>
	 * 	本程序也可以在1s之后结束。<br>
	 * 	如果程序没有日志，如下：
	 * 	<pre>
	 * 	{@code
	 * 		while (!stopRequested) {
	 * 		    i++;
	 * 		}
	 * 	}
	 * 	</pre>
	 * 	程序会一直执行，无法结束。
	 *
	 * 	猜测原因：可能是因为logger.info日志导致多线程变量共享，从而使程序停止。
	 */
	private static void runInnerThread() {
		new Thread(()-> {
			StopWatch innerStopWatch = new StopWatch("inner thread1");
			innerStopWatch.start("inner thread1");
			int i = 0;
			while (!stopRequested) {
				i++;
				// System.out.println(i);
				// logger.info("i = " + i++);
			}
			innerStopWatch.stop();
			logger.info(innerStopWatch.prettyPrint());
		}).start();
	}

	private static void runInnerThread2() {
		new Thread(()-> {
			StopWatch innerStopWatch = new StopWatch("inner thread2");
			innerStopWatch.start("inner thread2");
			int i = 0;
			while (!stopRequested()) {
				i++;
			}
			innerStopWatch.stop();
			logger.info(innerStopWatch.prettyPrint());
		}).start();
	}

	private static void runInnerThread3() {
		new Thread(()-> {
			StopWatch innerStopWatch = new StopWatch("inner thread3");
			innerStopWatch.start("inner thread3");
			int i = 0;
			while (!stopRequested3) {
				i++;
			}
			innerStopWatch.stop();
			logger.info(innerStopWatch.prettyPrint());
		}).start();
	}

}
