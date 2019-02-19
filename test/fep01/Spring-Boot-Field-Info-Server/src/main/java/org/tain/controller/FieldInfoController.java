package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

@RestController
public class FieldInfoController {
	
	private static final boolean flag = true;

	@GetMapping(value = {"/field"})
	public String field() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return new ClassPathResourceReader("templates/json/MastInfo.json").getContent();
	}
}
