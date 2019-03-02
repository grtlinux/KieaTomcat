package org.tain.data;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.domain.Board;
import org.tain.domain.enums.BoardType;
import org.tain.repository.BoardRepository;
import org.tain.utils.ClassUtil;

@Component
public class CreateData {

	private static final boolean flag = true;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Bean
	public void create() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (!flag) return;
		
		this.boardRepository.deleteAllInBatch();
		
		IntStream.rangeClosed(1, 201).forEach(index ->
			this.boardRepository.save(
					Board.builder()
						.title("제목-" + index)
						.subTitle("부제목-" + index)
						.content("내용입니다.")
						.boardType(BoardType.free)
						.createdDate(LocalDateTime.now())
						.updatedDate(LocalDateTime.now())
						.build()
			)
		);
	}
}
