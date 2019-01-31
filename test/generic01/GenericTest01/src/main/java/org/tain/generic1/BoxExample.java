package org.tain.generic1;

import org.springframework.stereotype.Component;

@Component
public class BoxExample {

	public BoxExample() {
		Box<String> box1 = new Box<>();
		box1.setT("Hello");
		String str = box1.getT();
		System.out.println(">>>>> str=" + str);
		
		Box<Integer> box2 = new Box<>();
		box2.setT(123);
		int val = box2.getT();
		System.out.println(">>>>> val=" + val);
	}
}
