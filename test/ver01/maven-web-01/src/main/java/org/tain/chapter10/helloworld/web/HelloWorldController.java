package org.tain.chapter10.helloworld.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = new HashMap<String, String>();
		model.put("msg", "Hello, world!!!(한글)");
		return new ModelAndView("helloworld", model);
	}

}
