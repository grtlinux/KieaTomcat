package org.tain.kang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	/*
	 * http://localhost:8080/demo/add?name=kang1&email=hello1@mail.com
	 * http://localhost:8080/demo/add?name=kang2&email=hello2@mail.com
	 * http://localhost:8080/demo/add?name=kang3&email=hello3@mail.com
	 * http://localhost:8080/demo/add?name=kang4&email=hello4@mail.com
	 * http://localhost:8080/demo/add?name=kang5&email=hello5@mail.com
	 */
	@GetMapping(path = "/add")
	public @ResponseBody String add(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		this.userRepository.save(user);
		return "Saved";
	}
	
	/*
	 *  http://localhost:8080/demo/all
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> all() {
		return this.userRepository.findAll();
	}
}
