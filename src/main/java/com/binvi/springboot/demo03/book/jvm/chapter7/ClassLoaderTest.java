package com.binvi.springboot.demo03.book.jvm.chapter7;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author binvi
 * @version 1.0
 * @Description: 对于任意一个类，都需要由加载它的类加载器和这个类本身一同确立其在Java虚拟机中的唯一性，每一个类加载器，都拥有一个独立的类空间名称。
 * @date 2019/9/18 21:36
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] bytes = new byte[is.available()];
					is.read(bytes);
					return defineClass(name, bytes, 0, bytes.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object object = myLoader.loadClass("com.binvi.springboot.demo03.book.jvm.chapter7.ClassLoaderTest").newInstance();
		System.out.println(object.getClass());
		System.out.println(object instanceof com.binvi.springboot.demo03.book.jvm.chapter7.ClassLoaderTest);
	}

}
