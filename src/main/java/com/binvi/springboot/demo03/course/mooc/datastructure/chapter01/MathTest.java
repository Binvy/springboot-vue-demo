package com.binvi.springboot.demo03.course.mooc.datastructure.chapter01;

import org.springframework.util.StopWatch;

/**
 * @author binvi
 * @version 1.0
 * @Description: 写程序计算给定多项式在给定点x处的值，f(x) = a[0] + a[1] * b[1次方] + a[n-1] * b[n-1次方] + a[n] * b[n次方]
 * @date 2020/9/24 21:31
 */
public class MathTest {

	public static void main(String[] args) {
		int n = 10000000;
		double[] a = new double[n + 1];
		for (int i = 0; i <= n; i++) {
			a[i] = i;
		}
		double b = 10;

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("math1");
		math1(n, a, b);
		stopWatch.stop();
		stopWatch.start("math2");
		math2(n, a, b);
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
	}

	/**
	 * 按表达式计算
	 */
	public static double math1(int n, double[] a, double b) {
		double sum = a[0];
		for (int i = 1; i <= n; i++) {
			sum += a[i] * Math.pow(b, i);
		}
		return sum;
	}

	/**
	 * 按变形式计算： a[0] + b * (a[1] + b * (a[2] + b * (...... b * (a[n-1] + b * a[n]))))
	 */
	public static double math2(int n, double[] a, double b) {
		double sum = a[n];
		for (int i = n; i > 0; i--) {
			sum = a[i-1] + b * sum;
		}
		return sum;
	}

}
