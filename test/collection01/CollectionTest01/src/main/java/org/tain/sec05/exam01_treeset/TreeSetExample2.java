package org.tain.sec05.exam01_treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "TreeSetExample2")
public class TreeSetExample2 {

	public TreeSetExample2() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(Integer score : descendingSet) {
			System.out.print(score + " ");
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer score : ascendingSet) {
			System.out.print(score + " ");
		}
		System.out.println();
	}
}
