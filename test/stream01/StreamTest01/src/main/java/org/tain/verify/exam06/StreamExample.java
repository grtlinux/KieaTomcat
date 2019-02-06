package org.tain.verify.exam06;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component(value = "exam06.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Member> list = Arrays.asList(
				new Member("홍길동", 30),
				new Member("신용권", 40),
				new Member("감자바", 26)
			);
		
		double avg = list.stream()
				.mapToInt(Member::getAge)
				.average()
				.getAsDouble();
		
		System.out.println("평균 나이: " + avg);
	}
	
	@Data
	@AllArgsConstructor
	private static class Member {
		
		private String name;
		private int age;
	}
}
