package org.tain.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.reqgenerator.ReqGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/reqGen")
public class ReqGeneratorController {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8083/reqGen/dataSize
	@GetMapping(value = {"/dataSize"})
	public String dataSize() {
		int size = ReqGenerator.getInstance().size();
		return String.format("{\"dataSize\": %d}", size);
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"index":0}' http://localhost:8083/reqGen/data
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		Map<?, ?> map = this.objectMapper.readValue(/* json */httpEntity.getBody(), Map.class);
		Integer index = (Integer) map.get("index");
		return String.format("{\"dataStream\": \"%s\"}", ReqGenerator.getInstance().get(index));
	}
}
