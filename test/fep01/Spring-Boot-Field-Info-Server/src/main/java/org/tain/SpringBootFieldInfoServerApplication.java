package org.tain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFieldInfoServerApplication {
	
	private static final boolean flag = true;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFieldInfoServerApplication.class, args);
		
		if (!flag) System.exit(0);
	}
}
