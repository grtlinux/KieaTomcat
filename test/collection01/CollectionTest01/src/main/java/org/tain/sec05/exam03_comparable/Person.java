package org.tain.sec05.exam03_comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable<Person> {

	private String name;
	private int age;
	
	@Override
	public int compareTo(Person o) {
		if (age < o.age) return -1;
		else if (age == o.age) return 0;
		else return 1;
	}
}
