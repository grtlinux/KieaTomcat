package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = {"/stream2json"})
public class HelloController {

	@GetMapping(value = {"", "/index", "/home"})
	public String index() {
		return "Hello, world!!!";
	}
}
