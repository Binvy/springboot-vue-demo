package com.binvi.springboot.demo03.jdk.java.util;

import com.sun.media.sound.SoftTuning;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description: 增强for循环，须进行null校验
 * @date 2019/7/28 11:53
 */
public class ForTest {

	public String test() {
		Class<? extends ForTest> clazz = getClass();
		return clazz.getSimpleName();
	}

	public static void main(String[] args) {
		ForTest test = new ForTest();
		String clazz = test.test();
		System.out.println(clazz);

		String[] array = new String[]{"1", "2", "3"};
		String[] nullArray = null;
		for (String s : array) {
			System.out.println(s);
		}
		for (String s : nullArray) {
			System.out.println(s);
		}

		List<String> nullList = null;
		List<String> emptyList = new ArrayList<>();
		Set<String> nullSet = null;
		Set<String> emptySet = new HashSet<>();
		for (String s : nullList) {
			System.out.println(s);
		}
		for (String s : emptyList) {
			System.out.println(s);
		}
		for (String s : nullSet) {
			System.out.println(s);
		}
		for (String s : emptySet) {
			System.out.println(s);
		}
	}

}
