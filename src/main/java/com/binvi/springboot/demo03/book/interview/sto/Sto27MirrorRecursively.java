package com.binvi.springboot.demo03.book.interview.sto;

/**
 * @author binvi
 * @version 1.0
 * @Description: 面试题27：二叉树的镜像
 * 题目：请完成一个函数，输入一棵二叉树，该函数输出它的镜像。二叉树节点的定义如下：
 * class BinaryTreeNode {
 *     Object item;
 *     BinaryTreeNode left;
 *     BinaryTreeNode right;
 * }
 * @date 2021/5/17 22:44
 */
public class Sto27MirrorRecursively {

	public void mirrorRecursively(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		}

		BinaryTreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		if (node.left != null) {
			mirrorRecursively(node.left);
		}
		if (node.right != null) {
			mirrorRecursively(node.right);
		}
	}

}
