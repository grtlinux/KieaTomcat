package org.tain.sec05.exam08_and_or_negate_isequal;

import java.util.function.IntPredicate;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "PredicateAndOrNegateExample")
public class PredicateAndOrNegateExample {
	
	public PredicateAndOrNegateExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		// 2의 배수 검사
		IntPredicate predicateA = (a) -> (a)%2 == 0;
		
		// 3의 배수 검사
		IntPredicate predicateB = (a) -> (a)%3 == 0;
		
		IntPredicate predicateAB;
		boolean result;
		
		// and()
		predicateAB = predicateA.and(predicateB);
		result = predicateAB.test(9);
		System.out.println("9는 2와 3의 배수입니까? " + result);
		
		// or()
		predicateAB = predicateA.or(predicateB);
		result = predicateAB.test(9);
		System.out.println("9는 2 또는 3의 배수입니까? " + result);
		
		// negate()
		predicateAB = predicateA.negate();
		result = predicateAB.test(9);
		System.out.println("9는 홀수 입니까? " + result);
	}
}
