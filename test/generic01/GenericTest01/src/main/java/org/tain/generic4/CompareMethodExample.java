package org.tain.generic4;

import org.springframework.stereotype.Component;

@Component
public class CompareMethodExample {

	public CompareMethodExample() {
		Pair<Integer, String> p1 = new Pair<>(1, "사과");
		Pair<Integer, String> p2 = new Pair<>(1, "사과");
		boolean result12 = Util.<Integer, String> compare(p1, p2);
		if (result12) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않는 객체입니다.");
		}
		
		Pair<String, String> p3 = new Pair<>("user1", "사과");
		Pair<String, String> p4 = new Pair<>("user2", "사과");
		boolean result34 = Util.<String, String> compare(p3, p4);
		if (result34) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않는 객체입니다.");
		}
	}
}
