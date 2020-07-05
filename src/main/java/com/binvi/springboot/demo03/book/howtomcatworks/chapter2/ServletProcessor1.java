package com.binvi.springboot.demo03.book.howtomcatworks.chapter2;

import com.binvi.springboot.demo03.book.howtomcatworks.chapter1.Request;
import com.binvi.springboot.demo03.book.howtomcatworks.chapter1.Response;
import com.binvi.springboot.demo03.book.howtomcatworks.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/25 22:36
 */
public class ServletProcessor1 {

	private static final Logger logger = LoggerFactory.getLogger(ServletProcessor1.class);

	public void process(Request request, Response response) {
		logger.info("ServletProcessor1 process start. request:{}, response:{}", request, response);
		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		URLClassLoader urlClassLoader = null;
		try {
			URL[] urls = new URL[1];
			URLStreamHandler urlStreamHandler = null;
			File classpath = new File(Constant.TARGET);
			String repository = (new URL("file", null, classpath.getCanonicalPath() + File.separator)).toString();
			urls[0] = new URL(null, repository, urlStreamHandler);
			urlClassLoader = new URLClassLoader(urls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Class servletClass = null;
		try {
			servletClass = urlClassLoader.loadClass(servletName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Servlet servlet = null;
		try {
			servlet = (Servlet) servletClass.newInstance();
			servlet.service(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
