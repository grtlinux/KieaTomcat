package org.tain.bean3;

import org.springframework.stereotype.Component;

@Component
public class Bean3Test2 {

	public Bean3Test2() {
		System.out.println("Bean3Test2 생성");
		//hello();
	}
	
	public void hello() {
		System.out.println("hello Bean3Test2");
	}
}
