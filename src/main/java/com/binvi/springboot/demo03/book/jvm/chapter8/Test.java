package com.binvi.springboot.demo03.book.jvm.chapter8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author binvi
 * @version 1.0
 * @Description: 子类调用祖父类方法
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
				// JDK 7 Update 9 之前如下代码可正常运行，并输出"i am grandfather"，该版本之后，会输出"i am father"
				// MethodType methodType = MethodType.methodType(void.class);
				// MethodHandle methodHandle = lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass());
				// methodHandle.invoke(this);

				// 通用版本
				MethodType methodType = MethodType.methodType(void.class);
				Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
				lookupImpl.setAccessible(true);
				MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null))
						.findSpecial(GrandFather.class, "thinking", methodType, GrandFather.class);
				mh.invoke(this);
			} catch (Throwable e) {

			}
		}
	}

	public static void main(String[] args) {
		(new Test().new Son()).thinking();
	}

}
