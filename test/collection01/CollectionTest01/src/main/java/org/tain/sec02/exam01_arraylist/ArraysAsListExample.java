package org.tain.sec02.exam01_arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ArraysAsListExample")
public class ArraysAsListExample {

	public ArraysAsListExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		String[] strings = new String[] {
				"홍길동",
				"신용권",
				"김자바",
				"용시나",
		};
		List<String> list = null;
		list = Arrays.asList(strings);
		list = new ArrayList<>(Arrays.asList(strings));
		
		Set<String> set = null;
		set = new HashSet<>(Arrays.asList(strings));
		if (set.contains("김자바")) System.out.println("contain");
		else System.out.println("not contain");
		
		for (String name : list) {
			System.out.println("> " + name);
		}
		System.out.println();
		
		List<Integer> list2 = Arrays.asList(1, 3, 5, 2, 9);
		for (int value : list2) {
			System.out.println("> " + value);
		}
		System.out.println();
	}
}
