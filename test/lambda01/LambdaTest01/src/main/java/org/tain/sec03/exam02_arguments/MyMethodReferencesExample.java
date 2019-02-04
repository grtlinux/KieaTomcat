package org.tain.sec03.exam02_arguments;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("MyMethodReferencesExample")
public class MyMethodReferencesExample {

	public MyMethodReferencesExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		MyFunctionalInterface fi = (x) -> {
			int result = x * 5;
			System.out.println("result1 = " + result);
		};
		fi.method(2);
		
		fi = (x) -> { System.out.println("result2 = " + x*5); };
		fi.method(2);
		
		fi = (x) -> System.out.println("result3 = " + x*5);
		fi.method(2);
	}
}
