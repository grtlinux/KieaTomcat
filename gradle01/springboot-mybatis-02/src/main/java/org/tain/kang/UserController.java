package org.tain.kang;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/session")
	public List<Map<String, Object>> session() throws Exception {
		return this.sqlSessionTemplate.selectList("org.tain.kang.UserMapper.selectUserList");
	}
	
	@RequestMapping(value = "/mapper")
	public List<Map<String, Object>> mapper() throws Exception {
		return this.userMapper.selectUserList();
	}
}
