package com.binvi.springboot.demo03.book.javase.io;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 *    %1$+020.10f %n说明：
 *        %: Begin Format Specifier
 *        1$: Argument Index
 *        +0: Flags
 *        20: Width
 *        .10: Precision
 *        f: Conversion
 * @date 2020/6/26 23:41
 */
public class Format {

	public static void main(String[] args) {
		int i = 2;
		double r = Math.sqrt(i);

		System.out.print("The square root of ");
		System.out.print(i);
		System.out.print(" is ");
		System.out.print(r);
		System.out.println(".");

		i = 5;
		r = Math.sqrt(i);
		System.out.println("The square root of " + i + " is " + r + ".");

		System.out.format("The square root of %d is %f.%n", i, r);

		System.out.format("%f, %1$+020.10f %n", Math.PI);

		System.out.format("%f, %<+020.10f %n", Math.PI);

	}

}
