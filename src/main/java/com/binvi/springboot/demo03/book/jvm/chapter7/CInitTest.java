package com.binvi.springboot.demo03.book.jvm.chapter7;

/**
 * @author binvi
 * @version 1.0
 * @Description: <cinit>方法是由编译器自动收集类种的所有类变量的赋值动作和静态语句块中的语句合并产生的，收集的顺序是由语句在源文件中出现的顺序所决定。
 * @date 2019/9/18 21:17
 */
public class CInitTest {

	static {
		i = 0;
		// 静态语句块中只能访问到定义在它之前的变量，定义在它之后的变量，在前面的静态语句块可以赋值，但是不能访问。
		// System.out.println(i); // 非法向前引用
	}

	static int i = 1;

	static class Parent {
		public static int A = 1;
		static {
			A = 2;
		}
	}

	static class Sub extends Parent {
		public static int B = A;
	}

	public static void main(String[] args) {
		int i = 1;
		System.out.println(Sub.B);
	}


}
