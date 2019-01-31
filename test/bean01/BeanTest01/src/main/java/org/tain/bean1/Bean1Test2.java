package org.tain.bean1;

import org.springframework.stereotype.Component;

@Component
public class Bean1Test2 {

	public Bean1Test2() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean1Test2");
	}
}
