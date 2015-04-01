spring-stomp-chat
=================

Related to http://www.theotherian.com/2014/03/spring-boot-websockets-stomp-chat.html

# Running Locally
```
mvn package
java -jar target/spring-stomp-chat-1.1.0.jar
```
## Usage

* http://localhost:8080
* login as ian/ian or dan/dan or chris/chris from different browsers!


# Heroku Setup Info

Procfile
```
web: java $JAVA_OPTS -Dserver.port=$PORT -jar target/spring-stomp-chat-1.1.0.jar
```

## Getting started
After cloning this repo:
```
git remote add heroku git@heroku.com:spring-stomp-chat.git
```
You can now deploy to heroku if you have permissions.  Make sure to download the heroku Toolbelt on your system.

## Deployment Stuff

To re-deploy fresh code, stop the proc, push and start it:

```
heroku ps:scale web=0
git push heroku master
heroku ps:scale web=1
```
## Usage

* http://spring-stomp-chat.herokuapp.com/ - to see this implementation
* login as ian/ian or dan/dan or chris/chris from different browsers!
 