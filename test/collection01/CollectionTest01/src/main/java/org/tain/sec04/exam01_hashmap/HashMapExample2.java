package org.tain.sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "HashMapExample2")
public class HashMapExample2 {

	public HashMapExample2() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 95);
		
		System.out.println("총 Entry 수: " + map.size());
	}
}
