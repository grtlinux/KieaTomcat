package org.tain.sec05.exam02_treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "TreeMapExample3")
public class TreeMapExample3 {

	public TreeMapExample3() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
		treeMap.put("apple", new Integer(10));
		treeMap.put("forever", new Integer(60));		
		treeMap.put("description", new Integer(40));
		treeMap.put("ever", new Integer(50));
		treeMap.put("zoo", new Integer(10));
		treeMap.put("base", new Integer(20));
		treeMap.put("guess", new Integer(70));
		treeMap.put("cherry", new Integer(30));
		System.out.println(">>>>> " + treeMap);
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableMap<String,Integer> rangeMap = treeMap.subMap("c", true, "f", true);
		for(Map.Entry<String, Integer> entry : rangeMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue() + "페이지");
		}
		System.out.println();
	}
}
