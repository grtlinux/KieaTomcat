package org.tain.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/fieldInfo"})
public class FieldInfoController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8082/fieldInfo/list
	@GetMapping(value = {"/list"})
	public String list() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8081/fieldInfo/list");
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8082/fieldInfo/info
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		return FepHttp.getInstance().post("http://localhost:8081/fieldInfo/info", httpEntity.getBody());
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8082/fieldInfo/MastInfo
	@GetMapping(value = {"/{name}"})
	public String field(@PathVariable("name") String name) throws Exception {
		return FepHttp.getInstance().get("http://localhost:8081/fieldInfo/" + name);
	}
}
