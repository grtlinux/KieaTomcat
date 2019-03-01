package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.tain.domain.MyEntity;
import org.tain.repository.MyEntityRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		
		try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
			Application app = ctx.getBean(Application.class);
			app.method();
		}
	}

	@Autowired
	private MyEntityRepository repository;
	
	public void method() {
		this.repository.save(new MyEntity("test"));
		this.repository.findAll().forEach(System.out::println);
	}
}
