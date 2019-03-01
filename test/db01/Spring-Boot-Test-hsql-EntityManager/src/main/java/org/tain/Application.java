package org.tain;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.tain.domain.Fuga;
import org.tain.domain.Hoge;
import org.tain.repository.HogeRepository;

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

	@Autowired
	private EntityManager em;
	
	public void method() {
		TypedQuery<Hoge> query = this.em.createQuery("SELECT h FROM Hoge h WHERE h.id=:id", Hoge.class);
		query.setParameter("id", 3L);
		
		Hoge hoge = query.getSingleResult();
		
		System.out.println(hoge);
	}
}
