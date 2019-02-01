package org.tain.bean0;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Bean0Test1 {

	public Bean0Test1() {
		System.out.println(">>>>> Bean0Test1.constructor().");
	}
	
	@Bean
	public void testBean1() {
		System.out.println(">>>>> Bean0Test1.testBean1().");
	}
}
