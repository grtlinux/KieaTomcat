package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.utils.ClassUtil;

@RestController
public class HelloController {

	private static final boolean flag = true;
	
	public HelloController() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	@GetMapping(value = {"/", "/index", "/home"})
	public String hello() {
		return "Hello, world!!!!";
	}
}
