package org.tain.chapter10.hello.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("sayHelloController")
@RequestMapping("/saySomething")
public class HelloWorldController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	/*
	 * URL: http://localhost/maven-web-02/helloworld/saySomething/sayHello
	 */
	@RequestMapping("/sayHello")
	public ModelAndView sayHello() {
		log.info("INFO: {}", "sayHello function");
		Map<String, String> model = new HashMap<String, String>();
		model.put("msg", "Hello, world!!!");
		return new ModelAndView("helloworld", model);
	}
}
