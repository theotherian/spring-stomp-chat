package com.theotherian.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ActiveUserPinger {

  @Autowired
  private SimpMessagingTemplate template;

  @Autowired
  private ActiveUserService activeUserService;
  
  @Scheduled(fixedDelay = 2000)
  public void pingUsers() {
    Set<String> activeUsers = activeUserService.getActiveUsers();
    template.convertAndSend("/topic/active", activeUsers);
  }

}
