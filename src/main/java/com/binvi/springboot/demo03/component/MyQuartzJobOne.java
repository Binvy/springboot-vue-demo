package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author binvi
 * @version 1.0
 * @Description: Quartz定时（注解式）
 * @date 2019/7/2 23:08
 */
@Component
public class MyQuartzJobOne {

	private static final Logger logger = LoggerFactory.getLogger(MyQuartzJobOne.class);

	public void sayHello() {
		logger.info("MyQuartzJobOne start at {}", Instant.now());
		logger.info("---------------------------------------");
	}

}
