package com.theotherian.chat;

import javax.inject.Inject;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ActiveUserController {
  
  private SimpMessagingTemplate template;

  @Inject
  public ActiveUserController(SimpMessagingTemplate template) {
    this.template = template;
  }
  
  @MessageMapping("/activeUsers")
  public void activeUsers() {
    System.out.println("hit");
    template.convertAndSend("/topic/active", new Greeting("wow", "such active"));
  }

}
