package org.tain.sec02.stream_kind;

import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FromIntRangeExample")
public class FromIntRangeExample {

	private static int sum = 0;
	
	public FromIntRangeExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("sum is " + sum);
	}
}
