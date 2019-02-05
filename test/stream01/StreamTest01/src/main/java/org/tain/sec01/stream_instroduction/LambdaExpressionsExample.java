package org.tain.sec01.stream_instroduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "LambdaExpressionsExample")
public class LambdaExpressionsExample {

	public LambdaExpressionsExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Student> list = Arrays.asList(
				new Student("홍길동", 90),
				new Student("신용권", 92)
		);
		
		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "-" + score);
		});
	}
}
