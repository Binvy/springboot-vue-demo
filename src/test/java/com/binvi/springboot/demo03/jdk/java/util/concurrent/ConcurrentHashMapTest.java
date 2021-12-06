package com.binvi.springboot.demo03.jdk.java.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/11/24 22:42
 */
public class ConcurrentHashMapTest {

	@Test
	public void testPut() {
		ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 1000; i++) {
			map.put(i, i);
		}
	}

}
