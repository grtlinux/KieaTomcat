package org.tain.bean5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Jeongpro implements Person{

	@Override
	public void eat() {
		System.out.println("jeongpro");
	}
}
