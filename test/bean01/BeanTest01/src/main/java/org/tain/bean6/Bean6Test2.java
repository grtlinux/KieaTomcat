package org.tain.bean6;

import org.springframework.stereotype.Component;

@Component
public class Bean6Test2 {

	public Bean6Test2() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean6Test2");
	}
}
