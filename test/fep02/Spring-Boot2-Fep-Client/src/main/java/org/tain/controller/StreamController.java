package org.tain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.fep.stream.client.StreamClient;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/stream"})
public class StreamController {

	private static final boolean flag = true;
	
	@Autowired
	private StreamClient streamClient;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8085/reqStream/list
	@GetMapping(value = {"/list"})
	public String list() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8092/resStream/list");
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8085/reqStream/size
	@GetMapping(value = {"/size"})
	public String size() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8092/resStream/size");
	}

	// curl -H 'Content-Type: application/json' -X POST -d '{"index":0}' http://localhost:8088/stream/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		return this.streamClient.runner(httpEntity.getBody());
	}
}
