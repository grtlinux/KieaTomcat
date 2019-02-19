package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.httptest.HttpClientTest;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBootUriHttpClientApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootUriHttpClientApplication.class, args);
		
		if (!flag) System.exit(0);
	}

	@Autowired
	private HttpClientTest httpClientTest;
	
	@Bean
	public CommandLineRunner runner() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		this.httpClientTest.test01();
		
		return null;
	}
}
