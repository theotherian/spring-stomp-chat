package com.theotherian.chat;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * Override the scheduling configuration so that we can schedule our own scheduled bean and
 * so that Spring's STOMP scheduling can continue to work
 */
@Configuration
@EnableScheduling
public class ChatSchedulingConfigurer implements SchedulingConfigurer {

  @Bean
  public ThreadPoolTaskScheduler taskScheduler() {
     return new ThreadPoolTaskScheduler();
  }
  
  @Bean
  @Inject
  public ActiveUserPinger activeUserPinger(SimpMessagingTemplate template, ActiveUserService activeUserService) {
    return new ActiveUserPinger(template, activeUserService);
  }

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setTaskScheduler(taskScheduler());
  }
}