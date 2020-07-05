package com.binvi.springboot.demo03.interview.java.algorithm;

import org.apache.ibatis.annotations.ResultType;

/**
 * @author binvi
 * @version 1.0
 * @Description: 给定一个二叉搜索树(BST)，找到树中第 K 小的节点。
 * @date 2019/10/2 17:51
 */
public class FindKthSmallestNodeInBST {

	private ResultType find(TreeNode root, int K) {
		if (root == null) {
			return new ResultType(false, 0);
		}
		ResultType left = find(root.left, K);
		if (left.found) {
			return new ResultType(true, left.val);
		}
		if (left.val == K - 1) {
			return new ResultType(true, root.val);
		}
		ResultType right = find(root.right, K - left.val - 1);
		if (right.found) {
			return new ResultType(true, right.val);
		}
		return new ResultType(false, left.val + 1 + right.val);
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int val) {
			this.val = val;
		}
	}

	private class ResultType {
		boolean found; // 是否找到
		int val; // 节点数量
		ResultType(boolean found, int val) {
			this.found = found;
			this.val = val;
		}
	}

}
