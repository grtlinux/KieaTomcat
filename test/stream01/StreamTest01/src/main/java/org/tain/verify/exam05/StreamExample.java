package org.tain.verify.exam05;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam05.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<String> list = Arrays.asList(
				"This is a java book",
				"Lambda Expressions",
				"Java8 supports lambda expressions"
			);
		
		list.stream()
			.filter(a -> a.toLowerCase().contains("java"))
			.forEach(a -> System.out.println(a));
	}
}
