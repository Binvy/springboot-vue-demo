package com.binvi.springboot.demo03.book.javase.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/6/26 23:15
 */
public class ScanXan {

	public static void main(String[] args) throws IOException {
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

}
