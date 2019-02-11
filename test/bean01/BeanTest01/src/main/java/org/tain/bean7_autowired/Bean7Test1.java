package org.tain.bean7_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "Bean7Test1")
public class Bean7Test1 {

	@Autowired
	private Bean7Test2 bean7Test2;
	
	public Bean7Test1() {
		System.out.println(">>>>> Bean7Test1 constructor");  // OK!!
		//bean7Test2.hello();  // error
	}
	
	@Bean(value = "Bean7Test1.hello")
	public void hello() {
		bean7Test2.hello();  // OK!!
		System.out.println(">>>>> Bean7Test1.hello method...");  // OK!!
	}
}
