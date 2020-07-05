package com.binvi.springboot.demo03.book.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author binvi
 * @version 1.0
 * @Description: 独占锁-自定义同步组件
 * @date 2019/7/10 22:54
 */
public class Mutex implements Lock {

	/**
	 * 静态内部类，自定义同步器
	 */
	private static class Sync extends AbstractQueuedSynchronizer {
		/**
		 * 是否处于占用状态
		 * @return true-占用 false-未占用
		 */
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		/**
		 * 状态为0的时候获取锁
		 * @param acquires
		 * @return
		 */
		public boolean tryAcquire(int acquires) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		/**
		 * 释放锁，将状态设置为0
		 * @param release
		 * @return
		 */
		protected boolean tryRelease(int release) {
			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		/**
		 * 返回一个Condition，每个Condition都包含一个Condition列队
		 * @return
		 */
		Condition newCondition() {
			return new ConditionObject();
		}
	}

	// 将同步锁上的操作代理到静态内部类Sync上
	private final Sync sync = new Sync();

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

	public boolean isLocked() {
		return sync.isHeldExclusively();
	}

	public boolean hasQueuedThreads() {
		return sync.hasQueuedThreads();
	}
}
