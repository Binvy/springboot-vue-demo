package com.binvi.springboot.demo03.book.jvm.chapter8;

/**
 * @author binvi
 * @version 1.0
 * @Description: placeholder能否被回收的根本原因是：局部变量表中的Slot是否还存在有关于placeholder数组对象的引用。
 * @date 2019/9/18 22:45
 */
public class GcTest {

	int a;

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		int b;
		// 类变量有两次赋初始值的过程（1. 准备阶段赋予系统初始值 2. 初始化阶段赋予定义的初始值）
		System.out.println(new GcTest().a);
		// 但如果一个局部变量定义了但没有赋初始值是不能使用的。
		// System.out.println(b);
	}

	/**
	 * 执行gc时，变量还处于作用域之内，虚拟机自然不敢回收placeholder的内存。
	 */
	private static void test1() {
		byte[] placeholder = new byte[64 * 1024 * 1024];
		System.gc();
	}

	/**
	 * 代码虽然离开了placeholder的作用域，但在此之后，没有任何对局部变量的读写操作，
	 * placeholder原本所占用的Slot还没有被其他变量所复用，所以作为GC Roots一部分的局部变量仍然保持着对它的关联。
	 */
	private static void test2() {
		{
			byte[] placeholder = new byte[64 * 1024 * 1024];
		}
		System.gc();
	}

	private static void test3() {
		{
			byte[] placeholder = new byte[64 * 1024 * 1024];
		}
		int i = 0;
		System.gc();
	}

}
