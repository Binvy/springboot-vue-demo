package com.binvi.springboot.demo03.guava;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description: Guava布隆过滤器使用
 * @date 2021/6/6 16:26
 */
public class BloomFilterTest {

	private static final Logger logger = LoggerFactory.getLogger(BloomFilterTest.class);

	private static final SecureRandom SECURE_RANDOM = new SecureRandom();

	/** 预期保存的元素数量 */
	private static final int EXPECTED_INSERTIONS = 100;
	/** 误判率 */
	private static final double FPP = 0.01;
	/** 随机字符串的长度 */
	private static final int STRING_LENGTH = 10;

	/**
	 * Integer类型的布隆过滤器
	 */
	@Test
	public void testIntegerBloom() {
		BloomFilter<Integer> integerBloomFilter = BloomFilter.create(Funnels.integerFunnel(), EXPECTED_INSERTIONS, FPP);

		System.out.println("----------------- before add element -----------------");
		for (int i = 0; i < EXPECTED_INSERTIONS; i++) {
			System.out.printf(integerBloomFilter.mightContain(i) ? "可能包含%d\n" : "不包含%d\n", i);
		}

		for (int i = 0; i < EXPECTED_INSERTIONS; i += 5) {
			integerBloomFilter.put(i);
		}

		System.out.println("----------------- after add element -----------------");
		for (int i = 0; i < EXPECTED_INSERTIONS; i++) {
			System.out.printf(integerBloomFilter.mightContain(i) ? "可能包含%d\n" : "不包含%d\n", i);
		}

		System.out.println("----------------- use random element -----------------");
		SECURE_RANDOM.ints(100, 0, 100)
				.forEach(s -> {
					System.out.printf(integerBloomFilter.mightContain(s) ? "可能包含%d\n" : "不包含%d\n", s);
				});
	}

	/**
	 * String类型的布隆过滤器
	 */
	@Test
	public void testStringBloom() {
		logger.info("test string bloom filter start");
		BloomFilter<CharSequence> bloomFilter = BloomFilter.create(
				Funnels.stringFunnel(Charset.defaultCharset()), EXPECTED_INSERTIONS, FPP);

		logger.info("----------------- before add element -----------------");
		ArrayList<String> generatedStringList = new ArrayList<>(EXPECTED_INSERTIONS);
		for (int i = 0; i < EXPECTED_INSERTIONS; i++) {
			String str = RandomStringUtils.randomPrint(STRING_LENGTH);
			generatedStringList.add(str);
			logger.info("{} : 可能包含[{}] : {}", i, str, bloomFilter.mightContain(str) ? "可能" : "不可能");
		}

		for (int i = 0; i < generatedStringList.size(); i += 5) {
			bloomFilter.put(generatedStringList.get(i));
		}

		logger.info("----------------- after add element -----------------");
		for (int i = 0; i < generatedStringList.size(); i++) {
			String str = generatedStringList.get(i);
			logger.info("{} : 可能包含[{}] : {}", i, str, bloomFilter.mightContain(str) ? "可能" : "不可能");
		}

		logger.info("----------------- use random element -----------------");
		for (int i = 0; i < EXPECTED_INSERTIONS; i++) {
			String str = RandomStringUtils.randomPrint(STRING_LENGTH);
			logger.info("{} : 可能包含[{}] : {}", i, str, bloomFilter.mightContain(str) ? "可能" : "不可能");
		}
	}

}
