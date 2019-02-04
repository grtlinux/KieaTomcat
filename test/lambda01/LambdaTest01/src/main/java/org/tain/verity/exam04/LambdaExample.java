package org.tain.verity.exam04;

import java.util.function.IntSupplier;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam04.LambdaExample")
public class LambdaExample {

	public LambdaExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		System.out.println("result: " + method(3, 5));
	}
	
	private int method(int x, int y) {
		IntSupplier supplier = () -> {
			// x *= 10;
			//int result = x + y;
			int result = x * 10 + y;
			return result;
		};
		
		int result = supplier.getAsInt();
		return result;
	}
}
