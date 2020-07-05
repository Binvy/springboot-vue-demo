package com.binvi.springboot.demo03.book.jvm.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/19 22:50
 */
public class Test {

	class GrandFather {
		void thinking() {
			System.out.println("i am grandfather");
		}
	}

	class Father extends GrandFather {
		void thinking() {
			System.out.println("i am father");
		}
	}

	class Son extends Father {
		void thinking() {
			try {
				MethodType methodType = MethodType.methodType(void.class);
				MethodHandle methodHandle = lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass());
				methodHandle.invoke(this);
			} catch (Throwable e) {

			}
		}
	}

	public static void main(String[] args) {
		(new Test().new Son()).thinking();
	}

}
