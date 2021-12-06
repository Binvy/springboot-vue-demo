package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/6/3 22:11
 */
public class ReverseCharArray {

	public static void reverseString(char[] s) {
		if (s == null || s.length <= 1) {
			return;
		}
		char temp;
		int low = 0;
		int high = s.length - 1;
		while (low < high) {
			temp = s[low];
			s[low] = s[high];
			s[high] = temp;
			low++;
			high--;
		}
	}


	public static void main(String[] args) {
		String str = "hello world";
		char[] s = str.toCharArray();
		reverseString(s);
		System.out.println(s);
	}

}
