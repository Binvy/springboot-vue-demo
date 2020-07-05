package com.binvi.springboot.demo03.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author binvi
 * @version 1.0
 * @Description: Spring自带的定时任务
 * @date 2019/7/2 22:56
 */
@Component
public class MySchedule {

	private static final Logger logger = LoggerFactory.getLogger(MySchedule.class);

	@Scheduled(fixedDelay = 10000)
	public void fixedDelay() {
		logger.info("MySchedule fixedDelay run at {}", Instant.now());
	}

	@Scheduled(fixedRate = 20000)
	public void fixedRate() {
		logger.info("MySchedule fixedRate run at {}", Instant.now());
	}

	@Scheduled(initialDelay = 10000, fixedRate = 20000)
	public void initialDelay() {
		logger.info("MySchedule initialDelay run at {}", Instant.now());
	}

	@Scheduled(cron = "*/30 * * * * *")
	public void cron() {
		logger.info("MySchedule cron run at {}", Instant.now());
	}

}
