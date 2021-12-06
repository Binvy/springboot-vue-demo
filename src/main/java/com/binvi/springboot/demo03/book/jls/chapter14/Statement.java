package com.binvi.springboot.demo03.book.jls.chapter14;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/12/1 21:23
 */
public class Statement {

	public static void main(String[] args) {
		shortIf();
	}

	private static void shortIf() {
		boolean open = true;
		boolean visible = false;
		if (open)
			if (visible)
				System.out.println(true);
		else System.out.println(false);
	}

}
