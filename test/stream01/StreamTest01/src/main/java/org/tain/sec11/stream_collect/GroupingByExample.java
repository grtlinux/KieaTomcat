package org.tain.sec11.stream_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "GroupingByExample")
public class GroupingByExample {

	public GroupingByExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		List<Student> totalList = Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("김수애", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student("신용권", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("박수미", 6, Student.Sex.FEMALE, Student.City.Seoul)
		);

		Map<Student.Sex, List<Student>> mapBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex));
		System.out.print("[남학생] ");
		mapBySex.get(Student.Sex.MALE).stream().forEach(s->System.out.print(s.getName() + " "));
		System.out.println();
		System.out.print("[여학생] ");
		mapBySex.get(Student.Sex.FEMALE).stream().forEach(s->System.out.print(s.getName() + " "));

		System.out.println();

		Map<Student.City, List<String>> mapByCity = totalList.stream()
				.collect(
						Collectors.groupingBy(
								Student::getCity,
								Collectors.mapping(Student::getName, Collectors.toList())
						)
				);
		System.out.println();
		System.out.print("[서울] ");
		mapByCity.get(Student.City.Seoul).stream().forEach(s->System.out.print(s + " "));
		System.out.println();
		System.out.print("[부산] ");
		mapByCity.get(Student.City.Pusan).stream().forEach(s->System.out.print(s + " "));
	}
}
