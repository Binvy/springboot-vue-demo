package com.binvi.springboot.demo03.book.javase.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/6/26 22:41
 */
public class CopyCharacters {

	public static void main(String[] args) throws IOException {
		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("xanadu.txt");
			out = new FileWriter("characteroutput.txt");

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
