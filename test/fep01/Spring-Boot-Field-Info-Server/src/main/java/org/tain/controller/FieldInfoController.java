package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

@RestController
public class FieldInfoController {
	
	private static final boolean flag = true;

	@GetMapping(value = {"/field/{name}"})
	public String field(@PathVariable("name") String name) {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		String filePath = String.format("templates/json/%s.json", name);
		if (flag) System.out.println(">>>>> " + filePath);
		String content = new ClassPathResourceReader(filePath).getContent();
		return content;
	}
}
