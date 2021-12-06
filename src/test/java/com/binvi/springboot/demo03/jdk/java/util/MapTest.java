package com.binvi.springboot.demo03.jdk.java.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/6/3 22:05
 */
public class MapTest {

	@Test
	public void test() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1");
		String result = map.get(1L);
		System.out.println(result);
	}

	@Test
	public void testPut() {
		HashMap<Object, Object> map = new HashMap<>();
		for (int i = 0; i < 10000000; i++) {
			map.put(i, i);
		}
	}

}
