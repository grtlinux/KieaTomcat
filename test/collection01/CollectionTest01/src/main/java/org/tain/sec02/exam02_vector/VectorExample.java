package org.tain.sec02.exam02_vector;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "VectorExample")
public class VectorExample {
	
	public VectorExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		List<Board> list = new Vector<>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for (int i=0; i < list.size(); i++) {
			System.out.println(i + ") " + list.get(i).getSubject() + ":" + list.get(i).getContent());
		}
	}
}
