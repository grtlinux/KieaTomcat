package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/server"})
public class ServerController {

	private static final boolean flag = true;
	
	public ServerController() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	@GetMapping(value = {"/"})
	public String hello() {
		return "Hello, world!!!!";
	}
	
	/*
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8082/fieldInfo/list
	@GetMapping(value = {"/list"})
	public String list() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8082/fieldInfo/list");
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8082/fieldInfo/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		return FepHttp.getInstance().post("http://localhost:8082/fieldInfo/info", httpEntity.getBody());
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8082/fieldInfo/MastInfo
	@GetMapping(value = {"/{name}"})
	public String field(@PathVariable("name") String name) throws Exception {
		return FepHttp.getInstance().get("http://localhost:8082/fieldInfo/" + name);
	}

	//////////////////////////////////////////////////////////////////////////////////
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8082/fieldInfo/info
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpEntity<String> httpEntity) throws Exception {
		String jsonData = httpEntity.getBody();
		if (flag) System.out.println(">>>>> jsonData REQ : " + jsonData);
		
		return String.format("{\"status\": \"%05d\"}", 0);
	}
	*/
}
