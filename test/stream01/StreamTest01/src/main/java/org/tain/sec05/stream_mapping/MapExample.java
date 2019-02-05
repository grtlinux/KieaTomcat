package org.tain.sec05.stream_mapping;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "MapExample")
public class MapExample {

	public MapExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
		);
		
		studentList.stream()
			.mapToInt(Student::getScore)
			.forEach(score -> System.out.println("> " + score));
		System.out.println();
	}
}
