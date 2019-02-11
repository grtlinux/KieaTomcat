package org.tain.bean4_postconstruct;

import org.springframework.stereotype.Component;

@Component
public class Bean4Test2 {

	public Bean4Test2() {
		System.out.println("Bean4Test2 생성");
		//hello();
	}
	
	public void hello() {
		System.out.println("hello Bean4Test2");
	}
}
