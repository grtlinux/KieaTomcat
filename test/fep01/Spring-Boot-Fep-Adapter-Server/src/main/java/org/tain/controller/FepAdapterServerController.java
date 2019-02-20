package org.tain.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = {"/fepAdapter"})
public class FepAdapterServerController {

	private static final boolean flag = true;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@GetMapping(value = {"/", "/index", "/home"})
	public String index() {
		return "Hello, world!!!!";
	}

	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8085/fepAdapter/req
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/req", method = RequestMethod.POST)
	public String req(HttpEntity<String> httpEntity) throws Exception {
		String json = httpEntity.getBody();
		if (flag) System.out.println(">>>>> json: " + json);
		
		Map<?, ?> map = this.objectMapper.readValue(json, Map.class);
		if (flag) System.out.println(">>>>> map: " + map);
		
		//String infoKey = (String) map.get("infoKey");
		//return FieldInfoJson.getInstance().get(infoKey);
		return "{\"result\": \"OK\", \"status\": \"SUCCESS\"}";
	}
}
