package com.binvi.springboot.demo03.book.howtomcatworks.chapter1;

import com.mchange.v1.io.OutputStreamUtils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author binvi
 * @version 1.0
 * @Description: 与本地HTTP服务器进行通信的套接字
 * @date 2019/9/24 21:11
 */
public class SocketTest {

	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1", 8080);
			 OutputStream out = socket.getOutputStream();
			 InputStream in = socket.getInputStream())
		{
			PrintWriter writer = new PrintWriter(out, true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			writer.println("GET /index.jsp HTTP/1.1");
			writer.println("Host: localhost:8080");
			writer.println("Connection: close");
			writer.println();

			boolean loop = true;
			StringBuffer sb = new StringBuffer(1024 * 8);
			while (loop) {
				if (reader.ready()) {
					int i;
					while ((i = reader.read()) != -1) {
						sb.append((char)i);
					}
					loop = false;
				}
				Thread.currentThread().sleep(60);
			}

			System.out.println(sb.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
