package com.theotherian.chat;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Set up Spring boot and launch the application
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}