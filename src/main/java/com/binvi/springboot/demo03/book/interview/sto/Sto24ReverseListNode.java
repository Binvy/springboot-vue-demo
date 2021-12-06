package com.binvi.springboot.demo03.book.interview.sto;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 *
 *  	a -> b -> c -> ...-> h -> i -> j ->... -> z -> null
 *  	null <-	a <- b <- c <- ...<- h <- i <- j <-... <- z
 *
 * @date 2021/5/20 19:33
 */
public class Sto24ReverseListNode {

	public static ListNode reverse(ListNode root) {
		if (root == null || root.next == null) {
			return root;
		}

		ListNode reversedHead = null;
		ListNode node = root;
		ListNode next = root.next;

		return null;
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		ListNode tail = reverse(root);
		System.out.println(tail.value);
	}

}

class ListNode {
	int value;
	ListNode next;

	public ListNode(int value) {
		this.value = value;
	}
}
