package org.tain.verify.exam08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component(value = "exam08.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Member> list = Arrays.asList(
				new Member("홍길동", "개발자"),
				new Member("김나리", "디자이너"),
				new Member("신용권", "개발자")
			);
		
		Map<String, List<String>> groupingMap = list.stream()
				.collect(
						Collectors.groupingBy(
								Member::getJob,
								Collectors.mapping(Member::getName, Collectors.toList())
						)
				);
		System.out.print("[개발자] ");
		groupingMap.get("개발자").stream().forEach(a -> System.out.print(a + " "));
		System.out.println();
		
		System.out.print("[디자이너] ");
		groupingMap.get("디자이너").stream().forEach(a -> System.out.print(a + " "));
		System.out.println();
	}
	
	@Data
	@AllArgsConstructor
	private class Member {
		private String name;
		private String job;
	}
}
