package org.tain.kang;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
		Greeting greeting = new Greeting(String.format(template, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		
		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}
}
