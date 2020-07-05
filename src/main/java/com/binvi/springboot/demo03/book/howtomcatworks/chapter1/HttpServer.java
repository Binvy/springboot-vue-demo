package com.binvi.springboot.demo03.book.howtomcatworks.chapter1;

import com.binvi.springboot.demo03.book.howtomcatworks.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/24 21:58
 */
public class HttpServer {

	private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);

	private boolean shutdown = false;

	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}

	private void await() {
		logger.info("HttpServer await start");
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		// Loop waiting for a request
		while (!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;
			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();

				// Create Request object and parse
				Request request = new Request(input);
				request.parse();

				// Create Response object
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();

				// Close the socket
				socket.close();

				// Check if the request URI is a shutdown command
				shutdown = request.getUri().equals(Constant.SHUTDOWN_COMMAND);

			} catch (Exception e) {
				logger.error("await exception", e);
				continue;
			}
		}
	}

}
