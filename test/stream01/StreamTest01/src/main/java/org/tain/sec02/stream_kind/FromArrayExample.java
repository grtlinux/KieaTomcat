package org.tain.sec02.stream_kind;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FromArrayExample")
public class FromArrayExample {

	public FromArrayExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		String[] strArray = { "홍길동", "신용권", "김미나"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(a -> System.out.print(a + ","));
		System.out.println();
		
		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(a -> System.out.print(a + ","));
		System.out.println();
	}
}
