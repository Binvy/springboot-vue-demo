package com.binvi.springboot.demo03.course.mooc.datastructure.chapter01;

import java.util.Random;

import org.springframework.util.StopWatch;

/**
 * @author binvi
 * @version 1.0
 * @Description: 最大子列和问题：给定N个整数的序列{A[1], A[2]......A[N]}，求函数f(i,j) = max{0, E(i<=k<=j)A[k]}的最大值
 * @date 2020/9/24 22:09
 */
public class MaxSubseqSum {

	public static void main(String[] args) {
		int[] range = {1, 10, 100, 1000, 5000};
		int n;
		for (int j = 0; j < range.length; j++) {
			n = range[j];
			System.out.println("n = " + n);

			int a[] = new int[n];
			Random random = new Random();
			for (int i = 0; i < n; i++) {
				a[i] = random.nextInt(n) * (random.nextBoolean() ? 1 : -1);
			}

			StopWatch stopWatch = new StopWatch();
			stopWatch.start("math1");
			math1(a, n);
			stopWatch.stop();
			stopWatch.start("math2");
			math2(a, n);
			stopWatch.stop();
			stopWatch.start("math3");
			math3(a, n);
			stopWatch.stop();
			stopWatch.start("math4");
			math4(a, n);
			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
		}
	}

	/**
	 * T(N) = O(N的3次方)
	 */
	public static int math1(int[] a, int n) {
		// tempSum为从a[i]到a[j]的子列和
		int tempSum, maxSum = 0;
		// i-子列左端位置，j-子列右段位置，k-i和j之间的位置
		int i, j, k;
		for (i = 0; i < n; i++) {
			for (j = i; j < n; j++) {
				tempSum = 0;
				for (k = i; k <= j; k++) {
					tempSum += a[k];
				}
				if (tempSum > maxSum) {
					maxSum = tempSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * T(N) = O(N的平方)
	 */
	public static int math2(int[] a, int n) {
		// tempSum为从a[i]到a[j]的子列和
		int tempSum, maxSum = 0;
		// i-子列左端位置，j-子列右段位置，k-i和j之间的位置
		int i, j, k;
		for (i = 0; i < n; i++) {
			tempSum = 0;
			for (j = i; j < n; j++) {
				tempSum += a[j];
				if (tempSum > maxSum) {
					maxSum = tempSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * 分而治之：T(N) = O(NlogN)
	 */
	public static int math3(int[] a, int n) {
		return divideAndConquer(a, 0, n - 1);
	}

	/**
	 * 分而治法求a[left]到a[rigth]的最大子列和
	 */
	private static int divideAndConquer(int[] a, int left, int right) {
		int maxLeftSum, maxRightSum; // 存放左右子列的最大和
		int maxLeftBorderSum, maxRightBorderSum; // 存放左右跨分界线的结果

		int leftBorderSum, rightBorderSum;
		int center, i;

		if (left == right) {
			if (a[left] > 0) {
				return a[left];
			} else {
				return 0;
			}
		}

		// “分”的过程
		center = (left + right) / 2;
		// 递归求得两边子列的最大和
		maxLeftSum = divideAndConquer(a, left, center);
		maxRightSum = divideAndConquer(a, center + 1, right);

		// 求跨分界线的子列和
		maxLeftBorderSum = 0;
		leftBorderSum = 0;
		for (i = center; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}

		maxRightBorderSum = 0;
		rightBorderSum = 0;
		for (i = center + 1; i <= right; i++) {
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}

		// 返回“治”的结果
		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}

	/**
	 * 返回三个数中的最大值
	 */
	private static int max3(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}


	/**
	 * 在线处理：T(N) = O(N)
	 */
	public static int math4(int[] a, int n) {
		int tempSum = 0, maxSum = 0;
		int i;
		for (i = 0; i < n; i++) {
			tempSum += a[i];
			if (tempSum > maxSum) {
				maxSum = tempSum;
			} else if (tempSum < 0) {
				tempSum = 0;
			}
		}
		return maxSum;
	}


}
