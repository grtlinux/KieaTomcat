package org.tain.sec05.exam06_predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "PredicateExample")
public class PredicateExample {

	public PredicateExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		double maleAvg = avg(t -> t.getSex().equals("남자"));
		System.out.println("남자 평균 점수: " + maleAvg);
		
		double femailAvg = avg(t -> t.getSex().equals("여자"));
		System.out.println("여자 평균 점수: " + femailAvg);
	}
	
	private List<Student> list = Arrays.asList(
			new Student("홍길동", "남자", 90),
			new Student("김순희", "여자", 90),
			new Student("김자바", "남자", 95),
			new Student("박한나", "여자", 92)
			);
	
	private double avg(Predicate<Student> predicate) {
		int count = 0;
		int sum = 0;
		
		for (Student student : list) {
			if (predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		
		return (double) sum / count;
	}
}
