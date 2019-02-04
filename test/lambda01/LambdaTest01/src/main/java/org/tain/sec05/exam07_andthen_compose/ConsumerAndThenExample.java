package org.tain.sec05.exam07_andthen_compose;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ConsumerAndThenExample")
public class ConsumerAndThenExample {
	
	public ConsumerAndThenExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Consumer<Member> consumerA = (m) -> {
			System.out.println("consumerA: " + m.getName());
		};
		
		Consumer<Member> consumerB = (m) -> {
			System.out.println("consumerB: " + m.getId());
		};
		
		Consumer<Member> consumerAB = consumerA.andThen(consumerB);
		consumerAB.accept(new Member("홍길동", "Hong", null));
	}
}
