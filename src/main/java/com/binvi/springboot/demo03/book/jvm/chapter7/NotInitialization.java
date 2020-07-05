package com.binvi.springboot.demo03.book.jvm.chapter7;

/**
 * @author binvi
 * @version 1.0
 * @Description: 对于静态字段，只有直接定义这个字段的类才会被初始化。
 * 		1. 通过子类引用父类的静态字段，不会导致子类初始化
 * 		2. 通过数组定义来引用类，不会触发此类的初始化
 * 	    3. 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @date 2019/9/18 20:46
 */
public class NotInitialization {

	public static void main(String[] args) {
		// 1. 通过子类引用父类的静态字段，不会导致子类初始化
		System.out.println(SubClass.value);
		// 2. 通过数组定义来引用类，不会触发此类的初始化
		SuperClass[] superClasses = new SuperClass[10];
		// 3. 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
		System.out.println(ConstClass.HELLOWORLD);
	}

}
