package org.tain.sec05.exam03_comparable;

import java.util.Iterator;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ComparableExample")
public class ComparableExample {

	public ComparableExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("감자바", 31));
		treeSet.add(new Person("박지원", 25));
		
		Iterator<Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.getName() + ":" + person.getAge());
		}
		System.out.println();
	}
}
