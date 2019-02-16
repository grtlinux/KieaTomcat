package org.tain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class Application {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		if (flag) System.exit(0);
	}

	@Bean
	public void test01() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
}

