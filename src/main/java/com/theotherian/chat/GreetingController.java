package com.theotherian.chat;

import javax.inject.Inject;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
  
  @Inject private SimpMessagingTemplate template;

  @MessageMapping("/hello")
  public void greeting(HelloMessage message) throws Exception {
    template.convertAndSendToUser("ian", "/queue/greetings", new Greeting("ian", "Hello, " + message.getName() + "!"));
  }

}