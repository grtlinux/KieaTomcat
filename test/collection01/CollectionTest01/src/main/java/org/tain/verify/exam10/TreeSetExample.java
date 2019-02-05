package org.tain.verify.exam10;

import java.util.TreeSet;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "TreeSetExample")
public class TreeSetExample {

	public TreeSetExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		TreeSet<Student> treeSet = new TreeSet<Student>();
		treeSet.add(new Student("blue", 96));
		treeSet.add(new Student("hong", 86));
		treeSet.add(new Student("white", 92));
		
		Student student = treeSet.last();
		System.out.println("최고점수: " + student.getScore());
		System.out.println("최고점수를 받은 아이디: " + student.getId());
	}
}
