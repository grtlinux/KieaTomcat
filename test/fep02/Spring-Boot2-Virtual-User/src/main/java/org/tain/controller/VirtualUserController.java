package org.tain.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/virtualUser"})
public class VirtualUserController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"fld001": 990}' http://localhost:8086/virtualUser/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		String json = FepHttp.getInstance().post("http://localhost:8087/adapter/info", httpEntity.getBody());
		
		//Map<?,?> map = FepHttp.getInstance().getMap(json);
		//if (flag) System.out.println(">>>>> map : " + map);
		
		return json;
	}
}
