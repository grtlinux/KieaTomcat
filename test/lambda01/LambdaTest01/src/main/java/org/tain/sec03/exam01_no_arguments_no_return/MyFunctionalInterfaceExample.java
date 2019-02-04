package org.tain.sec03.exam01_no_arguments_no_return;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

//@Configuration   // execute OK
@Component("MyFunctionalInterfaceExample1")       // execute OK
public class MyFunctionalInterfaceExample {

	public MyFunctionalInterfaceExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		MyFunctionalInterface fi = () -> {
			String str = "method call";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> { System.out.println("method call2"); };
		fi.method();
		
		fi = () -> System.out.println("method call3");
		fi.method();
	}
}
