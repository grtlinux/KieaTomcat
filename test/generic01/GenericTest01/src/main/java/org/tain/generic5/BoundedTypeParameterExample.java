package org.tain.generic5;

import org.springframework.stereotype.Component;

@Component
public class BoundedTypeParameterExample {

	public BoundedTypeParameterExample() {
		// String str = Util.compare("a", "b"); (X)
		
		int result1 = Util.compare(10, 20);
		System.out.println(">>>>> result1 = " + result1);
		
		int result2 = Util.compare(4.5, 3);
		System.out.println(">>>>> result2 = " + result2);		
	}
}
