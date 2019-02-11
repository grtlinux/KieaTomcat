package org.tain.bean1_constructor_call_method;

import org.springframework.stereotype.Component;

@Component
public class Bean1Test3 {

	public Bean1Test3() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean1Test3");
	}
}
