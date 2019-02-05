package org.tain.verify.exam07;

import java.util.List;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ListExample")
public class ListExample {

	public ListExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}
		System.out.println();
	}
}
