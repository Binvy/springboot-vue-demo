package com.binvi.springboot.demo03.book.howtomcatworks.chapter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/26 22:48
 */
public class StaticResourceProcessor {

	private static final Logger logger = LoggerFactory.getLogger(StaticResourceProcessor.class);

	public void process(HttpRequest request, HttpResponse response) {
		logger.info("StaticResourceProcessor process start. request:{}, response:{}", request, response);
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
