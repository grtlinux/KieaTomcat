package org.tain.bean1;

import org.springframework.stereotype.Component;

@Component
public class Bean1Test1 {

	public Bean1Test1() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean1Test1");
	}
}
