package com.binvi.springboot.demo03.book.effectivejava.item79;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description: 可观察的集合包装
 * @date 2019/9/7 13:48
 */
public class ObservableSet<E> extends ForwardingSet<E> {

	public ObservableSet(Set<E> s) {
		super(s);
	}

	/*
	 * ***************************************************************
	 *                   普通List + 锁，可能造成异常、死锁
	 * ***************************************************************
	 */
	private final List<SetObserver<E>> observers = Lists.newArrayList();

	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public boolean removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.remove(observer);
		}
	}

	/**
	 * 普通通知（会造成异常、死锁）
	 * @param element
	 */
	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers) {
				observer.added(this, element);
			}
		}
	}

	/**
	 * 使用快照进行通知（可避免异常、死锁）
	 * @param element
	 */
	private void nofityElementAddedWithSnapShot(E element) {
		List<SetObserver<E>> snapshot = null;
		synchronized (observers) {
			snapshot = new ArrayList<>(observers);
		}
		for (SetObserver<E> observer : snapshot) {
			observer.added(this, element);
		}
	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added) {
			notifyElementAdded(element);
		}
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c) {
			result |= add(element);
		}
		return result;
	}

	/*
	 * ***************************************************************
	 *         CopyOnWriteArrayList
	 * ***************************************************************
	 */
	private final List<SetObserver<E>> observersCW = Lists.newCopyOnWriteArrayList();

	public void addObserverCW(SetObserver<E> observer) {
		observersCW.add(observer);
	}

	public boolean removeObserverCW (E observer) {
		return observersCW.remove(observer);
	}

	public void nofityElementAddedOnCW (E element) {
		for (SetObserver<E> observer : observersCW) {
			observer.added(this, element);
		}
	}

}
