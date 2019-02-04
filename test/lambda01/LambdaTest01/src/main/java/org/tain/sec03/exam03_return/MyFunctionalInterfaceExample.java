package org.tain.sec03.exam03_return;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("MyFunctionalInterfaceExample2")
public class MyFunctionalInterfaceExample {

	public MyFunctionalInterfaceExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		MyFunctionalInterface fi = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println("result1 = " + fi.method(2, 5));
		
		fi = (x, y) -> { return x + y; };
		System.out.println("result2 = " + fi.method(2, 5));
		
		fi = (x, y) -> x + y;
		System.out.println("result3 = " + fi.method(2, 5));
		
		fi = (x, y) -> sum(x, y);
		System.out.println("result4 = " + fi.method(2, 5));
	}
	
	public int sum(int x, int y) {
		return (x + y);
	}
}
