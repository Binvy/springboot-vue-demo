package com.binvi.springboot.demo03.leetcode;

import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/11/23 19:49
 */
public class LeetCode2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode result = new ListNode();
		int cur = 0, next = 0;
		while (l1 != null && l2 != null) {
			int plus = l1.val + l2.val + next;
			cur = plus % 10;
			next = plus / 10;
			result.val = cur;
			l1 = l1.next;
			l2 = l2.next;
			result = result.next = new ListNode();
		}
		while (l1 != null) {
			result.next = l1.next;
			l1 = l1.next;
			result = result.next;
		}
		while (l2 != null) {
			result.next = l2.next;
			l2 = l2.next;
			result = result.next;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] l1 = new int[]{9,9,9,9,9,9,9};
		int[] l2 = new int[]{9,9,9,9};

		ListNode node1 = ListNode.build(l1);
		ListNode node2 = ListNode.build(l2);

		ListNode node = new LeetCode2().addTwoNumbers(node1, node2);
		System.out.println(Arrays.toString(node.toArray()));
	}





}
