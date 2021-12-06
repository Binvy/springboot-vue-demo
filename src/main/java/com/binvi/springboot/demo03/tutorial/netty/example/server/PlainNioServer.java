package com.binvi.springboot.demo03.tutorial.netty.example.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author binvi
 * @version 1.0
 * @Description: accept client connection with non blocking io
 * @date 2020/10/28 20:59
 */
public class PlainNioServer {

	public static void main(String[] args) throws IOException {
		new PlainNioServer().server(8080);
	}

	public void server(int port) throws IOException {
		System.out.println("Listening for connections on port " + port);
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverSocketChannel.socket();
		InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
		serverSocket.bind(inetSocketAddress);
		serverSocketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes(Charset.forName("utf-8")));

		while (true) {
			try {
				selector.select();
			} catch (IOException e) {
				e.printStackTrace();
				// handler in a proper way
				break;
			}

			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				try {
					if (selectionKey.isAcceptable()) {
						ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
						SocketChannel clientChannel = serverChannel.accept();
						System.out.println("Accepted connection from " + clientChannel);
						clientChannel.configureBlocking(false);
						clientChannel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
					}
					if (selectionKey.isWritable()) {
						SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
						ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
						while (byteBuffer.hasRemaining()) {
							if (socketChannel.write(byteBuffer) == 0) {
								break;
							}
						}
						socketChannel.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
					selectionKey.cancel();
					try {
						selectionKey.channel().close();
					} catch (IOException ex) {
						// ignore on close
					}
				}
			}
		}
	}

}
