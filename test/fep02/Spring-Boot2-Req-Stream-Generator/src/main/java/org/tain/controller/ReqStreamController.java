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
		Integer index = (Integer) map.get("index");
		String dataStream = ReqStreamGenerator.getInstance().get(index);
		if (dataStream == null) {
			return String.format("{\"dataStrean\": %s}", dataStream);
		} else {
			return String.format("{\"dataStrean\": \"%s\"}", dataStream);
		}
	}
}
