package org.tain.bean0_component_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Bean0Test2 {

	@Bean
	public void testBean2() {
		System.out.println(">>>>> Bean0Test2.testBean2().");
	}
}
