package com.binvi.springboot.demo03.book.effectivejava.item19;

/**
 * @author binvi
 * @version 1.0
 * @Description: 构造方法中调用私有方法，其中任何一个方法都不可重写（包括私有方法、final方法、static方法）
 * @date 2019/8/31 10:58
 */
public class Super {

	public Super() {
		overrideMe();
	}

	public void overrideMe() {}

}
