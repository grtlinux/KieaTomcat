package org.tain.verify.exam08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "HashSetExample")
public class HashSetExample {

	public HashSetExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.getStudentNum() + ":" + student.getName());
		}
		System.out.println();
	}
}
