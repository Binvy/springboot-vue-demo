package com.binvi.springboot.demo03.book.effectivejava.item49;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Objects;

/**
 * @author binvi
 * @version 1.0
 * @Description: 检查参数的有效性
 * @date 2019/9/4 21:08
 */
public class LegalArgs {

	private static final Logger logger = LoggerFactory.getLogger(LegalArgs.class);

	public static void main(String[] args) {
		BigInteger m = null;
		try {
			assertTest(m);
			nullTest(m);
			m = BigInteger.ZERO;
			modTest(m);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("参数异常", e);
		} catch (Error e) {
			logger.error(e.getMessage());
			logger.error("参数错误", e);
		}
	}

	public static void modTest(BigInteger m) {
		if (m.signum() <= 0) {
			throw new ArithmeticException("BigInteger: modulus not positive");
		}
	}

	public static void nullTest(BigInteger m) {
		Objects.requireNonNull(m, "m不能为空");
	}

	private static void assertTest(BigInteger m) {
		assert m != null : "m should not be null";
	}

}
