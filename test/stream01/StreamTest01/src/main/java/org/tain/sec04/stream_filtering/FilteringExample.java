package org.tain.sec04.stream_filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FilteringExample")
public class FilteringExample {
	
	public FilteringExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<String> names = Arrays.asList("홍길동", "신용권", "감자바", "신용권", "신민철");
		
		names.stream()
			.distinct()
			.forEach(m -> System.out.println(m));
		System.out.println();
		
		names.stream()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.distinct()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
		System.out.println();
	}
}
