package com.binvi.springboot.demo03.course.mooc.datastructure.chapter01;

/**
 * @author binvi
 * @version 1.0
 * @Description: 写程序实现一个函数printN，使得传入一个正整数为N的参数后，能顺序打印从1到N的全部正整数
 * @date 2020/9/24 20:57
 */
public class PrintN {

	public static void main(String[] args) {
		int n = 10;
		printFor(n);
		System.out.println("-------------");
		printRecursive(n);
	}

	/**
	 * 循环实现
	 */
	public static void printFor(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}

	/**
	 * 递归实现：由于每次递归会保存之前的执行数据，当n值很大时，占用空间会很大
	 */
	public static void printRecursive(int n) {
		if (n > 0) {
			printRecursive(n - 1);
			System.out.println(n);
		}
		return;
	}

}
