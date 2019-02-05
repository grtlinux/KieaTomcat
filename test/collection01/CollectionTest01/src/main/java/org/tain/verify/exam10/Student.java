package org.tain.verify.exam10;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

	private String id;
	private int score;
	
	@Override
	public int compareTo(Student o) {
		if (score < o.score) return -1;
		else if (score == o.score) return 0;
		else return 1;
	}
}
