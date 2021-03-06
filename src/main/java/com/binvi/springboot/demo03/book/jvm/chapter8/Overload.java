package com.binvi.springboot.demo03.book.jvm.chapter8;

import java.io.Serializable;

/**
 * @author binvi
 * @version 1.0
 * @Description: 编译期间选择静态分派目标的过程
 * @date 2019/9/19 21:32
 */
public class Overload {

	/*public static void sayHello(Object arg) {
		System.out.println("hello, object");
	}*/

	/*public static void sayHello(int arg) {
		System.out.println("hello, int");
	}*/

	/*public static void sayHello(long arg) {
		System.out.println("hello, long");
	}*/

	/*public static void sayHello(Character arg) {
		System.out.println("hello, character");
	}*/

	/*public static void sayHello(char arg) {
		System.out.println("hello, char");
	}*/

	public static void sayHello(char... arg) {
		System.out.println("hello, char...");
	}

	/*public static void sayHello(Serializable arg) {
		System.out.println("hello, serializable");
	}*/

	public static void main(String[] args) {
		sayHello('a');
	}


}
