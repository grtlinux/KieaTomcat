package org.tain.sec06.exam02_argument_method_references;

import java.util.function.ToIntBiFunction;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ArgumentMethodReferencesExample")
public class ArgumentMethodReferencesExample {

	public ArgumentMethodReferencesExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		ToIntBiFunction<String, String> function;
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "JAVA8"));
		
		function = String::compareToIgnoreCase;
		print(function.applyAsInt("Java8", "JAVA8"));
	}
	
	public void print(int order) {
		if (order < 0) {
			System.out.println("사전순으로 먼저 옵니다.");
		} else if (order == 0) {
			System.out.println("동일한 문자열입니다.");
		} else {
			System.out.println("사전순으로 나중에 옵니다.");
		}
	}
}
