package com.binvi.springboot.demo03.book.javase.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/6/26 23:25
 */
public class ScanSum {

	public static void main(String[] args) throws IOException {
		Scanner s = null;
		double sum = 0;
		try {
			s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
			s.useLocale(Locale.US);
			while (s.hasNext()) {
				if (s.hasNextDouble()) {
					sum += s.nextDouble();
				} else {
					s.next();
				}
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
		System.out.println(sum);
	}

}
