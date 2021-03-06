package org.tain.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/adapter"})
public class AdapterController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"fld001": 990}' http://localhost:8087/adapter/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		//String json = FepHttp.getInstance().post("http://localhost:8090/db/info", httpEntity.getBody());
		String json = FepHttp.getInstance().post("http://localhost:8088/stream/info", httpEntity.getBody());
		
		return json;
	}
}
