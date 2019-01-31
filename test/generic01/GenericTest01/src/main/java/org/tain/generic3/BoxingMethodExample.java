package org.tain.generic3;

import org.springframework.stereotype.Component;

@Component
public class BoxingMethodExample {

	public BoxingMethodExample() {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		System.out.println(">>>>> box1 : " + box1);
		
		Box<String> box2 = Util.<String>boxing("홍길동");
		System.out.println(">>>>> box2 : " + box2);
	}
}
