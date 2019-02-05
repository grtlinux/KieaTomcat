package org.tain.sec07.stream_looping;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "LoopingExample")
public class LoopingExample {

	public LoopingExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		int[] intArr = { 1, 2, 3, 4, 5 };
		
		System.out.println("1. [peek()를 마지막에 호출한 경우]");
		Arrays.stream(intArr)
			.filter(a -> a%2 == 0)
			.peek(n -> System.out.println("\t" + n));   //동작하지 않음
		System.out.println();
		
		System.out.println("2-1. [최종 처리 메소드를 마지막에 호출한 경우]");
		int total1 = Arrays.stream(intArr)
				.filter(a -> a%2 == 0)
				.sum();
		System.out.println("\t총합: " + total1);
		
		System.out.println("2-2. [최종 처리 메소드를 마지막에 호출한 경우]");
		int total2 = Arrays.stream(intArr)
			.filter(a -> a%2 == 0)
			.peek(n -> System.out.println("\t" + n))   //동작함
			.sum();
		System.out.println("\t총합: " + total2);
		
		System.out.println("3. [forEach()를 마지막에 호출한 경우]");
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.forEach(n -> System.out.println("\t" + n)); //동작함
		System.out.println();
	}
}
