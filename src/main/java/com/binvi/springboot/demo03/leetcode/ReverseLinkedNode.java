package com.binvi.springboot.demo03.leetcode;

import java.util.Stack;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/11/24 18:47
 */
public class ReverseLinkedNode {

	/**
	 * 通过Stack实现
	 */
	public ListNode reverse(ListNode node) {
		if (node == null) {
			return null;
		}
		Stack<ListNode> stack = new Stack<>();
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		ListNode first = new ListNode();
		ListNode temp = first;
		for (ListNode item : stack) {
			temp.next = item;
			temp = temp.next;
		}
		return first.next;
	}

}
