package org.tain.bean2_component_autowired;

import org.springframework.stereotype.Component;

@Component
public class Bean2Test3 {

	public Bean2Test3() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean2Test3");
	}
}
