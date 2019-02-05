package org.tain.sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "HashSetExample1")
public class HashSetExample1 {

	public HashSetExample1() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		System.out.println(">>>> " + set);
		
		int size = set.size();
		System.out.println("총 객체수: " + size);
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체수: " + set.size());
		for(String element : set) {
			System.out.println("\t" + element);
		}
		
		set.clear();		
		if(set.isEmpty()) { System.out.println("비어 있음"); }
	}
}
