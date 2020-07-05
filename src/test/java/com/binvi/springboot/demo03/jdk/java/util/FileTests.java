package com.binvi.springboot.demo03.jdk.java.util;

import java.io.File;

import org.junit.Test;

import org.springframework.util.FileSystemUtils;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/4/15 18:30
 */
public class FileTests {

	@Test
	public void testNewFile() {
		String path = "C:\\Temp\\tmp";
		File file = new File(path);
		boolean done = false;
		for (;;) {
			done = FileSystemUtils.deleteRecursively(file);
			if (done) {
				break;
			}
		}
	}


}
