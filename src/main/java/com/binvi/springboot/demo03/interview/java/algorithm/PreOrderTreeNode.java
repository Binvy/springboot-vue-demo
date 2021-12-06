package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.binvi.springboot.demo03.book.interview.sto.BinaryTreeNode;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/5/19 18:54
 */
public class PreOrderTreeNode {

	/**
	 *
	 * @param root TreeNode类
	 * @return int整型ArrayList
	 */
	public static ArrayList<Object> preorderTraversal (BinaryTreeNode root) {
		// write code here
		ArrayList<Object> datas = new ArrayList<>();
		preorderTraversal(datas, root);
		return datas;
	}

	public static void preorderTraversal(List<Object> datas, BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			preorderTraversal(datas, node.left);
		}
		datas.add(node.item);
		if (node.right != null) {
			preorderTraversal(datas, node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);

		root.right = node2;
		node2.left = node3;

		ArrayList<Object> datas = preorderTraversal(root);
		System.out.println(datas);
	}

	public static void preOrder() {

	}

}
