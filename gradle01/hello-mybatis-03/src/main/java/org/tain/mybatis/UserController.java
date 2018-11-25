package org.tain.mybatis;

import java.util.List;
import java.util.Map;

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
	public String index() throws Exception {
		List<Map<String, Object>> list = this.userMapper.selectUserList();
		for (Map<String, Object> map : list) {
			Integer userId = (Integer) map.get("USER_ID");
			String name = (String) map.get("NAME");
			System.out.printf("User[user_id=%d, name='%s']%n", userId, name);
		}
		
		return "Hello gradle project....";
	}
}
