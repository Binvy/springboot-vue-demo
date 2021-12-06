package com.binvi.springboot.demo03.leetcode;

import java.util.ArrayList;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/11/23 19:50
 */
public class ListNode {

	int val;

	ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public static ListNode build(int[] array) {
		ListNode first = null;
		ListNode pred = null;
		for (int item : array) {
			ListNode newNode = new ListNode(item);
			if (pred == null) {
				first = newNode;
			} else {
				pred.next = newNode;
			}
			pred = newNode;
		}
		return first;
	}

	public Integer[] toArray() {
		ArrayList<Integer> list = new ArrayList<>();
		ListNode node = this;
		while (node != null) {
			list.add(this.val);
			node = node.next;
		}
		return list.toArray(new Integer[]{});
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}

}
