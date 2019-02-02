package org.tain.bean6;

import org.springframework.stereotype.Component;

@Component("Bean6Test3")
public class Bean6Test3 {

	public Bean6Test3() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean6Test3");
	}
}
