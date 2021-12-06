package com.binvi.springboot.demo03.interview.java.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author binvi
 * @version 1.0
 * @Description: 快速排序
 * @date 2021/5/15 20:13
 */
public class QuickSort {

	public static void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int index = partition(array, start, end);
		if (index > start) {
			quickSort(array, start, index - 1);
		}
		if (index < end) {
			quickSort(array, index + 1, end);
		}
	}

	private static int partition(int[] array, int start, int end) {
		if (array == null || array.length == 0 || start < 0 || end >= array.length) {
			throw new IllegalArgumentException("invalid parameters");
		}
		int index = randomInRange(start, end);
		swap(array, index, end);
		int small = start - 1;
		for (index = start; index < end; ++index) {
			if (array[index] < array[end]) {
				++small;
				if (small != index) {
					swap(array, index, small);
				}
			}
		}
		++small;
		swap(array, small, end);
		return small;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;;
	}

	private static int randomInRange(int start, int end) {
		return start + new Random().nextInt(end - start);
	}

	public static void main(String[] args) {
		int[] array = {4, 2, 3, 1, 5, 9, 6, 9, 8, 7, 3, 2, 1};
		array = new int[]{3, 2, 4, 1};
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	public static void quickSort2(int[] array, int start, int end) {
		if (start < end) {
			swap(array, start, (start + end) >> 1);
			int left = start, right = end, x = array[left];
			while (left < right) {
				while (left < right && array[right] >= x) {
					right--;
				}
				if (left < right) {
					array[left++] = array[right];
				}
				while (left < right && array[left] < x) {
					left++;
				}
				if (left < right) {
					array[right--] = array[left];
				}
			}
			array[left] = x;
			quickSort2(array, start, left - 1);
			quickSort2(array, left + 1, end);
		}
	}

}
