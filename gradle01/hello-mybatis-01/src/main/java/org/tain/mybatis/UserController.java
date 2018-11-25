package org.tain.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(path = "/")
	public String hello() {
		return "Hello world!!!";
	}
	
	@RequestMapping(path = "/test")
	public int count(Model model) {
		List<UserDto> lstUser = userMapper.findAll();
		return lstUser.size();
	}
}
