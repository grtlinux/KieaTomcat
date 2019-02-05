package org.tain.sec02.stream_kind;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FromCollectionExample")
public class FromCollectionExample {

	public FromCollectionExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
			);
		
		Stream<Student> stream = studentList.stream();
		stream.forEach(s -> System.out.println(s.getName()));
		System.out.println();
	}
}
