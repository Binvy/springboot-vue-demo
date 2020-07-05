package com.binvi.springboot.demo03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description: Spring Batch批处理控制类
 * @date 2019/7/3 19:48
 */
@RestController
@RequestMapping("csv")
public class CsvController {

	private static final Logger logger = LoggerFactory.getLogger(CsvController.class);

	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;

	@GetMapping("/init")
	public String init() {
		logger.info("csv controller init start.");
		String result;
		try {
			jobLauncher.run(job, new JobParameters());
			result = "success";
			logger.info("csv controller init complete.");
		} catch (Exception e) {
			result = e.getMessage();
			logger.error("csv controller init exception.", e);
			e.printStackTrace();
		}
		return result;
	}

}
