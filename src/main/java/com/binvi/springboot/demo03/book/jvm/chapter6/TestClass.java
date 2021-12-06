package com.binvi.springboot.demo03.book.jvm.chapter6;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/16 22:02
 */
public class TestClass {

	private int m;

	public int inc() {
		return m + 1;
	}

	public int ind() {
		int x;
		try {
			x = 1;
			return x;
		} catch (Exception e) {
			x = 2;
			return x;
		} finally {
			x = 3;
		}
	}

	public void onlyMe(Object o) {
		synchronized (o) {
			inc();
		}
	}

}
