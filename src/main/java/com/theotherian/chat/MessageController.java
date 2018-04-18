package com.theotherian.chat;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
  
  private SimpMessagingTemplate template;
  
  @Inject
  public MessageController(SimpMessagingTemplate template) {
    this.template = template;
  }

  @MessageMapping("/chat")
  public void greeting(Principal principal, @Payload ChatMessage chatMessage) throws Exception {
	String authedSender = principal.getName();
    chatMessage.setSender(authedSender);
    String recipient = chatMessage.getRecipient();
    if (!authedSender.equals(recipient)) {
      template.convertAndSendToUser(authedSender, "/queue/messages", chatMessage);
    }
    
    template.convertAndSendToUser(recipient, "/queue/messages", chatMessage);
  }

}