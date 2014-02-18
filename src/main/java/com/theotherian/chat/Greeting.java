package com.theotherian.chat;

public class Greeting {
  
  private String userName;

  private String content;

  public Greeting(String userName, String content) {
    this.content = content;
    this.userName = userName;
  }

  public String getContent() { return content; }
  
  public String getUserName() { return userName; }

}