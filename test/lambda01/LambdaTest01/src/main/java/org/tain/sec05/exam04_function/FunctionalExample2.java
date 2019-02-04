package org.tain.sec05.exam04_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("FunctionalExample2")
public class FunctionalExample2 {

	public FunctionalExample2() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("영어 평균 점수: " + englishAvg);
		
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
	}

	private List<Student> list = Arrays.asList(
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93)
			);
	
	private double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for (Student student : list) {
			sum += function.applyAsInt(student);
		}
		double avg = (double) sum / list.size();
		return avg;
	}
}
