package org.tain.sec11.stream_collect;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "MaleStudentExample")
public class MaleStudentExample {

	public MaleStudentExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Student> totalList = Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE),
				new Student("김수애", 6, Student.Sex.FEMALE),
				new Student("신용권", 10, Student.Sex.MALE),
				new Student("박수미", 6, Student.Sex.FEMALE)
		);
		
		MaleStudent maleStudent = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				//.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine); 
				.collect(()->new MaleStudent(), (r, t)->r.accumulate(t), (r1, r2)->r1.combine(r2));
		
		maleStudent.getList().stream()
			.forEach(s -> System.out.println(s.getName()));
	}
}
