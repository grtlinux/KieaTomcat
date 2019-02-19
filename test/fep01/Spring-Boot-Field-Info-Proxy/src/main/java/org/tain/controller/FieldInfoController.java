package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.proxy.FieldInfoProxy;
import org.tain.utils.ClassUtil;

@RestController
public class FieldInfoController {
	
	private static final boolean flag = true;

	@GetMapping(value = {"/field/{name}"})
	public String field(@PathVariable("name") String name) {
		if (flag) System.out.printf(">>>>> [name=%s] [%s]%n", name, ClassUtil.getClassInfo());
		
		return FieldInfoProxy.get(name);
	}
}
