package org.tain.kang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/list")
	public List<User> list() {
		List<User> list = (List<User>) this.userRepository.findAll();
		return list;
	}
}
