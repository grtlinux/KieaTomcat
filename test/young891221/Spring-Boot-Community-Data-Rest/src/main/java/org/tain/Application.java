package org.tain;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.domain.Board;
import org.tain.domain.User;
import org.tain.domain.enums.BoardType;
import org.tain.domain.enums.SocialType;
import org.tain.repository.BoardRepository;
import org.tain.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) {
		return (args) -> {
			User user = userRepository.save(
					User.builder()
						.name("havi")
						.password("test")
						.email("havi@gmail.com")
						.principal("cheif")
						.socialType(SocialType.GOOGLE)
						.createdDate(LocalDateTime.now())
						.updatedDate(LocalDateTime.now())
						.build()
			);
			
			IntStream.rangeClosed(1, 201).forEach(index ->
				boardRepository.save(
						Board.builder()
							.title("제목" + index)
							.subTitle("부제목" + index)
							.content("내용입니다.")
							.boardType(BoardType.free)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.user(user)
							.build()
				)
			);
			
			System.out.println(">>>>> data be loaded.....");
		};
	}
}
