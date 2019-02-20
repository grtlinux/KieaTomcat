Spring-Boot-Field-Info-Server
=============================

- Information
```
	Field Info Server port : 8081
	/fieldInfo/list
	/fieldInfo/info  {infoKey: MastInfo}
```

- Data Rest

```
	$ curl http://localhost/home/index.html                       다운로드 받은 파일을 콘솔로 출력
	$ curl -o http://localhost/home/index.html                                       저장파일 index.html
	$ curl -o imsi.html http://localhost/home/index.html                             저장파일 imsi.html
	$ curl -o http://localhost/home/index.html  -o http://localhost/home/hello.html  멀티 저장 
	$ curl -o http://localhost/home/index.html
	
	$ curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8081/fieldInfo/info
```

References
----------
- [curl 설치 및 사용법 - HTTP GET/POST, REST API 연계등](https://www.lesstif.com/pages/viewpage.action?pageId=14745703 ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):



.....
