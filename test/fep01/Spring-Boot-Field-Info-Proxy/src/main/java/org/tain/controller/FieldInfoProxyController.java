package org.tain.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;

@RestController
@RequestMapping(value = {"/fieldInfo"})
public class FieldInfoProxyController {
	
	@SuppressWarnings("unused")
	private static final boolean flag = true;

//	@GetMapping(value = {"/field/{name}"})
//	public String field(@PathVariable("name") String name) {
//		if (flag) System.out.printf(">>>>> [name=%s] [%s]%n", name, ClassUtil.getClassInfo());
//		
//		return FieldInfoProxy.get(name);
//	}
	
	// private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping(value = {"/list"})
	public String list() {
		return FepHttp.getInstance().getList("http://localhost:8081/fieldInfo/list");
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8081/fieldInfo/info
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		return FepHttp.getInstance().postInfo("http://localhost:8081/fieldInfo/info", httpEntity.getBody());
	}
}
