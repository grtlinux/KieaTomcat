package org.tain.verify.exam07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component(value = "exam07.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Member> list = Arrays.asList(
				new Member("홍길동", "개발자"),
				new Member("김나리", "디자이너"),
				new Member("신용권", "개발자")
			);
		
		List<Member> developers = list.stream()
				.filter(a -> a.getJob().equals("개발자"))
				.collect(Collectors.toList());
		
		developers.stream().forEach(a -> System.out.println(a));
	}
	
	@Data
	@AllArgsConstructor
	//private static class Member {  // OK
	private class Member {   // OK
		private String name;
		private String job;
	}
}
