package com.binvi.springboot.demo03.book.howtomcatworks.chapter1;

import com.binvi.springboot.demo03.book.howtomcatworks.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * @author binvi
 * @version 1.0
 * @Description: 自定义Response
 * @date 2019/9/24 22:14
 */
public class Response implements ServletResponse {

	private static final Logger logger = LoggerFactory.getLogger(Response.class);

	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;
	PrintWriter writer;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void sendStaticResource() throws IOException {
		logger.info("Response sendStaticResource start");
		byte[] buffer = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(Constant.WEB_ROOT, request.getUri());
			if (file.exists()) {
				fis = new FileInputStream(file);
				while (fis.read(buffer, 0, BUFFER_SIZE) != -1) {
					output.write(buffer, 0, BUFFER_SIZE);
				}
			} else {
				String errorMsg = "HTTP/1.1 404 File Not Found\r\n" +
						"Content-Type: text/html\r\n" +
						"Content-Length: 23\r\n" +
						"\r\n" +
						"<h1>File Not Found</h1>";
				output.write(errorMsg.getBytes());
			}
		} catch (Exception e) {
			logger.error("send static resource exception", e);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public OutputStream getOutput() {
		return output;
	}

	public void setOutput(OutputStream output) {
		this.output = output;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		writer = new PrintWriter(output, true);
		return writer;
	}

	@Override
	public void setCharacterEncoding(String charset) {

	}

	@Override
	public void setContentLength(int len) {

	}

	@Override
	public void setContentLengthLong(long len) {

	}

	@Override
	public void setContentType(String type) {

	}

	@Override
	public void setBufferSize(int size) {

	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException {

	}

	@Override
	public void resetBuffer() {

	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public void reset() {

	}

	@Override
	public void setLocale(Locale loc) {

	}

	@Override
	public Locale getLocale() {
		return null;
	}
}
