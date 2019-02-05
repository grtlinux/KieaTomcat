package org.tain.sec01.stream_instroduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ParallelExample")
public class ParallelExample {

	public ParallelExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<String> list = Arrays.asList("홍길동", "신용권", "감자바", "람다식", "박병렬");
		
		// 순차 처리
		Stream<String> stream = list.stream();
		stream.forEach(ParallelExample::print);
		System.out.println();
		
		// 병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelExample::print);
	}
	
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
}
