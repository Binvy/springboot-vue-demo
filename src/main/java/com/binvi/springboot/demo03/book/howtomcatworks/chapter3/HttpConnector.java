package com.binvi.springboot.demo03.book.howtomcatworks.chapter3;

import com.binvi.springboot.demo03.book.howtomcatworks.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/26 22:15
 */
public class HttpConnector implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(HttpConnector.class);

	boolean stopped;
	private String scheme = "http";

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName(Constant.LOCAL_HOST));
		} catch (IOException e) {
			logger.error("create serverSocket exception", e);
			System.exit(1);
		}
		while (!stopped) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				logger.error("create socket exception", e);
				continue;
			}

		}
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

}
