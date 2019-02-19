package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping({"", "/", "/index", "/home"})
	public String index() {
		return "Hello, world!!!";
	}
}
