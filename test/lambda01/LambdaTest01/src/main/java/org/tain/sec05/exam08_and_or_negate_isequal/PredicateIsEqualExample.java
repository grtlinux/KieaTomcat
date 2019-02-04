package org.tain.sec05.exam08_and_or_negate_isequal;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "PredicateIsEqualExample")
public class PredicateIsEqualExample {
	
	public PredicateIsEqualExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Predicate<String> predicate;
		
		predicate = Predicate.isEqual(null);
		System.out.println("null, null: " + predicate.test(null));
		
		predicate = Predicate.isEqual("Java8");
		System.out.println("null, Java8: " + predicate.test(null));
		
		predicate = Predicate.isEqual(null);
		System.out.println("Java8, null: " + predicate.test("Java8"));
		
		predicate = Predicate.isEqual("Java8");
		System.out.println("Java8, Java8: " + predicate.test("Java8"));
		
		predicate = Predicate.isEqual("Java8");
		System.out.println("Java7, Java8: " + predicate.test("Java7"));
	}
}
