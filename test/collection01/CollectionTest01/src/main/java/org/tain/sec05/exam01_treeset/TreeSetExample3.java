package org.tain.sec05.exam01_treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "TreeSetExample3")
public class TreeSetExample3 {

	public TreeSetExample3() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("apple");
		treeSet.add("forever");		
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
		for(String word : rangeSet) {
			System.out.println(word);
		}
	}
}
