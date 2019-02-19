package org.tain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.reqgenerator.ReqGenerator;

@RestController
@RequestMapping("/generator")
public class ReqGeneratorController {

	@GetMapping("/req/{idx}")
	public String req(@PathVariable("idx") Integer idx) {
		return ReqGenerator.getInstance().get(idx);
	}
	
	@GetMapping("/size")
	public String size() {
		int size = ReqGenerator.getInstance().size();
		return String.format("{\"size\":%d}", size);
	}
}
