package com.binvi.springboot.demo03.book.howtomcatworks.chapter3;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/9/26 22:21
 */
public class HttpProcessor {

	public HttpProcessor(HttpConnector connector) {
		this.connector = connector;
	}
	/**
	 * The HttpConnector with which this processor is associated.
	 */
	private HttpConnector connector = null;
	private HttpRequest request;
	//private HttpRequestLine requestLine = new HttpRequestLine();
	private HttpResponse response;

	protected String method = null;
	protected String queryString = null;

	/**
	 * The string manager for this package.
	 */
	//protected StringManager sm = StringManager.getManager("ex03.pyrmont.connector.http");

	public void process(Socket socket) {
		SocketInputStream input = null;
		OutputStream output = null;
		try {
			input = new SocketInputStream(socket.getInputStream(), 2048);
			output = socket.getOutputStream();

			// create HttpRequest object and parse
			request = new HttpRequest(input);

			// create HttpResponse object
			response = new HttpResponse(output);
			response.setRequest(request);

			response.setHeader("Server", "Pyrmont Servlet Container");

			//parseRequest(input, output);
			//parseHeaders(input);

			//check if this is a request for a servlet or a static resource
			//a request for a servlet begins with "/servlet/"
			if (request.getRequestURI().startsWith("/servlet/")) {
				ServletProcessor processor = new ServletProcessor();
				processor.process(request, response);
			}
			else {
				StaticResourceProcessor processor = new StaticResourceProcessor();
				processor.process(request, response);
			}

			// Close the socket
			socket.close();
			// no shutdown for this application
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
