package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * 已知sqrt(2)约等于1.414，要求不用数学库，求sqrt(2)精确到小数点后10位
 */
public class SqrtPrecisionTest {

	double EPSILON = 0.0000000001;

	/**
	 * 二分查找法
	 * @return
	 */
	public double calculateSqrtTwoWithDouble() {
		double low = 1.4, high = 1.5;
		double mid = (low + high) / 2;
		while (high - mid > EPSILON) {
			if (mid * mid > 2) {
				high = mid;
			} else {
				low = mid;
			}
			mid = (low + high) / 2;
		}
		return mid;
	}

	/**
	 * 牛顿迭代法
	 * @param c
	 * @return
	 */
	private double sqrtWithNewton(double c) {
		if ( c < 0 ) {
			return Double.NaN;
		}
		double e = 1e-10;
		double x = c;
		double y = (x + c / x) / 2;
		while (Math.abs(x - y) > e) {
			x = y;
			y = (x + c / x) / 2;
		}
		return x;
	}

	public static void main(String[] args) {
		SqrtPrecisionTest test = new SqrtPrecisionTest();
		System.out.println(test.calculateSqrtTwoWithDouble());
		System.out.println(test.sqrtWithNewton(2));
	}

}
