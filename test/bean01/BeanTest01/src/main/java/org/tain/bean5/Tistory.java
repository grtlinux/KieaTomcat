package org.tain.bean5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Tistory implements Person {

	@Override
	public void eat() {
		System.out.println("tistory");
	}
}
