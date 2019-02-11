package org.tain.bean7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bean7Test1 {

	public Bean7Test1() {
		System.out.println(">>>>> Bean7Test1 constructor");  // OK!!
	}
	
	@Bean
	public void hello() {
		System.out.println(">>>>> Bean7Test1.hello method...");  // OK!!
	}
}
