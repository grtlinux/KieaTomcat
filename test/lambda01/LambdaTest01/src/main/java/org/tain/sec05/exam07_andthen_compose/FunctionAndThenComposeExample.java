package org.tain.sec05.exam07_andthen_compose;

import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FunctionAndThenComposeExample")
public class FunctionAndThenComposeExample {

	public FunctionAndThenComposeExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Function<Member, Address> functionA;
		Function<Address, String> functionB;
		Function<Member, String> functionAB;
		String city;
		
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();

		functionAB = functionA.andThen(functionB);
		city = functionAB.apply(
				new Member("홍길동", "Hong", new Address("한국", "서울"))
				);
		System.out.println("거주 도시: " + city);
		
		functionAB = functionB.compose(functionA);
		city = functionAB.apply(
				new Member("홍길동", "Hong", new Address("한국", "서울"))
				);
		System.out.println("거주 도시: " + city);
	}
}
