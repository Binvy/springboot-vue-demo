package com.binvi.springboot.demo03.tutorial.netty.example.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author binvi
 * @version 1.0
 * @Description: Handler implementation for the echo server.
 * @date 2020/10/17 15:11
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
