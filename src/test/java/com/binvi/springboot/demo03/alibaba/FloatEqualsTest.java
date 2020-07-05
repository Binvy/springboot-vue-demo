package com.binvi.springboot.demo03.alibaba;

import java.math.BigDecimal;

/**
 * @author binvi
 * @version 1.0
 * @Description: float浮点数之间的等值判断
 * 		浮点数采用“尾数+阶码”的编码方式，类似于科学记数法的“有效数字+指数”的表示方式，
 * 		二进制无法精确表示大部分的十进制效数。
 * @date 2019/6/24 22:12
 */
public class FloatEqualsTest {

	public static void main(String[] args) {
		float a = 1.0f - 0.9f;
		float b = 0.9f - 0.8f;

		System.out.println("=========== 反例 ===========");

		// 1. 基本数据类型不能用==来比较
		if (a == b) {
			System.out.println("a == b");
		}

		// 2. 包装数据类型不能用equals来比较
		Float x = Float.valueOf(a);
		Float y = Float.valueOf(b);
		if (x.equals(y)) {
			System.out.println("x equals y");
		}

		System.out.println("=========== 正例 ===========");

		// 1. 指定误差范围，两个浮点数的误差在次范围内，则认为是相等的。
		float diff = 1e-6f;
		if (Math.abs(a - b) < diff) {
			System.out.println("a == b");
		}

		// 2. 使用BigDecimal来定义值，再进行浮点数的运算操作
		BigDecimal i = new BigDecimal("0.9");
		BigDecimal j = new BigDecimal("0.8");
		BigDecimal k = new BigDecimal("0.7");

		BigDecimal m = i.subtract(j);
		BigDecimal n = j.subtract(k);
		if (m.equals(n)) {
			System.out.println("m == n");
		}

	}

}
