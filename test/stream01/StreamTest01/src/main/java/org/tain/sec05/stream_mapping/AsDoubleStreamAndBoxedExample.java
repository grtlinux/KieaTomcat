package org.tain.sec05.stream_mapping;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "AsDoubleStreamAndBoxedExample")
public class AsDoubleStreamAndBoxedExample {

	public AsDoubleStreamAndBoxedExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		int[] intArray = { 1, 2, 3, 4, 5};
		
		IntStream intStream = Arrays.stream(intArray);
		intStream
			.asDoubleStream()
			.forEach(a -> System.out.print(a + ", "));
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		intStream
			.boxed()
			.forEach(a -> System.out.print(a.intValue() + ", "));
		System.out.println();
	}
}
