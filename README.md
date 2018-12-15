## KieaTomcat
Apache Tomcat projects

### development order on maven
```
1. pom.xml
2. resources
	log4j.properties
3. domain
	dao
	service
	controller / web
4. web.xml
	spring
	jsp
```

### MongoDB
```
DOS> mkdir C:\data\db
DOS> mongod.exe      <--- run mongoDB server
DOS> mongo.exe
	> show dbs
```

### Neo4j
```
$ neo4j start
...
$ neo4j stop

```

### h2 [www.h2database.com](www.h2database.com)
```
DOS> echo %H2_HOME%
	C:\...\H2
DOS> PATH=%H2_HOME%\bin;%PATH%
DOS> h2w.bat
	> http://local:8082/
```

Wrapper
------
```
	--------------------- Gradle --------------------
	$ gradle wrapper                         <--- very important
	$ tree /f gradle
		....../gradle
		└─wrapper
		        gradle-wrapper.jar
		        gradle-wrapper.properties
		        	
	
	$ ./gradlew clean build
	$ java -jar build/libs/XXXXX.jar
	
	--------------------- Maven --------------------
	$ mvn -N io.takari:maven:wrapper         <--- very important
	$ tree /f .mvn
		....../.mvn
		└─wrapper
		        maven-wrapper.jar
		        maven-wrapper.properties
		        MavenWrapperDownloader.java

	$ ./mvnw clean package
	$ java -jar target/XXXXX.jar
	
	
	$ gradle wrapper --gradle-version=4.10-rc-2        <---
	
```

--------------------------------------
### References

- [Apache Tomcat](http://tomcat.apache.org/ "Apache Tomcat")
- [WIX](http://www.wix.com/ "WIX")
- [Ubuntu 한 서버에서 PHP, JSP 동시에 사용하기](https://blog.lael.be/post/1023 "Ubuntu 한 서버에서 PHP, JSP 동시에 사용하기"): Ubuntu 한 서버에서 PHP, JSP 동시에 사용하기. 포트 바인딩. 프록시(Proxy) 및 리버스 프록시(Reverse Proxy). apache2(80, PHP) + tomcat7(8080, JSP)
- [한번에 끝내는 Ubuntu JSP서버세팅](https://blog.lael.be/post/858 "한번에 끝내는 Ubuntu JSP서버세팅"):
- [Apache & Apache Tomcat을 연동하여 php, jsp사용하기](http://knkky.tistory.com/35 "Apache & Apache Tomcat을 연동하여 php, jsp사용하기"): 이 사이트 아래의 목록으로 추가정보를 취하세요.
- [[Web Server] 아파치( 2.0.64 )와 톰캣( 8.0.52 ) 연동](http://victorydntmd.tistory.com/225 "[Web Server] 아파치( 2.0.64 )와 톰캣( 8.0.52 ) 연동"):
-
- [What is Thumbnailator?](https://github.com/coobird/thumbnailator "Thumbnailator"): Thumbnail 모듈
- [Thumbnailator on mvnrepository](https://mvnrepository.com/artifact/net.coobird/thumbnailator/0.4.8 "Thumbnailator"): Thumbnail Declaration
- [Thumbnailator – Thumbnail Generation Java Library](http://www.tellmehow.co/thumbnailator-thumbnail-generation-java-library/ "Thumbnailator – Thumbnail Generation Java Library"):
- [Java Code Examples for net.coobird.thumbnailator.Thumbnails](https://www.programcreek.com/java-api-examples/?api=net.coobird.thumbnailator.Thumbnails "Java Code Examples for net.coobird.thumbnailator.Thumbnails"):
- [Examples of Thumbnail on java](https://github.com/coobird/thumbnailator/wiki/Examples "Examples"):
- [Java thumbnailator를 이용하여 썸네일 만들기 sample](http://devlinker.tistory.com/18 "Java thumbnailator를 이용하여 썸네일 만들기 sample"):
- [http://projects.coobird.net/past-thumbnailator/howto.html](http://projects.coobird.net/past-thumbnailator/howto.html ""):
- [https://jar-download.com/artifacts/net.coobird/thumbnailator/0.4.7/source-code](https://jar-download.com/artifacts/net.coobird/thumbnailator/0.4.7/source-code ""):
-
- [tomcat 7: automatically redirect https requests to port 8443](https://stackoverflow.com/questions/24736543/tomcat-7-automatically-redirect-https-requests-to-port-8443 ""):
- [Redirecting from non ssl port 8080 to ssl port 8443](https://stackoverflow.com/questions/9526425/redirecting-from-non-ssl-port-8080-to-ssl-port-8443 ""):
- [Tomcat http접속을 https로 리다이렉트 시키기](http://hwangji.kr/sub/dev_leader/link/os/default.aspx?NHBBSID=NHBoardWebTip&NHBBSIDX=81 ""):
- [SSL 설정법](https://tadpoledbhub.atlassian.net/wiki/spaces/TADPOLE/pages/18382851/SSL ""):
- [Tomcat HTTPS 설정하기](https://joshua1988.github.io/web-development/pwa/tomcat-https-setup/ ""): vue.js 를 찾아보아라...^^
-
- (spring-security)
- [초보자가 이해하는 Spring Security - 퍼옴](http://postitforhooney.tistory.com/entry/SpringSecurity-%EC%B4%88%EB%B3%B4%EC%9E%90%EA%B0%80-%EC%9D%B4%ED%95%B4%ED%95%98%EB%8A%94-Spring-Security-%ED%8D%BC%EC%98%B4 ""):
- [스프링 시큐리티 기초 따라가기 (1) - 환경설정 및 기본 로그인 시스템](http://hamait.tistory.com/325 ""):
- [Spring Security Example UserDetailsService](https://www.journaldev.com/2736/spring-security-example-userdetailsservice ""):
- [12회차_Spring Security 로그인 방법(데이터베이스 연동)](https://m.blog.naver.com/PostView.nhn?blogId=sam_sist&logNo=220964537132&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F ""):
- [01. 스프링 시큐리티(spring-security) 연동(유저, 유저권한)](http://ryudung.tistory.com/19?category=657567 ""):
- [스프링프레임웍 - Spring Security(1) : 기본 설정](https://offbyone.tistory.com/88 "스프링프레임웍 - Spring Security(1) : 기본 설정"): 하단 링크 확인
- [github.com spring-projects/spring-security-javaconfig](https://github.com/spring-projects/spring-security-javaconfig/blob/master/quickstart.md "spring-projects/spring-security-javaconfig"):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- [토렌트 사이트 추천 순위 TOP 18+](https://makemoneyskills.com/torrent-site-recommend/ "토렌트 사이트 추천 순위 TOP 18+"):
- [토렌트 설치와 사용법 그리고 토렌트 파일로 자료 다운로드 받기](https://m.blog.naver.com/PostView.nhn?blogId=e_maill&logNo=220310900415&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F ""):

.....
