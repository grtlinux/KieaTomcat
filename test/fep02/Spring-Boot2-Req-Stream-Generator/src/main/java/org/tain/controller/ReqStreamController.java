package org.tain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.generator.ReqStreamGenerator;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/reqStream"})
public class ReqStreamController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8084/reqStream/list
	@GetMapping(value = {"/list"})
	public List<String> list() {
		return ReqStreamGenerator.getInstance().getList();
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8084/reqStream/size
	@GetMapping(value = {"/size"})
	public Integer size() {
		return ReqStreamGenerator.getInstance().size();
	}

	// curl -H 'Content-Type: application/json' -X POST -d '{"index":0}' http://localhost:8084/reqStream/info
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		
		Map<?,?> map = FepHttp.getInstance().getMap(httpEntity.getBody());
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		if (flag) System.out.println(">>>>> map : " + map);
		
		Integer index = null;
		if (map.get("index") instanceof Integer) {
			index = (Integer) map.get("index");
		} else if (map.get("index") instanceof String){
			index = Integer.parseInt((String)map.get("index"));
		}
		
		String dataStream = ReqStreamGenerator.getInstance().get(index);
		if (flag) System.out.println(">>>>> dataStream : " + dataStream);
		if (dataStream == null) {
			return String.format("{\"dataStream\": %s}", dataStream);
		} else {
			return String.format("{\"dataStream\": \"%s\"}", dataStream);
		}
	}
}
