package com.binvi.springboot.demo03.util;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description: 随机密码生成器
 * @date 2021/6/6 19:17
 */
public class RandomPasswordGenerator {

	private static final Logger logger = LoggerFactory.getLogger(RandomPasswordGenerator.class);

	private static final SecureRandom SECURE_RANDOM = new SecureRandom();

	/** random string generator */
	private static final RandomStringGenerator RANDOM_STRING_GENERATOR;
	/** printable random string generator */
	private static final RandomStringGenerator PRINTABLE_RANDOM_STRING_GENERATOR;
	/** numeric random string generator */
	private static final RandomStringGenerator NUMERIC_RANDOM_STRING_GENERATOR;
	/** alphabetic random string generator */
	private static final RandomStringGenerator ALPHABETIC_RANDOM_STRING_GENERATOR;
	/** alphanumeric random string generator */
	private static final RandomStringGenerator ALPHANUMERIC_RANDOM_STRING_GENERATOR;
	/** special code random string generator */
	private static final RandomStringGenerator SPECIAL_CODE_RANDOM_STRING_GENERATOR;
	/** default password length */
	private static final int DEFAULT_PASSWORD_LENGTH = 10;
	/** printable char */
	private static final char[] PRINT_PAIRS = {32, 126};
	/** numeric char */
	private static final char[][] NUMERIC_PAIRS = {{'0', '9'}};
	/** alphanumeric char: 0(48) - 9(57), A(65) - Z(90) , a(97) - z(122) */
	private static final char[][] ALPHANUMERIC_PAIRS = {{'a', 'z'}, {'A', 'Z'}, {'0', '9'}};
	/** alphabetic char: A(65) - Z(90) , a(97) - z(122) */
	private static final char[][] ALPHABETIC_PAIRS = {{'a', 'z'}, {'A', 'Z'}};
	/** all ascii char */
	private static final char[] ASCII_PAIRS = {'\u0000', '\uFFFF'};
	/** printable special char: except number[0-9], alphabet[A-Z, a-z] */
	private static final char[][] SPECIAL_PAIRS = {{32, 47}, {58, 64}, {91, 96}, {123, 126}};
	static {
		RANDOM_STRING_GENERATOR = new RandomStringGenerator.Builder()
				.build();
		PRINTABLE_RANDOM_STRING_GENERATOR = new RandomStringGenerator.Builder()
				.withinRange(PRINT_PAIRS)
				.build();
		NUMERIC_RANDOM_STRING_GENERATOR = new RandomStringGenerator.Builder()
				.withinRange(NUMERIC_PAIRS)
				.build();
		ALPHABETIC_RANDOM_STRING_GENERATOR = new RandomStringGenerator.Builder()
				.withinRange(ALPHABETIC_PAIRS)
				.build();
		ALPHANUMERIC_RANDOM_STRING_GENERATOR = new RandomStringGenerator.Builder()
				.withinRange(ALPHANUMERIC_PAIRS)
				.build();
		SPECIAL_CODE_RANDOM_STRING_GENERATOR = new RandomStringGenerator.Builder()
				.withinRange(SPECIAL_PAIRS)
				.build();
	}

	/**
	 * 随机生成10位长度的密码: 字母、数字、特殊符号
	 * @return
	 */
	public static String generateRandomPassword() {
		return generateRandomPassword(DEFAULT_PASSWORD_LENGTH);
	}

	/**
	 * 随机生成密码: 字母、数字、特殊符号
	 * @return
	 */
	public static String generateRandomPassword(int length) {
		String randomString = PRINTABLE_RANDOM_STRING_GENERATOR.generate(length);
		return randomString;
	}

	/**
	 * 随机生成密码: 字母、数字、特殊符号（必须包含该字符）
	 * @return
	 */
	public static String generateRandomPrintPassword() {
		return generateRandomPrintPassword(DEFAULT_PASSWORD_LENGTH);
	}

	/**
	 * 随机生成密码: 字母、数字、特殊符号（必须包含该字符）
	 * @return
	 */
	public static String generateRandomPrintPassword(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("password length must be positive");
		}
		int numberCount = SECURE_RANDOM.nextInt(length - 2);
		numberCount = numberCount == 0 ? 1 : numberCount;
		String numberString = NUMERIC_RANDOM_STRING_GENERATOR.generate(numberCount);

		int alphabetCount = SECURE_RANDOM.nextInt(length - numberCount);
		alphabetCount = alphabetCount == 0 ? 1 : alphabetCount;
		String alphabetString = ALPHABETIC_RANDOM_STRING_GENERATOR.generate(alphabetCount);

		int specialCodeCount = length - numberCount - alphabetCount;
		String specialCodeString = SPECIAL_CODE_RANDOM_STRING_GENERATOR.generate(specialCodeCount);

		String password = numberString + alphabetString + specialCodeString;

		String randomPrint = RandomStringUtils.randomPrint(length);
		logger.info(randomPrint);
		return password;
	}

	/**
	 * 使用 org.apache.commons.lang3.RandomStringUtils 直接生成，可打印的随机字符串
	 * @return
	 */
	public static String generateRandomPrintStringPassword() {
		return RandomStringUtils.randomPrint(DEFAULT_PASSWORD_LENGTH);
	}

}
