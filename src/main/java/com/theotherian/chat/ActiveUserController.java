package com.theotherian.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ActiveUserController {
  
  @MessageMapping("/activeUsers")
  public void activeUsers() {
    System.out.println("hit");
  }

}
