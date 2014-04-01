package com.theotherian.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.*;

/**
 * An extremely basic auth setup for the sake of a demo project
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("ian").password("ian").roles("USER");
    auth.inMemoryAuthentication().withUser("dan").password("dan").roles("USER");
    auth.inMemoryAuthentication().withUser("chris").password("chris").roles("USER");
  }
}