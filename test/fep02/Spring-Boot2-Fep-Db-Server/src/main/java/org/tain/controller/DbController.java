package org.tain.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/db"})
public class DbController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"fld001":990}' http://localhost:8090/db/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		String json;
		
		// json {"status": "00000"}
		json = FepHttp.getInstance().post("http://localhost:8093/store/info", httpEntity.getBody());
		if (flag) System.out.println(">>>>> step 1: json = " + json);
		
		// res json
		json = FepHttp.getInstance().post("http://localhost:8091/resStream/info", "{\"index\": 0}");
		if (flag) System.out.println(">>>>> step 2: json = " + json);
		
		return json;
	}
}
