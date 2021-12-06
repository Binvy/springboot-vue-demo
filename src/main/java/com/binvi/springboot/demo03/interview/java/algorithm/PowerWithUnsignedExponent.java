package com.binvi.springboot.demo03.interview.java.algorithm;

/**
 * @author binvi
 * @version 1.0
 * @Description: 剑指Offer-面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent), 求base的exponent次方。不得使用库函数，同时不考虑大数问题。
 * @date 2021/5/16 11:30
 */
public class PowerWithUnsignedExponent {

	public static double power(double base, int exponent) {
		if (Double.doubleToLongBits(base) == 0 && exponent < 0) {
			return 0.0;
		}
		int absExponent = Math.abs(exponent);
		double result = powerWithUnsignedExponent(base, absExponent);
		if (exponent < 0) {
			result = 1 / result;
		}
		return result;
	}

	public static double powerWithUnsignedExponent(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

}
