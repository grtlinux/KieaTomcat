kang04
======

- resources file application.yml or application-{profile}.yml
```
	$ java -jar XXXXX.jar
	$ java -jar -Dspring.profiles.active=dev XXXXX.jar
	$ cat application.yml
		server:
		  port: 8000
		
		---
		# local
		spring:
		  profiles: local
		server:
		  port: 8001
		  
		---
		# dev
		spring:
		  profiles: dev
		server:
		  port: 8002
		  
		---
		# real
		spring:
		  profiles: real
		server:
		  port: 8003
		  
		---
```

- resources file application.properties
```
	server.port: 8888
```

- debug options -Dxxx.xxx.xxx=yyyyy
```
	$ java -jar -Dserver.port=8080 XXXXX.jar
```


References
----------
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):

.....
