package com.binvi.springboot.demo03.book.jvm.chapter7;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/18 20:51
 */
public class ConstClass {

	static {
		System.out.println("constClass init!");
	}

	public static final String HELLOWORLD = "Hello World!";

}
