package org.tain.sec01.stream_instroduction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "IteratorVsStreamExample")
public class IteratorVsStreamExample {

	public IteratorVsStreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<String> list = Arrays.asList("홍길동", "신용권", "김자바");
		
		// Iterator
		System.out.println("Iterator ---");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println("> " + name);
		}
		
		// Stream 1
		System.out.println("Stream 1 ---");
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println("> " + name));
		
		// Stream 2
		System.out.println("Stream 2 ---");
		list.stream().forEach(name -> System.out.println("> " + name));
	}
}
