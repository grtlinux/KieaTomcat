package org.tain.bean6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Bean6Test0 {

	@Bean("hello1")
	@DependsOn(value = {"hello3", "hello2"})
	public void hello1() {
		System.out.println(">>>>> Bean6Test0.hello1");
	}
	
	@Bean("hello2")
	public void hello2() {
		System.out.println(">>>>> Bean6Test0.hello2");
	}
	
	@Bean("hello3")
	public void hello3() {
		System.out.println(">>>>> Bean6Test0.hello3");
	}
}
