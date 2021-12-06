package com.binvi.springboot.demo03.book.interview.sto;

/**
 * @author binvi
 * @version 1.0
 * @Description: 面试题28：对称的二叉树
 * 题目：请实现一个函数，用来判断一个二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称。
 * @date 2021/5/17 22:57
 */
public class Sto28IsSymmetrical {

	public boolean isSymmetrical(BinaryTreeNode node) {
		return isSymmetrical(node, node);
	}

	private boolean isSymmetrical(BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.left.item != node2.right.item) {
			return false;
		}
		return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
	}

}
