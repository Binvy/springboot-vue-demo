package com.binvi.springboot.demo03.book.jvm.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author binvi
 * @version 1.0
 * @Description: Method Handle基础用法展示
 * @date 2019/9/19 21:59
 */
public class MethodHandleTest {

	static class ClassA {
		public void println(String s) {
			System.out.println(s + " from classA");
		}
	}

	public static void main(String[] args) throws Throwable {
		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
		getPrintInMH(obj).invokeExact("hello world");
	}

	private static MethodHandle getPrintInMH(Object reveiver) throws Throwable {
		MethodType methodType = MethodType.methodType(void.class, String.class);
		return MethodHandles.lookup() // 在指定类中查找符合给定的方法名称、方法类型、并且符合调用权限的方法句柄
				.findVirtual(reveiver.getClass(), "println", methodType)
				.bindTo(reveiver);
	}

}
