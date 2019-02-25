package org.tain.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/store"})
public class StoreController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}

	// curl -H 'Content-Type: application/json' -X POST -d '{"fld001":990}' http://localhost:8093/store/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		Map<?,?> map = FepHttp.getInstance().getMap(httpEntity.getBody());
		if (flag) System.out.println(">>>>> prettyJson(map) : " + FepHttp.getInstance().getPrettyJson(map));
		return String.format("{\"status\": \"%s\"}", "00000");
	}
}
