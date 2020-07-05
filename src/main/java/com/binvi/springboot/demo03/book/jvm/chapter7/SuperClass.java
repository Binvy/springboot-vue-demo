package com.binvi.springboot.demo03.book.jvm.chapter7;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/18 20:45
 */
public class SuperClass {

	static {
		System.out.println("superClass init!");
	}

	public static int value = 123;

}
