package com.binvi.springboot.demo03.book.jvm.chapter9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author binvi
 * @version 1.0
 * @Description: 动态代理的简单用法
 * @date 2019/9/21 10:29
 */
public class DynamicProxyTest {

	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {
		@Override
		public void sayHello() {
			System.out.println("hello world");
		}
	}

	static class DynamicProxy implements InvocationHandler {
		Object originalObj;
		Object bind(Object originalObj) {
			this.originalObj = originalObj;
			return Proxy.newProxyInstance(
					originalObj.getClass().getClassLoader(),
					originalObj.getClass().getInterfaces(),
					this);
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}
	}

	private void test() {
		try {
			Class<?> dynamicProxyTestClass = Class.forName("com.binvi.springboot.demo03.book.jvm.chapter9.DynamicProxyTest$Hello");
			Class<?>[] interfaces = dynamicProxyTestClass.getInterfaces();
			System.out.println(interfaces.length);
			Method sayHello = dynamicProxyTestClass.getMethod("sayHello", null);
			sayHello.invoke(dynamicProxyTestClass.newInstance(), null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
		System.out.println("------------");
		(new DynamicProxyTest()).test();
	}



}
