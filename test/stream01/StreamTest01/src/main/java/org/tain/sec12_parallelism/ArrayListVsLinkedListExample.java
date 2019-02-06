package org.tain.sec12_parallelism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ArrayListVsLinkedListExample")
public class ArrayListVsLinkedListExample {

	public ArrayListVsLinkedListExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		//소스 컬렉션
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		for(int i=0; i<1000000; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
		//워밍업
		long arrayListListParallel = testParallel(arrayList);
		long linkedListParallel = testParallel(linkedList);
		
		//병렬 스트림 처리 시간 구하기
		arrayListListParallel = testParallel(arrayList);
		linkedListParallel = testParallel(linkedList);
		System.out.println("arrayListListParallel: " + arrayListListParallel);
		System.out.println("linkedListParallel: " + linkedListParallel);
		
		if(arrayListListParallel < linkedListParallel) {
			System.out.println("성능 테스트 결과: ArrayList 처리가 더빠름");
		} else {
			System.out.println("성능 테스트 결과: LinkedList 처리가 더빠름");
		}
	}

	//요소 처리
	public void work(int value) {
	}
	
	//병렬 처리
	public long testParallel(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().parallel().forEach((a)-> work(a));
		long end = System.nanoTime();
	    long runTime = end - start;
	    return runTime;
	}
}
