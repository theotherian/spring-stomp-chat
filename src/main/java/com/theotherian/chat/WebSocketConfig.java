package com.theotherian.chat;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Set up our websocket configuration, which uses STOMP, and configure our endpoints
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/queue", "/topic");
    config.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat", "/activeUsers").withSockJS();
  }

  @Override
  public void configureClientInboundChannel(ChannelRegistration channelRegistration) {
  }

  @Override
  public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {
  }

  @Override
  public boolean configureMessageConverters(List<MessageConverter> converters) {
    return true;
  }
  
  @Bean
  public ActiveUserService activeUserService() {
    return new ActiveUserService();
  }

}