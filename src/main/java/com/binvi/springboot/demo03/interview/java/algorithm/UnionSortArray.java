package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description: 合并两个有序数组
 * @date 2021/5/15 17:12
 */
public class UnionSortArray {

	public static int[] union(int[] array1, int[] array2) {
		if (array1 == null || array1.length == 0) {
			return array2;
		}
		if (array2 == null || array2.length == 0) {
			return array1;
		}
		int i = array1.length - 1;
		int j = array2.length - 1;
		int k = i + j + 1;
		int[] result = new int[k + 1];
		while (i >= 0 && j >= 0) {
			if (array1[i] > array2[j]) {
				result[k--] = array1[i--];
			} else {
				result[k--] = array2[j--];
			}
		}
		while (i >= 0) {
			result[k--] = array1[i--];
		}
		while (j >= 0) {
			result[k--] = array2[j--];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array1 = {1, 3, 5, 7, 9};
		int[] array2 = {2, 4, 6, 8, 10};
		int[] result = union(array1, array2);
		System.out.println(Arrays.toString(result));
	}

}
