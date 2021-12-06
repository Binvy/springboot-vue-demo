package com.binvi.springboot.demo03.common;

import com.binvi.springboot.demo03.util.RandomPasswordGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2021/6/6 19:17
 */
public class RandomPasswordTest {

	private static final Logger logger = LoggerFactory.getLogger(RandomPasswordTest.class);

	@Test
	public void testGenerateRandomPassword() {
		String randomPassword = RandomPasswordGenerator.generateRandomPassword();
		logger.info("randomPassword: {}", randomPassword);
		String generateRandomPrintPassword = RandomPasswordGenerator.generateRandomPrintStringPassword();
		logger.info("generateRandomPrintPassword: {}", generateRandomPrintPassword);
	}

}
