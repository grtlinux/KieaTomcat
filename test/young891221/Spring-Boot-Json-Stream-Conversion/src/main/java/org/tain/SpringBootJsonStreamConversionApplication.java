package org.tain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBootJsonStreamConversionApplication {

	public static void main(String[] args) {
		System.out.println(">>>>> SpringBoot START: " + ClassUtil.getClassInfo());
		SpringApplication.run(SpringBootJsonStreamConversionApplication.class, args);
		System.out.println(">>>>> SpringBoot END: " + ClassUtil.getClassInfo());
		
		System.exit(0);
	}
	
	@Bean
	public CommandLineRunner runner() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return null;
	}
}
