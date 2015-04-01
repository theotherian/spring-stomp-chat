spring-stomp-chat
=================

Related to http://www.theotherian.com/2014/03/spring-boot-websockets-stomp-chat.html

# Heroku Setup Info

Procfile
```
web: java $JAVA_OPTS -Dserver.port=$PORT -jar target/spring-stomp-chat-1.1.0.jar
```
Postgres is available by default with Java apps.

A one time config change was made to enable the Spring config activation:

```
heroku config:set JAVA_OPTS='-Xmx384m -Xss512k -XX:+UseCompressedOops -Dspring.profiles.active=heroku'
```
# Getting started
After cloning this repo:
```
git remote add heroku git@heroku.com:spring-stomp-chat.git
```
You can now deploy to heroku if you have permissions.  Make sure to download the heroku Toolbelt on your system.

# Deployment Stuff

The app will run on your localhost using the local mongodb instance, but when deployed to Heroku, the "heroku" profile kicks in. 

To re-deploy fresh code, stop the proc, push and start it:

```
heroku ps:scale web=0
git push heroku master
heroku ps:scale web=1
```
#Usage

* http://spring-stomp-chat.herokuapp.com/ - to see this implementation
 