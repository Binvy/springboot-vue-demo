package com.binvi.springboot.demo03.alibaba;

import java.util.Arrays;

/**
 * @author binvi
 * @version 1.0
 * @Description: 使用索引访问用String的split方法得到的数组时，
 * 		需做最后一个分隔符号后有无内容的检查，否则会有抛IndexOutOfBoundsException的风险
 * @date 2019/6/24 22:37
 */
public class StringSplitTest {

	public static void main(String[] args) {

		String str = ",,,,,,,,,,,,,,,,a,b,,,,,,,,,,,,,c,d,,,,,,,,,,";
		String[] ary = str.split(",");
		System.out.println(Arrays.toString(ary));

	}
}
