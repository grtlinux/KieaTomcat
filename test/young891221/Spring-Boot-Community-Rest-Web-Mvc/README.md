Spring-Boot-Community-Rest-Web-Mvc
==================================

```
	DOS> curl http://localhost:8081/api/boards
	
	DOS> curl "http://localhost:8081/api/boards?page=0&size=20"
	
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
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):


.....

