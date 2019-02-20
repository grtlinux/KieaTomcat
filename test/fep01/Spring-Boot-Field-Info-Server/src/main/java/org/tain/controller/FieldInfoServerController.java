package org.tain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.json.FieldInfoJson;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = {"/fieldInfo"})
public class FieldInfoServerController {
	
	private static final boolean flag = true;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	// curl -H 'Content-Type: application/json' -X GET http://localhost:8081/fieldInfo/list
	@GetMapping(value = {"/list"})
	public List<String> list() {
		return FieldInfoJson.getInstance().getList();
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8081/fieldInfo/info
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		Map<?, ?> map = this.objectMapper.readValue(/* json */httpEntity.getBody(), Map.class);
		String infoKey = (String) map.get("infoKey");
		return FieldInfoJson.getInstance().get(infoKey);
	}
	
	// not used
	//@GetMapping(value = {"/{name}"})
	public String field(@PathVariable("name") String name) {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		String filePath = String.format("templates/json/%s.json", name);
		if (flag) System.out.println(">>>>> " + filePath);
		String content = new ClassPathResourceReader(filePath).getContent();
		return content;
	}
}
