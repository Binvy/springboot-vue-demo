package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/5/16 12:06
 */
public class Print1ToMaxOfNDigits {

	public static void print1ToMaxOfNDigits(int n) {
		if (n < 0) {
			return;
		}
		int max = (int)Math.pow(10, n) - 1;
		for (int i = 0; i <= max; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		print1ToMaxOfNDigits(5);
	}

}
