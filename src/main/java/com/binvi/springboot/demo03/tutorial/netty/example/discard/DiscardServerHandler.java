package com.binvi.springboot.demo03.tutorial.netty.example.discard;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author binvi
 * @version 1.0
 * @Description: Handlers a server-side channel.
 * @date 2020/10/17 14:06
 */
public class DiscardServerHandler extends SimpleChannelInboundHandler<Object> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscardServerHandler.class);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		// discard
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// Close the connection when an exception is raised
		LOGGER.error("exception caught", cause);
		ctx.close();
	}

}
