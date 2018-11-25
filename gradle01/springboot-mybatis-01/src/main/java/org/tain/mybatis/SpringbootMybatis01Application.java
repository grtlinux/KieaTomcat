package org.tain.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootMybatis01Application {

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(SpringbootMybatis01Application.class, args);
		
		try (ConfigurableApplicationContext context = SpringApplication.run(SpringbootMybatis01Application.class, args)) {
			SpringbootMybatis01Application app = context.getBean(SpringbootMybatis01Application.class);
			app.method();
		}
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private UserMapper mapper;
	
	public void method() throws Exception {
		System.out.println("[SqlSessionTemplate]");
		this.sqlSession
			.selectList("org.tain.mybatis.UserMapper.selectTest")
			.forEach(System.out::println);
		
		System.out.println("[UserMapper]");
		this.mapper
			.selectTest()
			.forEach(System.out::println);
	}
}
