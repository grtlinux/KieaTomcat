package org.tain.bean3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bean3Test3 {

	public Bean3Test3() {
		System.out.println("Bean3Test3 생성");
		//hello();
	}
	
	@Bean("Bean3Test3")
	public Bean3Test3 create() {
		return this;
	}
	
	public void hello() {
		System.out.println("hello Bean3Test3");
	}
}
