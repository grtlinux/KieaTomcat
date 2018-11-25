package org.tain.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) {
		String formattedDate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale).format(new Date());
		model.addAttribute("serverTime", formattedDate);
		return "index";
	}
}
