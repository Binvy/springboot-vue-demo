package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.ArrayList;

import org.springframework.util.Assert;

/**
 * @author binvi
 * @version 1.0
 * @Description: 剑指Offer-面试题3：找出数组中重复的数字
 *
 * 题目1：找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数字中任意一个重复的数字。例如。如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3
 *
 * 题目2：不修改数组找出重复的数字
 * @date 2021/5/15 15:22
 */
public class FindDuplicateNumberInArray {

	/**
	 * 需新建数组
	 * @param array
	 * @return
	 */
	public ArrayList<Integer> findDuplicateNumberInArray(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		int[] temp = new int[array.length];
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int m = array[i];
			if (++temp[m] > 1) {
				result.add(m);
			}
		}
		return result;
	}

	/**
	 * 无需新建数组
	 * @param array
	 * @return
	 */
	public ArrayList<Integer> findDuplicateNumberInArray2(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0 || array[i] > array.length - 1) {
				return null;
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			boolean find = false;
			while (array[i] != i && !find) {
				if (array[i] == array[array[i]]) {
					find = true;
					result.add(array[i]);
				} else {
					find = false;
					int temp = array[i];
					array[i] = array[temp];
					array[temp] = temp;
				}
			}
		}
		return result;
	}



	public static void main(String[] args) {
		FindDuplicateNumberInArray instance = new FindDuplicateNumberInArray();
		int[] array = null;
		ArrayList<Integer> result = instance.findDuplicateNumberInArray2(array);
		Assert.isNull(result, "this is should be null");

		array = new int[]{2, 3, 1, 0, 2, 5, 3};
		result = instance.findDuplicateNumberInArray2(array);
		System.out.println(result);
	}

}
