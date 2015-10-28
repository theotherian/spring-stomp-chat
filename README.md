spring-stomp-chat
=================

This is the sourcecode for the [theotherian's blog article](http://www.theotherian.com/2014/03/spring-boot-websockets-stomp-chat.html). 

See also [the documentation of stomp in spring](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/websocket.html#websocket-stomp-overview). 

```sh
mvn package
java -jar ./target/spring-stomp-chat-trunk-SNAPSHOT.jar
```

The accounts available are: 

```java
    auth.inMemoryAuthentication().withUser("ian").password("ian").roles("USER");
    auth.inMemoryAuthentication().withUser("dan").password("dan").roles("USER");
    auth.inMemoryAuthentication().withUser("chris").password("chris").roles("USER");
```

Please note you need to users to login and one of them to select the other to open the chat window. 

