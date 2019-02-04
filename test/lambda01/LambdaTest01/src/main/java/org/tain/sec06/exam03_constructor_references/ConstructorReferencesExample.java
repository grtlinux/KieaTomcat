package org.tain.sec06.exam03_constructor_references;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ConstructorReferencesExample")
public class ConstructorReferencesExample {

	public ConstructorReferencesExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Function<String, Member> function1 = Member::new;
		Member member1 = function1.apply("angel");
		System.out.println("member1: " + member1);
		
		BiFunction<String, String, Member> function2 = Member::new;
		Member member2 = function2.apply("신천사", "angel");
		System.out.println("member2: " + member2);
	}
}
