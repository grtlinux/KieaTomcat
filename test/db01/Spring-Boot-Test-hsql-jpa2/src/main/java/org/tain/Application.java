package org.tain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.tain.domain.Fuga;
import org.tain.domain.Hoge;
import org.tain.repository.HogeRepository;

/*
 * JPA를 사용하는 경우에는 org.springframework.boot:spring-boot-starter-data-jpa을 의존관계에 추가한다.
 * JPA 구현은 Hibernate가 이용된다.
 * 기본으로 테이블이 매번 다시 만들게 되므로 spring.jpa.hibernate.ddl-auto=update를 설정하고 있다.
 * JpaRepository를 상속한 인터페이스를 정의하면 Spring이 데이터 접근을 해준다.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
			Application app = ctx.getBean(Application.class);
			app.create();
			app.method();
		}
	}

	@Autowired
	private HogeRepository repository;

	public void create() {
		this.repository.deleteAllInBatch();
		
		Fuga hoge = new Fuga("hoge");
		Fuga fuga = new Fuga("fuga");
		Fuga piyo = new Fuga("piyo");
		
		this.repository.save(new Hoge(1, "one", hoge));
		this.repository.save(new Hoge(1, "two", fuga));
		this.repository.save(new Hoge(1, "three", piyo));
		this.repository.save(new Hoge(1, "four", hoge));
		this.repository.save(new Hoge(1, "five", fuga));
		this.repository.save(new Hoge(1, "six", piyo));
		this.repository.save(new Hoge(1, "seven", hoge));
	}

	public void method() {
		print("findByNumber", repository.findByNumber(1));
		print("findByNumberAndStringLike", repository.findByNumberAndStringLike(1, "%e"));
		print("findByNumberOrString", repository.findByNumberOrString(2, "seven"));
		print("findByNumberOrderByIdDesc", repository.findByNumberOrderByIdDesc(2));
		print("findByStringLike", repository.findByStringLike("t%"));
		print("findByNumberLessThan", repository.findByNumberLessThan(3));
		print("findByStringIgnoreCase", repository.findByStringIgnoreCase("FIVE"));
		print("findByFugaValue", repository.findByFugaValue("hoge"));
		print("countByStringLike", repository.countByStringLike("%o%"));
	}

	private void print(String methodName, List<Hoge> list) {
		System.out.println("<<" + methodName + ">>");
		list.forEach(System.out::println);
		System.out.println();
	}

	private void print(String methodName, long number) {
		System.out.println("<<" + methodName + ">>");
		System.out.println(number);
		System.out.println();
	}
}
