package com.binvi.springboot.demo03.book.concurrent.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/4/16 18:13
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

	private static final Logger logger = LoggerFactory.getLogger(MyThreadPoolExecutor.class);

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		logger.info("正在运行的线程数量：{}", getActiveCount());
		logger.info("线程池中出现过的最大线程数量：{}", getLargestPoolSize());

		logger.info("正在执行的任务数量：{}", getTaskCount());
		logger.info("已执行完成的任务数量：{}", getCompletedTaskCount());

		logger.info("队列中现有的任务数量：{}", getQueue().size());
		logger.info("队列中还允许添加的任务数量：{}", getQueue().remainingCapacity());

		logger.info("核心线程的数量：{}", getCorePoolSize());
		logger.info("线程池中允许的最大线程数量：{}", getMaximumPoolSize());
		logger.info("是否允许核心线程超时关闭：{}", allowsCoreThreadTimeOut());
		logger.info("线程空闲时间：{}", getKeepAliveTime(TimeUnit.SECONDS));



	}
}
