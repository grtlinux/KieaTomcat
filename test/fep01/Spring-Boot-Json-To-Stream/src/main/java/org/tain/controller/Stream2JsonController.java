package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/stream2json"})
public class Stream2JsonController {

	@GetMapping(value = {"", "/index", "/home"})
	public String index() {
		return "Stream to JSON!!!";
	}
}
