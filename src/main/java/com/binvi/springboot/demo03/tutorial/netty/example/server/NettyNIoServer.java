package com.binvi.springboot.demo03.tutorial.netty.example.server;

import java.nio.charset.Charset;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author binvi
 * @version 1.0
 * @Description: accept client connection with netty non blocking io
 * @date 2020/10/28 21:53
 */
public class NettyNIoServer {

	public static void main(String[] args) throws Exception {
		new NettyNIoServer().server(8080);
	}

	public void server(int port) throws Exception {
		ByteBuf byteBuf = Unpooled.unreleasableBuffer(
				Unpooled.copiedBuffer("Hi!\r\n".getBytes(Charset.forName("utf-8"))));
		NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline p = ch.pipeline();
							p.addLast(new ChannelInboundHandlerAdapter() {
								@Override
								public void channelActive(ChannelHandlerContext ctx) throws Exception {
									ctx.writeAndFlush(byteBuf.duplicate())
											.addListener(ChannelFutureListener.CLOSE);
								}
							});
						}
					})
					.option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

}
