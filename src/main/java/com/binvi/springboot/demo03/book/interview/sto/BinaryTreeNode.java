package com.binvi.springboot.demo03.book.interview.sto;

/**
 * @author binvi
 * @version 1.0
 * @Description: 二叉树节点
 * @date 2021/5/17 22:46
 */
public class BinaryTreeNode {

	public Object item;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode() {
	}

	public BinaryTreeNode(Object item) {
		this.item = item;
	}
}
