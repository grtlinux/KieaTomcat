package org.tain.bean3_dependson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = {"Bean3Test3"})
public class Bean3Test1 {

	public Bean3Test1() {
		System.out.println("Bean3Test1 생성");
		//hello();
	}
	
	@Autowired
	private Bean3Test3 bean3Test3;
	
	public void hello() {
		bean3Test3.hello();
		System.out.println("hello Bean3Test1");
	}
}
