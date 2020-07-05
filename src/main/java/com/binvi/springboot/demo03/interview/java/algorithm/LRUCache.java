package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.HashMap;

/**
 * @author binvi
 * @version 1.0
 * @Description: LRU缓存机制
 *      需要实现以下
 *      1.维护一个双向链表，还有他的头结点和尾结点
 *      2.插入数据时，首先判断cache中是否有该结点？如果没有，检查缓存是否还有空间？如果没有空间，清除双线链表的尾部结点。将该结点插入到双向链表的头部
 *      3.根据key获得数据的时候，查看cache中是否有key对应的结点？如果有，将该结点插入到头结点前面，返回数据：：如果没有，返回-1。
 *
 * @date 2019/10/2 18:23
 */
public class LRUCache {

	private int capacity;
	private LinkNode first;
	private LinkNode last;
	private HashMap<Integer, LinkNode> cache;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>(capacity);
	}

	public int get(int key) {
		LinkNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		moveNodeToFirst(node);
		return node.val;
	}

	public void put(int key, int value) {
		LinkNode node = cache.get(key);
		if (node == null) {
			if (cache.size() >= capacity) {
				removeLastNode();
			}
			node = new LinkNode();
			node.key = key;
		}
		node.val = value;
		moveNodeToFirst(node);
		cache.put(key, node);
	}

	private void removeLastNode() {
		LinkNode node = last;
		last = last.prev;
		if (last != null) {
			last.next = null;
		} else {
			first = last = null;
		}
		cache.remove(node.key);
	}

	private void moveNodeToFirst(LinkNode node) {
		if (first == null) {
			return;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node == last) {
			last = last.prev;
		}
		if (last == null) {
			last = first = node;
			return;
		}
		node.next = first;
		first.prev = node;
		node.prev = null;
		first = node;
	}

	class LinkNode {
		LinkNode prev;
		LinkNode next;
		int key;
		int val;
	}

}
