package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * @author binvi
 * @version 1.0
 * @Description: 剑指Offer-面试4：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date 2021/5/15 16:42
 */
public class FindNumberIn2DArray {

	public static boolean find(int[][] arrays, int rows, int columns, int number) {
		boolean found = false;
		if (arrays != null && rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while (row < rows && column > 0) {
				if (arrays[row][column] == number) {
					found = true;
					break;
				} else if (arrays[row][column] > number) {
					--column;
				} else {
					++row;
				}
			}
		}
		return found;
	}

	public static void main(String[] args) {
		int[][] arrays = {
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15},
		};
		int rows = 4;
		int columns = 4;
		int number = 7;
		boolean found = find(arrays, rows, columns, number);
		System.out.println(found);
	}


}
