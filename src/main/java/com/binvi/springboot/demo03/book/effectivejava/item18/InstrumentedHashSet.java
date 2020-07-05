package com.binvi.springboot.demo03.book.effectivejava.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author binvi
 * @version 1.0
 * @Description: 组合优于继承
 * @date 2019/8/31 10:08
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

	private int addCount = 0;

	public InstrumentedHashSet() {}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		InstrumentedHashSet<Object> set = new InstrumentedHashSet<>();
		set.addAll(Arrays.asList("snap", "crackle", "pop"));
		System.out.println("addCount:" + set.getAddCount());
	}

}
