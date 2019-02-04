package org.tain.sec05.exam04_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("FunctionalExample1")
public class FunctionalExample1 {

	public FunctionalExample1() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		System.out.print("[학생 이름]");
		printString(t -> t.getName());
		
		System.out.print("[영어 점수]");
		printInt(t -> t.getEnglishScore());
		
		System.out.print("[수학 점수]");
		printInt(t -> t.getMathScore());
	}

	private List<Student> list = Arrays.asList(
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93)
			);
	
	private void printString(Function<Student, String> function) {
		for (Student student : list) {
			System.out.print(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	private void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.print(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
}
