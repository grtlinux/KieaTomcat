package org.tain.bean2;

import org.springframework.stereotype.Component;

@Component
public class Bean2Test2 {

	public Bean2Test2() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean2Test2");
	}
}
