package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.Stack;

/**
 * @author binvi
 * @version 1.0
 * @Description: 剑指Offer-面试题6：从尾到头打印链表
 * @date 2021/5/15 18:28
 */
public class PrintListReversingly {

	public static void printListReversinglyIterator(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		Stack<Object> stack = new Stack<>();
		for (int i : array) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}



	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		printListReversinglyIterator(array);
	}

}
