package org.tain.sec10.stream_reduce;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ReductionExample")
public class ReductionExample {

	public ReductionExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("감자바", 88)
		);
		
		int sum1 = studentList.stream()
				.mapToInt(Student::getScore)
				.sum();
		System.out.println("sum1: " + sum1);
		
		int sum2 = studentList.stream()
				.map(Student::getScore)
				.reduce((a, b) -> a + b)
				.get();
		System.out.println("sum2: " + sum2);
		
		int sum3 = studentList.stream()
				.map(Student::getScore)
				.reduce(0,  (a, b) -> a+b);
		System.out.println("sum3: " + sum3);
	}
}
