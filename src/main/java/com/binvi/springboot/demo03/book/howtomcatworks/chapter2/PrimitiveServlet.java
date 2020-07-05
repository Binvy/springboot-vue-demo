package com.binvi.springboot.demo03.book.howtomcatworks.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/25 22:23
 */
public class PrimitiveServlet implements Servlet {

	private static final Logger logger = LoggerFactory.getLogger(PrimitiveServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.info("servlet init. config:{}", config);
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		logger.info("servlet service. request:{}, response:{}", req, res);
		PrintWriter writer = res.getWriter();
		writer.println("hello, roses are red");
		writer.print("violets are blue");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		logger.info("servlet destroy.");
	}
}
