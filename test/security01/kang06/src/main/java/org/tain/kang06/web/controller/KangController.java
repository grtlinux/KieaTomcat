package org.tain.kang06.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KangController {

	@GetMapping("/kang")
	public String kang() {
		return "kang";
	}
}
