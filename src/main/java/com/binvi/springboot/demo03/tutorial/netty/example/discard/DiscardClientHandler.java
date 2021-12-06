package com.binvi.springboot.demo03.tutorial.netty.example.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @author binvi
 * @version 1.0
 * @Description: Handlers a client-side channel.
 * @date 2020/10/17 16:01
 */
public class DiscardClientHandler extends SimpleChannelInboundHandler<Object> {

	private ByteBuf content;
	private ChannelHandlerContext ctx;

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		this.ctx = ctx;
		content = ctx.alloc().directBuffer(DiscardClient.SIZE).writeZero(DiscardClient.SIZE);
		generateTraffic();
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) {
		content.release();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
		// Server is supposed to send nothing, but if it sends something, discard it.
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	long counter;

	private void generateTraffic() {
		// Flush the outbound buffer to the socket.
		// Once flushed, generate the same amount of traffic again.
		ctx.writeAndFlush(content.retainedDuplicate()).addListener(trafficGenerator);
	}

	private final GenericFutureListener trafficGenerator = (ChannelFutureListener) future -> {
		if (future.isSuccess()) {
			generateTraffic();
		} else {
			future.cause().printStackTrace();
			future.channel().close();
		}
	};

}
