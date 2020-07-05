package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * @author binvi
 * @version 1.0
 * @Description: 如何实现一个高效的单向链表逆序输出？
 * @date 2019/10/2 15:04
 */
public class ReverseSingleLinkedList {

	private void reverse(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		Node prev = null;
		Node curr = head.next;
		Node next;
		while (curr != null) {
			if (curr.next == null) {
				curr.next = prev;
				break;
			}
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head.next = curr;
		Node tmp = head.next;
		while (tmp != null) {
			Object item = tmp.item;
			tmp = tmp.next;
		}
	}

	static class Node<E> {
		E item;
		Node<E> next;
		Node(E item) {
			this.item = item;
		}
	}

}
