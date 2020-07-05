package com.binvi.springboot.demo03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: websocket配置
 * @date 2019/6/23 13:58
 */
@Configuration
@EnableWebSocketMessageBroker //开启websocket消息代理
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*
         * 定义一个前缀为'/chat'的终端，并开启sockjs支持。（sockjs可以解决浏览器对WebSocket的兼容性问题，）
         * 客户端将通过这里配置的URL来建立WebSocket连接。（let socket = new SockJS('/chat');）
         */
        registry.addEndpoint("/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置消息代理的前缀：如果消息前缀是"/topic"，就会将消息转发给消息代理broker，再由消息代理将消息广播给当前连接的客户端
        registry.enableSimpleBroker("/topic");
        // 配置一个或多个前缀，通过这些前缀过滤出需要被注解方法处理的消息。例如：前缀为"/app"的destination可以通过@MessageMapping注解
        // 的方法处理，而其他destination(例如"/topic"，"/queue")将直接交给代理broker处理。
        registry.setApplicationDestinationPrefixes("/app");
    }
}
