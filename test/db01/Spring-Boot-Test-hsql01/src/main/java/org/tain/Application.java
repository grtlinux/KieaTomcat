package org.tain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * - [https://araikuma.tistory.com/35](Spring Boot. 데이터베이스 접근 "")
 * 
 * 의존관계에 spring-boot-starter-jdbc과 사용하는 DBorg.hsqldb:hsqldb)를 추가한다.
 * 그러면 지정한 db를 메모리 상에 올려서 사용할 수 있게 된다.
 * 메모리에 저장되기에 JVM이 정지하면 데이터가 손실된다.
 * HSQLDB 외에 H2 및 Derby 를 동일하게 내장해서 이용이 가능하다.
 * 
 * 데이터를 파일에 저장하기 위해서는
 * 
 * application.properties
 *     spring.datasource.url = jdbc:hsqldb:file:./db/testdb;shutdown=true
 * 
 * 프라퍼티 파일에 spring.datasource.url을 정의하여 JDBC 연결 가능한 URL을 지정할 수 있다.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		
		try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
			Application app = ctx.getBean(Application.class);
			app.method();
		}
	}
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public void method() {
		
		this.jdbc.execute("CREATE TABLE TEST_TABLE (ID INTEGER NOT NULL IDENTITY, VALUE VARCHAR(256))");
		
		this.jdbc.update("INSERT INTO TEST_TABLE (VALUE) VALUES (?)", "hoge");
		this.jdbc.update("INSERT INTO TEST_TABLE (VALUE) VALUES (?)", "fuga");
		this.jdbc.update("INSERT INTO TEST_TABLE (VALUE) VALUES (?)", "piyo");
		
		List<Map<String, Object>> list = this.jdbc.queryForList("SELECT * FROM TEST_TABLE");
		list.forEach(System.out::println);
	}
}
