package org.tain.sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "HashSetExample2")
public class HashSetExample2 {

	public HashSetExample2() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길삼", 30));
		
		System.out.println("총 객체수 : " + set.size());
		
		System.out.println(">>>>> " + set);
	}
}