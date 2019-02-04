package org.tain.verity.exam06;

import java.util.function.ToIntFunction;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component(value = "exam06.LambdaExample")
public class LambdaExample {

	public LambdaExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		System.out.println(">>>>> s -> s.getEnglishScore()");
		
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("영어 평균 점수: " + englishAvg);

		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
	}

	private double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for (Student student : students) {
			sum += function.applyAsInt(student);
		}
		double avg = (double) sum / students.length;
		return avg;
	}
	
	@Data
	@AllArgsConstructor
	class Student {
		private String name;
		private int englishScore;
		private int mathScore;
	}
	
	private Student[] students = {
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93)
	};
}
