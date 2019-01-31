package org.tain.bean4;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean4Test1 {

	public Bean4Test1() {
		System.out.println("Bean4Test1 생성");
		//hello();
	}
	
	@Autowired
	private Bean4Test3 bean4Test3;
	
	@PostConstruct
	public void hello() {
		bean4Test3.hello();
		System.out.println("hello Bean4Test1");
	}
}
