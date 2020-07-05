package com.binvi.springboot.demo03.book.howtomcatworks.chapter2;

import com.binvi.springboot.demo03.book.howtomcatworks.chapter1.Request;
import com.binvi.springboot.demo03.book.howtomcatworks.chapter1.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author binvi
 * @version 1.0
 * @Description: 静态资源处理类
 * @date 2019/9/25 22:35
 */
public class StaticResourceProcessor1 {

	private static final Logger logger = LoggerFactory.getLogger(StaticResourceProcessor1.class);

	public void process(Request request, Response response) {
		logger.info("StaticResourceProcessor1 process start. request:{}, response:{}", request, response);
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
