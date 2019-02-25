package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = {"/", "/index", "/home"})
	public String hello() {
		return "Hello, world!!!!";
	}
}
