package org.tain.bean6_dependson;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = {"Bean6Test3"})
public class Bean6Test1 {

	public Bean6Test1() {
		hello();
	}
	
	public void hello() {
		System.out.println("hello Bean6Test1");
	}
}
