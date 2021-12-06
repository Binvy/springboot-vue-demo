package com.binvi.springboot.demo03.tutorial.netty.example.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/10/17 16:44
 */
public class EchoClient {

	static final boolean SSL = System.getProperty("ssl") != null;
	static final String HOST = System.getProperty("host", "127.0.0.1");
	static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
	static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

	public static void main(String[] args) throws Exception {
		final SslContext sslContext;
		if (SSL) {
			sslContext = SslContextBuilder.forClient()
					.trustManager(InsecureTrustManagerFactory.INSTANCE).build();
		} else {
			sslContext = null;
		}

		NioEventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline p = ch.pipeline();
							if (sslContext != null) {
								p.addLast(sslContext.newHandler(ch.alloc(), HOST, PORT));
							}
							p.addLast(new EchoClientHandler());
						}
					});
			ChannelFuture f = b.connect(HOST, PORT).sync();
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully();
		}
	}

}
