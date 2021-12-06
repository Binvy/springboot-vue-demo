package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * @author binvi
 * @version 1.0
 * @Description: 剑指Offer-面试题28：对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @date 2021/5/17 21:34
 */
public class IsSymmetrical {

	public boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}

	private boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.left.item != root2.right.item) {
			return false;
		}
		return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
	}

	class BinaryTreeNode {
		Object item;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}

}
