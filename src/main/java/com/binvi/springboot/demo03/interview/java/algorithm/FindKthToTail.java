package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author binvi
 * @version 1.0
 * @Description: 求链表中的倒数第k个节点
 * 思路：用两个指针，第一个指针先走k-1步，然后两个指针一起走，当第一个指针走到尾节点的时候，第二个指针指向的就是倒数第k个节点
 * @date 2021/5/15 11:29
 */
public class FindKthToTail {

	public Object findKthToTail(LinkedList<Object> nodes, int k) {
		if (nodes == null || nodes.isEmpty() || k <= 0) {
			return null;
		}
		Iterator<Object> iterator = nodes.iterator();
		int number = 0;
		while (iterator.hasNext() && ++number < k) {
			iterator.next();
		}
		Iterator<Object> iterator2 = nodes.iterator();
		Object result = null;
		while (iterator.hasNext()) {
			iterator.next();
			result = iterator2.next();
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedList<Object> nodes = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		int k = 20;
		Object result = new FindKthToTail().findKthToTail(nodes, k);
		System.out.println(result);
	}

}
