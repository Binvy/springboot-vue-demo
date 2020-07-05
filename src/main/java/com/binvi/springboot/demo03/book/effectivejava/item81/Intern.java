package com.binvi.springboot.demo03.book.effectivejava.item81;

import com.google.common.collect.Maps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/8 11:56
 */
public class Intern {

	private static final ConcurrentMap<String, String> map = Maps.newConcurrentMap();

	public static String intern1(String s) {
		String previousValue = map.putIfAbsent(s, s);
		return previousValue == null ? s : previousValue;
	}

	public static String intern2(String s) {
		String result = map.get(s);
		if (result == null) {
			result = map.putIfAbsent(s, s);
			if (result == null) {
				result = s;
			}
		}
		return result;
	}

}
