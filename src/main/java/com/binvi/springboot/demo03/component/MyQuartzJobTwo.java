package com.binvi.springboot.demo03.component;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.Instant;

/**
 * @author binvi
 * @version 1.0
 * @Description: Quartz定时（继承式）
 * @date 2019/7/2 23:11
 */
public class MyQuartzJobTwo extends QuartzJobBean {

	private static final Logger logger = LoggerFactory.getLogger(MyQuartzJobTwo.class);

	private String name;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("MyQuartzJobTwo start at {}", Instant.now());
		logger.info("hello {}, Good night!", name);
		logger.info("=======================================");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
