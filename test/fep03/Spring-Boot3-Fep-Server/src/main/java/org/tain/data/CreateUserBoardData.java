package org.tain.data;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.domain.Board;
import org.tain.domain.User;
import org.tain.domain.enums.BoardType;
import org.tain.domain.enums.SocialType;
import org.tain.repository.BoardRepository;
import org.tain.repository.UserRepository;
import org.tain.utils.ClassUtil;

@Component(value = "data.CreateUserBoardData")
public class CreateUserBoardData {

	private static final boolean flag = true;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	public CreateUserBoardData() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	@Bean(value = "data.CreateUserBoardData.create")
	public void create() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		@SuppressWarnings("unused")
		User user = this.userRepository.save(
				User.builder()
					.name("havi")
					.password("pass")
					.email("havi@gmail.com")
					.principal("chief")
					.socialType(SocialType.GOOGLE)
					.createdDate(LocalDateTime.now())
					.updatedDate(LocalDateTime.now())
					.build()
		);
		
		IntStream.rangeClosed(1, 201).forEach(index ->
				this.boardRepository.save(
						Board.builder()
							.title("제목" + index)
							.subTitle("부제목" + index)
							.content("내용입니다....")
							.boardType(BoardType.FREE)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.user(user)
							.build()
				)
		);
	}
}
