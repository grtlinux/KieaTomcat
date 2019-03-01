package org.tain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/* [JAVA MYSQL 연동시 발생하는 에러 모음](https://yenaworldblog.wordpress.com/2018/01/24/java-mysql-%EC%97%B0%EB%8F%99%EC%8B%9C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EC%97%90%EB%9F%AC-%EB%AA%A8%EC%9D%8C/ "")
 * 
 * 1. The server time zone value ‘KST’ is unrecognized or represents more than 
 * one time zone : mysql-connector-java 버전 5.1.X 이후 버전부터 KST 타임존을 인식하지 못하는 이슈: 
 *    The server time zone value ‘KST’ is unrecognized or represents more than one time zone. 
 *    You must configure either the server or JDBC driver (via the serverTimezone configuration property) 
 *    to use a more specifc time zone value if you want to utilize time zone support.
 *    
 *    jdbc:mysql://ip:port/TestDB?characterEncoding=UTF-8&serverTimezone=UTC
 *    
 * 2. mysql 에서 타임존 추가
 *    방법 1
 *    Add in mysql config file in section [mysqld]
 *    
 *       default_time_zone='+03:00'
 *    
 *    And restart mysql server:
 *       sudo service mysql restart
 *    
 *    방법 2
 *    mysql 서버의 타임존을 “Asia/Seoul” 로 지정
 *    (http://blog.naver.com/wizardkyn/220852348757)
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		try(ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
			Application app = ctx.getBean(Application.class);
			app.method();
		}
	}

	@Autowired
	private JdbcTemplate jdbc;
	
	public void method() {
		
		this.jdbc.execute("DROP TABLE IF EXISTS TEST_TABLE");
		this.jdbc.execute("CREATE TABLE TEST_TABLE (ID INTEGER NOT NULL, VALUE VARCHAR(256))");
		
		this.jdbc.update("INSERT INTO TEST_TABLE (ID, VALUE) VALUES (?,?)", 1, "hoge");
		this.jdbc.update("INSERT INTO TEST_TABLE (ID, VALUE) VALUES (?,?)", 2, "fuga");
		this.jdbc.update("INSERT INTO TEST_TABLE (ID, VALUE) VALUES (?,?)", 3, "piyo");
		
		List<Map<String, Object>> list = this.jdbc.queryForList("SELECT * FROM TEST_TABLE");
		list.forEach(System.out::println);
	}
}
