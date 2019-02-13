Spring-Boot-Community-Rest-Web-Mvc
==================================

```
	DOS> curl -v http://localhost:8081/api/boards
	
	DOS> curl -v "http://localhost:8081/api/boards?page=0&size=20"
	
	DOS> curl -i -X GET -H 'Content-Type: application/json' http://localhost:8081/api/boards
		<< OK >>
	DOS> curl -i -X PUT -H 'Content-Type: application/json' -d '{"title": "타이틀입니다."}' http://localhost:8081/api/boards/1
		<< ERROR >>

curl -i -X POST -H 'Content-Type: application/json' -d '{ "projectinfo_uid": "8764c510-57b7-44c3-bddf-266d86c26380-0000c160", "versionguid": "f498e8b1-7311-4409-a669-2fd290356bb4", "numberofsaves": 271, "title": "rac_basic_sample_project.rvt", "centralserverpath": "", "path": "C:/Program Files/Autodesk/Revit 2016/Samples/rac_basic_sample_project.rvt", "computername": "JEREMYTAMMIB1D2"}' http://localhost:3001/api/v1/projects

curl -i -X DELETE http://localhost:3001/api/v1/projects/559a328d8e67197a1c00d6dd

curl -i -X PUT -H 'Content-Type: application/json' -d '{"numberofsaves": "272"}' http://localhost:3001/api/v1/projects/5593c8792fee421039c0afe6





```



References
----------
- [How to test a REST api from command line with curl](http://www.codingpedia.org/ama/how-to-test-a-rest-api-from-command-line-with-curl/ ""):
- [curl](https://www.lesstif.com/display/WS/curl ""):
- [curl 설치 및 사용법 - HTTP GET/POST, REST API 연계등](https://www.lesstif.com/pages/viewpage.action?pageId=14745703 ""):
- [curl 에 신뢰하는 인증기관 인증서 추가하기](https://www.lesstif.com/pages/viewpage.action?pageId=15892500 ""):
- [지원되는 cURL 옵션](https://fmhelp.filemaker.com/help/16/fmp/ko/index.html#page/FMP_Help/curl-options.html ""):
- [ssl 이란 리다이렉트 - 명령 줄에서 CURL을 사용하여 https 연결](https://code.i-harness.com/ko-kr/q/99cddb ""):
- [REST API 제대로 알고 사용하기](https://meetup.toast.com/posts/92 ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):


.....

