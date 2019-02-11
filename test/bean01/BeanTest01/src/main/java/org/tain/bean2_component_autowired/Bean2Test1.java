package org.tain.bean2_component_autowired;

import org.springframework.stereotype.Component;

@Component
public class Bean2Test1 {

	//@Autowired
	//BeanTest3 beanTest3;
	
	public Bean2Test1() {
		hello();
		//beanTest3.hello();  // BeanCreationException...
	}
	
	public void hello() {
		System.out.println("hello Bean2Test1");
	}
}
