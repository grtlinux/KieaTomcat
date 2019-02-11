package org.tain.bean4_postconstruct;

import org.springframework.stereotype.Component;

@Component
public class Bean4Test3 {

	public Bean4Test3() {
		System.out.println("Bean4Test3 생성");
		//hello();
	}
	
	public void hello() {
		System.out.println("hello Bean4Test3");
	}
}
