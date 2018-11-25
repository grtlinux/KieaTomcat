package org.tain.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String home() throws Exception {
		List<UserDto> list = userMapper.selectUserList();
		for (UserDto user : list) {
			System.out.printf("User[user_id=%d, name='%s']%n", user.getUserId(), user.getName());
		}
		
		return "Hello gradle project!!!";
	}
}
