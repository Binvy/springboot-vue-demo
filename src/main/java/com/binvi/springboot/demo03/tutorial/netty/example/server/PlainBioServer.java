package com.binvi.springboot.demo03.tutorial.netty.example.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author binvi
 * @version 1.0
 * @Description: accept client connection with blocking io
 * @date 2020/10/28 20:50
 */
public class PlainBioServer {

	public static void main(String[] args) throws IOException {
		new PlainBioServer().server(8080);
	}

	public void server(int port) throws IOException {
		final ServerSocket serverSocket = new ServerSocket(port);
		try {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Accepted connection from " + clientSocket);
				new Thread(()->{
					OutputStream out;
					try {
						out = clientSocket.getOutputStream();
						out.write("Hi!\r\n".getBytes(Charset.forName("utf-8")));
						out.flush();
						clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
						try {
							clientSocket.close();
						} catch (Exception ex) {
							// ignore on close
						}
					}
				}).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
