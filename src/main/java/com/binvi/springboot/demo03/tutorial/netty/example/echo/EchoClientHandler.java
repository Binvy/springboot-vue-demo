package com.binvi.springboot.demo03.tutorial.netty.example.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author binvi
 * @version 1.0
 * @Description: Handler implementation for the echo client. It initiates the ping-pong
 *               traffic between the echo client and server by sending the first message to
 *               the server
 * @date 2020/10/17 15:11
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

	private final ByteBuf firstMessage;

	public EchoClientHandler() {
		firstMessage = Unpooled.buffer(EchoClient.SIZE);
		for (int i = 0; i < firstMessage.capacity(); i++) {
			firstMessage.writeByte((byte) i);
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(firstMessage);
	}

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
