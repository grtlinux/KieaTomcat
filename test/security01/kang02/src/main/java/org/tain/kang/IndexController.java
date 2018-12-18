package org.tain.kang;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping
	public ModelAndView index(HttpSession session) {
		System.out.println("KANG >>>>> IndexController.index()");
		return new ModelAndView();
	}
}
