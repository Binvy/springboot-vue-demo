package com.binvi.springboot.demo03.book.jvm.chapter8;

/**
 * @author binvi
 * @version 1.0
 * @Description: 方法静态分派演示
 * @date 2019/9/19 21:22
 */
public class StaticDispatch {

	static abstract class Human{}

	static class Man extends Human {}

	static class Woman extends Human {}

	public void sayHello(Human guy) {
		System.out.println("hello, guy");
	}

	public void sayHello(Man man) {
		System.out.println("hello, man");
	}

	public void sayHello(Woman woman) {
		System.out.println("hello, woman");
	}

	public static void main(String[] args) {
		// Human:变量的静态类型 Man:变量的实际类型
		// 虚拟机（编译器）在重载时是通过参数的静态类型而不是实际类型作为判断依据的。
		// 在编译阶段，Javac编译器会根据参数的静态类型决定使用哪个重载版本
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch staticDispatch = new StaticDispatch();
		staticDispatch.sayHello(man);
		staticDispatch.sayHello(woman);
	}

}
